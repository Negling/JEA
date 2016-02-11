package kael.jea.character;

import java.util.ArrayList;

import de.ailis.pherialize.MixedArray;
import kael.jea.ReadOnlyArrayList;

/**
 * This is a {@link Personage} utility class, used to store and represent
 * information about specified personage inventory.
 * 
 * @author Kael
 * @since JEA1.0
 * @see Personage
 */
public class Inventory {
	/**
	 * Creates simple instance of {@link Inventory} class, with specified
	 * unserialized PHP array as input parameter.
	 * 
	 * @param data
	 * @see MixedArray
	 */
	protected Inventory(MixedArray data) {
		this.data = data.getArray("inv");
	}

	/**
	 * {@link Inventory} data storage.
	 * 
	 * @see MixedArray
	 */
	private MixedArray data;
	private ReadOnlyArrayList<Item> usableItems;
	private ReadOnlyArrayList<Item> clanStatueEquipment;
	private ReadOnlyArrayList<Item> instruments;
	private ReadOnlyArrayList<Item> clanObeliskTracery;
	private ReadOnlyArrayList<Item> presentsBonuses;
	private ReadOnlyArrayList<Item> sealBonuses;
	private ReadOnlyArrayList<Item> weapons;
	private ReadOnlyArrayList<Item> rings;
	private Item boots;
	private Item belt;
	private Item pants;
	private Item bracers;
	private Item gloves;
	private Item cloak;
	private Item chainmail;
	private Item armor;
	private Item helmet;
	private Item amulet;

	/**
	 * This method replacing old storage data and sets new.
	 * 
	 * @param data
	 *            specified {@link MixedArray}
	 */
	protected void refresh(MixedArray data) {
		this.data = data.getArray("inv");
		usableItems = null;
		clanStatueEquipment = null;
		instruments = null;
		clanObeliskTracery = null;
		presentsBonuses = null;
		sealBonuses = null;
		weapons = null;
		rings = null;
		boots = null;
		belt = null;
		pants = null;
		bracers = null;
		gloves = null;
		cloak = null;
		chainmail = null;
		armor = null;
		helmet = null;
		amulet = null;
	}

	/**
	 * Returns {@link Item} with character boots data, or null if character have
	 * no boots equipped.
	 * 
	 * @return specified {@link Item} value
	 */
	public Item getBoots() {
		if (boots == null) {
			setBoots();
		}
		return boots;
	}

	/**
	 * Returns {@link Item} with character belt data, or null if character have
	 * no belt equipped.
	 * 
	 * @return specified {@link Item} value
	 */
	public Item getBelt() {
		if (belt == null) {
			setBelt();
		}
		return belt;
	}

	/**
	 * Returns {@link Item} with character pants data, or null if character have
	 * no pants equipped.
	 * 
	 * @return specified {@link Item} value
	 */
	public Item getPants() {
		if (pants == null) {
			setPants();
		}
		return pants;
	}

	/**
	 * Returns {@link Item} with character bracers data, or null if character
	 * have no bracers equipped.
	 * 
	 * @return specified {@link Item} value
	 */
	public Item getBracers() {
		if (bracers == null) {
			setBracers();
		}
		return bracers;
	}

	/**
	 * Returns {@link Item} with character gloves data, or null if character
	 * have no gloves equipped.
	 * 
	 * @return specified {@link Item} value
	 */
	public Item getGloves() {
		if (gloves == null) {
			setGloves();
		}
		return gloves;
	}

	/**
	 * Returns {@link Item} with character cloak data, or null if character have
	 * no cloak equipped.
	 * 
	 * @return specified {@link Item} value
	 */
	public Item getCloak() {
		if (cloak == null) {
			setCloak();
		}
		return cloak;
	}

	/**
	 * Returns {@link Item} with character chain-mail data, or null if character
	 * have no chain-mail equipped.
	 * 
	 * @return specified {@link Item} value
	 */
	public Item getChainmail() {
		if (chainmail == null) {
			setChainmail();
		}
		return chainmail;
	}

	/**
	 * Returns {@link Item} with character armor data, or null if character have
	 * no armor equipped.
	 * 
	 * @return specified {@link Item} value
	 */
	public Item getArmor() {
		if (armor == null) {
			setArmor();
		}
		return armor;
	}

	/**
	 * Returns {@link Item} with character helmet data, or null if character
	 * have no helmet equipped.
	 * 
	 * @return specified {@link Item} value
	 */
	public Item getHelmet() {
		if (helmet == null) {
			setHelmet();
		}
		return helmet;
	}

