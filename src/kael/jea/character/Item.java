package kael.jea.character;

import de.ailis.pherialize.MixedArray;

/**
 * This is a {@link Inventory} utility class, used to store and represent
 * information about specified personage items.
 * 
 * @author Kael
 * @since JEA1.0
 * @see Inventory
 */
public class Item {
	/**
	 * Creates simple instance of Item class, with specified unserialized PHP
	 * array as input parameter.
	 * 
	 * @param data
	 * @see MixedArray
	 */
	protected Item(MixedArray itemData) {
		this.itemData = itemData;
	}

	/**
	 * Item data storage.
	 * 
	 * @see MixedArray
	 */
	private MixedArray itemData;

	/**
	 * Returns item name.
	 * 
	 * @return specified string value
	 */
	public String name() {
		return itemData.getString("w_name");
	}

	/**
	 * Returns item image path.
	 * 
	 * <pre>
	 * Example: "https://img.ereality.ru/68x-/w/kit/armor.png"
	 * </pre>
	 * 
	 * @return specified string value
	 */
	public String imagePath() {
		return "https://img.ereality.ru/68x-/w/" + itemData.getString("w_image");
	}

	/**
	 * Returns item expiration date as Unix TimeStamp value. If item has no
	 * expiration time returns 0.
	 * 
	 * @return specified long value
	 */
	public long expirationDate() {
		return itemData.getLong("w_tr_time");
	}

	/**
	 * Returns item first rune expiration date as Unix TimeStamp value. If item
	 * has no rune returns 0.
	 * 
	 * @return specified long value
	 */
	public long firstRuneExpirationdate() {
		return itemData.getLong("w_rune_t1");
	}

	/**
	 * Returns item second rune expiration date as Unix TimeStamp value. If item
	 * has no rune returns 0.
	 * 
	 * @return specified long value
	 */
	public long secondRuneExpirationdate() {
		return itemData.getLong("w_rune_t2");
	}

	/**
	 * Returns current item ID.
	 * 
	 * @return specified integer value
	 */
	public int itemId() {
		return itemData.getInt("uid");
	}

	/**
	 * Returns current item global ID.
	 * 
	 * @return specified integer value
	 */
	public int globalItemId() {
		return itemData.getInt("w_id");
	}

	/**
	 * Returns item level requirement.
	 * 
	 * @return specified integer value
	 */
	public int levelRequirement() {
		return itemData.getInt("w_n_level");
	}

	/**
	 * Returns 1 if item is in a right hand, 2 if is in left. Otherwise, returns
	 * 0 if item ain't weapon.
	 * 
	 * @return specified integer value
	 */
	public int handThatHandleItem() {
		return itemData.getInt("w_num");
	}

	/**
	 * Returns item category.
	 * 
	 * @return specified integer value
	 */
	public int category() {
		return itemData.getInt("w_category");
	}

	/**
	 * Returns item current condition.
	 * 
	 * @return specified integer value
	 */
	public int currentCondition() {
		return itemData.getInt("w_cursolid");
	}

	/**
	 * Returns item max condition.
	 * 
	 * @return specified integer value
	 */
	public int maxCondition() {
		return itemData.getInt("w_maxsolid");
	}

	/**
	 * Returns item minimal damage bonus.
	 * 
	 * @return specified integer value
	 */
	public int minDamageBonus() {
		return itemData.getInt("w_add_min_dam");
	}

	/**
	 * Returns item maximal damage bonus.
	 * 
	 * @return specified integer value
	 */
	public int maxDamageBonus() {
		return itemData.getInt("w_add_max_dam");
	}

	/**
	 * Returns item first rune id. If item has no rune - returns 0.
	 * 
	 * @return specified integer value
	 */
	public int firstRuneId() {
		return itemData.getInt("w_rune1");
	}

	/**
	 * Returns item second rune id. If item has no rune - returns 0.
	 * 
	 * @return specified integer value
	 */
	public int secondRuneId() {
		return itemData.getInt("w_rune2");
	}
}
