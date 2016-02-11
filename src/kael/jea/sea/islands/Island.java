package kael.jea.sea.islands;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import kael.jea.ReadOnlyArrayList;
import kael.jea.interfaces.Timed;
import kael.jea.sea.islands.IslandDOM.Sector;

/**
 * This is abstract interface, which able to work with geologist islands API
 * structure.
 * 
 * @author Kael
 * @since JEA1.0
 * @see {@link TurquoiseIsland} , {@link MalachiteIsland}
 */
public abstract class Island implements Timed {
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
		for (Sector sector : data.getSectors()) {
			for (int iD : sector.getClanOwners()) {
				if (iD == clanId) {
					sectors.add(sector.getLocation());
				}
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
		for (Sector sector : data.getSectors()) {
			for (int iD : sector.getHeroOwners()) {
				if (iD == characterId) {
					sectors.add(sector.getLocation());
				}
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
		for (Sector sector : data.getSectors()) {
			if (sector.getLocation().equals(location)) {
				return sector.getClanOwners();
			}
		}
		return null;
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
		for (Sector sector : data.getSectors()) {
			if (sector.getLocation().equals(location)) {
				return sector.getHeroOwners();
			}
		}
		return null;
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
		for (Sector sector : data.getSectors()) {
			if (sector.getLocation().equals(location)) {
				if (sector.getResourceCount() > 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * Returns true if explored sector no contains ore, or ore value is 0.
	 * Otherwise returns false.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @return boolean value
	 */
	public boolean emptySector(String location) {
		for (Sector sector : data.getSectors()) {
			if (sector.getLocation().equals(location)) {
				if (sector.getResourceId() == 0) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
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
		for (Sector sector : data.getSectors()) {
			if (sector.getLocation().equals(location)) {
				for (int iD : sector.getClanOwners()) {
					if (iD == clanId) {
						return true;
					}
				}
				break;
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
		for (Sector sector : data.getSectors()) {
			if (sector.getLocation().equals(location)) {
				for (int iD : sector.getHeroOwners()) {
					if (iD == characterId) {
						return true;
					}
				}
				break;
			}
		}
		return false;
	}

	/**
	 * Returns sector sign id as integer. If sector not found returns -1.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @return integer value
	 */
	public int getSectorSignId(String location) {
		for (Sector sector : data.getSectors()) {
			if (sector.getLocation().equals(location)) {
				return sector.getObjectId();
			}
		}
		return -1;
	}

	/**
	 * Returns sector available ore. If sector not found returns -1.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @return integer value
	 */
	public int getSectorAviliableOre(String location) {
		for (Sector sector : data.getSectors()) {
			if (sector.getLocation().equals(location)) {
				return sector.getResourceCount();
			}
		}
		return -1;
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
		boolean isOwner;
		for (Sector sector : data.getSectors()) {
			isOwner = false;
			for (int iD : sector.getHeroOwners()) {
				if (iD == characterId) {
					isOwner = true;
				}
			}
			if (isOwner) {
				aviliableOre += sector.getResourceCount();
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
		boolean isOwner;
		for (Sector sector : data.getSectors()) {
			isOwner = false;
			for (int iD : sector.getClanOwners()) {
				if (iD == clanId) {
					isOwner = true;
				}
			}
			if (isOwner) {
				aviliableOre += sector.getResourceCount();
			}
		}
		return aviliableOre;
	}

	/**
	 * Returns sector resource id as integer. If sector not found returns -1.
	 * 
	 * @param location
	 *            - location id in string representation
	 * @return integer value
	 */
	public int getSectorResourceId(String location) {
		for (Sector sector : data.getSectors()) {
			if (sector.getLocation().equals(location)) {
				return sector.getResourceId();
			}
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