	/**
	 * Returns {@link Item} with character amulet data, or null if character
	 * have no amulet equipped.
	 * 
	 * @return specified {@link Item} value
	 */
	public Item getAmulet() {
		if (amulet == null) {
			setAmulet();
		}
		return amulet;
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with character seal's bonuses data, or
	 * null if character have no seal's bonuses equipped.
	 * 
	 * @return specified {@link ReadOnlyArrayList} value
	 */
	public ReadOnlyArrayList<Item> getSealBonuses() {
		if (sealBonuses == null) {
			setSealBonuses();
		}
		return sealBonuses;
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with character usable items data, or
	 * null if character have no usable items equipped.
	 * 
	 * @return specified {@link ReadOnlyArrayList} value
	 */
	public ReadOnlyArrayList<Item> getUsableItems() {
		if (usableItems == null) {
			setUsableItems();
		}
		return usableItems;
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with character clan statue equipment
	 * data, or null if character ain't in clan.
	 * 
	 * @return specified {@link ReadOnlyArrayList} value
	 */
	public ReadOnlyArrayList<Item> getClanStatueEquipment() {
		if (clanStatueEquipment == null) {
			setClanStatueEquipment();
		}
		return clanStatueEquipment;
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with character instruments data, or
	 * null if character have no instruments equipped.
	 * 
	 * @return specified {@link ReadOnlyArrayList} value
	 */
	public ReadOnlyArrayList<Item> getInstruments() {
		if (instruments == null) {
			setInstruments();
		}
		return instruments;
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with character clan obelisk tracery
	 * data, or null if character ain't in clan.
	 * 
	 * @return specified {@link ReadOnlyArrayList} value
	 */
	public ReadOnlyArrayList<Item> getClanObeliskTracery() {
		if (clanObeliskTracery == null) {
			setClanObeliskTracery();
		}
		return clanObeliskTracery;
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with character presents bonuses data,
	 * or null if character have no presents bonuses.
	 * 
	 * @return specified {@link ReadOnlyArrayList} value
	 */
	public ReadOnlyArrayList<Item> getPresentsBonuses() {
		if (presentsBonuses == null) {
			setPresentsBonuses();
		}
		return presentsBonuses;
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with character rings data, or null if
	 * character have no rings equipped.
	 * 
	 * @return specified {@link ReadOnlyArrayList} value
	 */
	public ReadOnlyArrayList<Item> getRings() {
		if (rings == null) {
			setRings();
		}
		return rings;
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with character weapons data, or null if
	 * character have no weapons equipped.
	 * 
	 * @return specified {@link ReadOnlyArrayList} value
	 */
	public ReadOnlyArrayList<Item> getWeapons() {
		if (weapons == null) {
			setWeapons();
		}
		return weapons;
	}

	/**
	 * Fills character amulet {@link Item} with specified data, or sets null, if
	 * character have no amulet equipped.
	 */
	private void setAmulet() {
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 27) {
				amulet = new Item(data.getArray(key));
				return;
			}
		}
		amulet = null;
	}

	/**
	 * Fills character helmet {@link Item} with specified data, or sets null, if
	 * character have no helmet equipped.
	 */
	private void setHelmet() {
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 25) {
				helmet = new Item(data.getArray(key));
				return;
			}
		}
		helmet = null;
	}

	/**
	 * Fills character armor {@link Item} with specified data, or sets null, if
	 * character have no armor equipped.
	 */
	private void setArmor() {
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 21) {
				armor = new Item(data.getArray(key));
				return;
			}
		}
		armor = null;
	}

	/**
	 * Fills character chain-mail {@link Item} with specified data, or sets
	 * null, if character have no chain-mail equipped.
	 */
	private void setChainmail() {
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 20) {
				chainmail = new Item(data.getArray(key));
				return;
			}
		}
		chainmail = null;
	}

