package kael.jea.sea.islands;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kael.jea.interfaces.Timed;
import kael.jea.interfaces.Updatable;
import kael.jea.utils.ReadOnlyArrayList;

/**
 * This is abstract interface, which able to work with geologist islands API
 * structure.
 * 
 * @author Kael
 * @since JEA1.0
 * @see {@link TurquoiseIsland} , {@link MalachiteIsland}
 */
public abstract class Island implements Updatable, Timed {
	/**
	 * Creates abstract Island class.
	 * 
	 * @param IslandDOM
	 *            data object model
	 */
	protected Island(IslandDOM data) {
		this.data = data;
	}

	private IslandDOM data;
	protected static Gson gsonInstance = new GsonBuilder().registerTypeAdapter(IslandDOM.class, new IslandDOMDesializer())
			.create();

	/**
	 * Sets new DOM to island.
	 * 
	 * @param data
	 */
	protected void setData(IslandDOM data) {
		this.data = data;
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with Island sectors in String
	 * representation, which current clan own at moment. Returns <b>null</b> if
	 * clan own no sectors.
	 * 
	 * @param clanId
	 *            value of clan id
	 * @return {@link ReadOnlyArrayList} list
	 */
	public ReadOnlyArrayList<String> getSectorsClanOwn(int clanId) {
		ArrayList<String> sectors = new ArrayList<>();
		for (String location : data.getSectors().keySet()) {
			if (isClanAviliableToMine(clanId, location)) {
				sectors.add(location);
			}
		}
		if (sectors.isEmpty()) {
			return null;
		} else {
			return new ReadOnlyArrayList<>(sectors);
		}
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with Island sectors in String
	 * representation, which current character own at moment. Returns
	 * <b>null</b> if character own no sectors.
	 * 
	 * @param characterId
	 *            - value of character id
	 * @return {@link ReadOnlyArrayList} list
	 */
	public ReadOnlyArrayList<String> getSectorsCharacterOwn(int characterId) {
		ArrayList<String> sectors = new ArrayList<>();
		for (String location : data.getSectors().keySet()) {
			if (isCharacterAviliableToMine(characterId, location)) {
				sectors.add(location);
			}
		}
		if (sectors.isEmpty()) {
			return null;
		} else {
			return new ReadOnlyArrayList<>(sectors);
		}
	}

	/**
	 * Returns int[] array with Id's all sector clan owners. Returns <b>null</b>
	 * if no clan owns sector.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @return int[] array
	 */
	public int[] getSectorClanOwnersId(String location) {
		return data.getSectors().get(location).getClanOwners();
	}

	/**
	 * Returns int[] array with Id's all sector character owners. Returns
	 * <b>null</b> if no character owns sector.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @return int[] array
	 */
	public int[] getSectorCharacterOwnersId(String location) {
		return data.getSectors().get(location).getHeroOwners();
	}

	/**
	 * Returns true if explored sector contains ore, and ore value more than 0.
	 * Otherwise returns false.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @return boolean value
	 */
	public boolean containsOre(String location) {
		return getSectorAviliableOre(location) > 0;
	}

	/**
	 * Returns true if explored sector contains no ore. Otherwise returns false.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @return boolean value
	 */
	public boolean emptySector(String location) {
		return getSectorResourceId(location) <= 0;
	}

	/**
	 * Returns true if specified clan is an owner of selected sector. Otherwise
	 * returns false.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @param clanId
	 *            - value of clan id
	 * @return boolean value
	 */
	public boolean isClanAviliableToMine(int clanId, String location) {
		if (getSectorResourceId(location) > 0) {
			for (int iD : getSectorClanOwnersId(location)) {
				if (iD == clanId) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns true if specified character is an owner of selected sector.
	 * Otherwise returns false.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @param characterId
	 *            - value of character id
	 * @return boolean value
	 */
	public boolean isCharacterAviliableToMine(int characterId, String location) {
		if (getSectorResourceId(location) > 0) {
			for (int iD : getSectorCharacterOwnersId(location)) {
				if (iD == characterId) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns value of all available to current character ore.
	 * 
	 * @param characterId
	 *            - value of character id
	 * @return integer value
	 */
	public int getCharacterAviliableOre(int characterId) {
		int aviliableOre = 0;
		for (String location : data.getSectors().keySet()) {
			if (isCharacterAviliableToMine(characterId, location)) {
				aviliableOre += data.getSectors().get(location).getResourceCount();
			}
		}
		return aviliableOre;
	}

	/**
	 * Returns value of all available to current clan ore.
	 * 
	 * @param clanId
	 *            - value of clan id
	 * @return integer value
	 */
	public int getClanAviliableOre(int clanId) {
		int aviliableOre = 0;
		for (String location : data.getSectors().keySet()) {
			if (isClanAviliableToMine(clanId, location)) {
				aviliableOre += data.getSectors().get(location).getResourceCount();
			}
		}
		return aviliableOre;
	}

	/**
	 * Returns sector sign id as integer. If sector not found returns -1.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @return integer value
	 */
	public int getSectorSignId(String location) {
		if (data.getSectors().get(location) != null) {
			return data.getSectors().get(location).getObjectId();
		}
		return -1;
	}

	/**
	 * Returns sector available ore. If sector not found, or empty - returns -1.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @return integer value
	 */
	public int getSectorAviliableOre(String location) {
		if (getSectorResourceId(location) > 0) {
			return data.getSectors().get(location).getResourceCount();
		}
		return -1;
	}

	/**
	 * Returns sector resource id as integer. If sector not found returns -1.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @return integer value
	 */
	public int getSectorResourceId(String location) {
		if (data.getSectors().get(location) != null) {
			return data.getSectors().get(location).getResourceId();
		}
		return -1;
	}

	public String infoDateAsString() {
		return data.getCreatedAt().getFormattedTime();
	}

	public GregorianCalendar infoDate() {
		return data.getCreatedAt().getStampAsDate();
	}
}