	/**
	 * Fills character cloak {@link Item} with specified data, or sets null, if
	 * character have no cloak equipped.
	 */
	private void setCloak() {
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 22) {
				cloak = new Item(data.getArray(key));
				return;
			}
		}
		cloak = null;
	}

	/**
	 * Fills character gloves {@link Item} with specified data, or sets null, if
	 * character have no gloves equipped.
	 */
	private void setGloves() {
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 26) {
				gloves = new Item(data.getArray(key));
				return;
			}
		}
		gloves = null;
	}

	/**
	 * Fills character bracers {@link Item} with specified data, or sets null,
	 * if character have no bracers equipped.
	 */
	private void setBracers() {
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 29) {
				bracers = new Item(data.getArray(key));
				return;
			}
		}
		bracers = null;
	}

	/**
	 * Fills character pants {@link Item} with specified data, or sets null, if
	 * character have no pants equipped.
	 */
	private void setPants() {
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 19) {
				pants = new Item(data.getArray(key));
				return;
			}
		}
		pants = null;
	}

	/**
	 * Fills character belt {@link Item} with specified data, or sets null, if
	 * character have no belt equipped.
	 */
	private void setBelt() {
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 28) {
				belt = new Item(data.getArray(key));
				return;
			}
		}
		belt = null;
	}

	/**
	 * Fills character boots {@link Item} with specified data, or sets null, if
	 * character have no boots equipped.
	 */
	private void setBoots() {
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 23) {
				boots = new Item(data.getArray(key));
				return;
			}
		}
		boots = null;
	}

	/**
	 * Fills character clan obelisk tracery {@link ReadOnlyArrayList} with
	 * specified data, or sets null, if character ain't in clan.
	 */
	private void setClanObeliskTracery() {
		ArrayList<Item> items = new ArrayList<>();
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 96) {
				items.add(new Item(data.getArray(key)));
			}
		}
		if (!items.isEmpty()) {
			clanObeliskTracery = new ReadOnlyArrayList<>(items);
		} else {
			clanObeliskTracery = null;
		}
	}

	/**
	 * Fills character instruments {@link ReadOnlyArrayList} with specified
	 * data, or sets null, if character have no instruments equipped.
	 */
	private void setInstruments() {
		ArrayList<Item> items = new ArrayList<>();
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 10) {
				items.add(new Item(data.getArray(key)));
			}
		}
		if (!items.isEmpty()) {
			instruments = new ReadOnlyArrayList<>(items);
		} else {
			instruments = null;
		}
	}

	/**
	 * Fills character usable items {@link ReadOnlyArrayList} with specified
	 * data, or sets null, if character have no usable items equipped.
	 */
	private void setUsableItems() {
		ArrayList<Item> items = new ArrayList<>(3);
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 50 || data.getArray(key).getInt("w_category") == 53) {
				items.add(new Item(data.getArray(key)));
			}
		}
		if (!items.isEmpty()) {
			usableItems = new ReadOnlyArrayList<>(items);
		} else {
			usableItems = null;
		}
	}

	/**
	 * Fills character clan statue equipment {@link ReadOnlyArrayList} with
	 * specified data, or sets null, if character ain't in clan.
	 */
	private void setClanStatueEquipment() {
		ArrayList<Item> items = new ArrayList<>(10);
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 107) {
				items.add(new Item(data.getArray(key)));
			}
		}
		if (!items.isEmpty()) {
			clanStatueEquipment = new ReadOnlyArrayList<>(items);
		} else {
			clanStatueEquipment = null;
		}
	}

	/**
	 * Fills character presents bonuses {@link ReadOnlyArrayList} with specified
	 * data, or sets null, if character have no presents bonuses equipped.
	 */
	private void setPresentsBonuses() {
		ArrayList<Item> items = new ArrayList<>(10);
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 98) {
				items.add(new Item(data.getArray(key)));
			}
		}
		if (!items.isEmpty()) {
			presentsBonuses = new ReadOnlyArrayList<>(items);
		} else {
			presentsBonuses = null;
		}
	}

	/**
	 * Fills character seal's bonuses {@link ReadOnlyArrayList} with specified
	 * data, or sets null, if character have no seal's bonuses equipped.
	 */
	private void setSealBonuses() {
		ArrayList<Item> items = new ArrayList<>(2);
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 102) {
				items.add(new Item(data.getArray(key)));
			}
		}
		if (!items.isEmpty()) {
			sealBonuses = new ReadOnlyArrayList<>(items);
		} else {
			sealBonuses = null;
		}
	}

	/**
	 * Fills character rings {@link ReadOnlyArrayList} with specified data, or
	 * sets null, if character have no rings equipped.
	 */
	private void setRings() {
		ArrayList<Item> items = new ArrayList<>(6);
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") == 24 || data.getArray(key).getInt("w_category") == 31) {
				items.add(new Item(data.getArray(key)));
			}
		}
		if (!items.isEmpty()) {
			rings = new ReadOnlyArrayList<>(items);
		} else {
			rings = null;
		}
	}

	/**
	 * Fills character weapons {@link ReadOnlyArrayList} with specified data, or
	 * sets null, if character have no weapons equipped.
	 */
	private void setWeapons() {
		ArrayList<Item> items = new ArrayList<>(2);
		for (Object key : data.keySet()) {
			if (data.getArray(key).getInt("w_category") < 7) {
				items.add(new Item(data.getArray(key)));
			}
		}
		if (!items.isEmpty()) {
			weapons = new ReadOnlyArrayList<>(items);
		} else {
			weapons = null;
		}
	}
}