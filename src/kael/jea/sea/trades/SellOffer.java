package kael.jea.sea.trades;

/**
 * This is a utility class, used to represent information about islands sell
 * offer's.
 * 
 * @author Kael
 * @since JEA1.0
 * @see BuyOffer
 */
public class SellOffer {
	/**
	 * Creates simple instance of SellOffer class.
	 * 
	 * @param islandId
	 *            - island id, that is currently selling product
	 * @param goodsId
	 *            - specified product id
	 * @param sellPrice
	 *            - price, that shop will sell product
	 * @param amount
	 *            - amount of product
	 */
	protected SellOffer(int islandId, int goodsId, double sellPrice, int amount) {
		this.islandId = islandId;
		this.goodsId = goodsId;
		this.sellPrice = sellPrice;
		this.amount = amount;
	}

	private int islandId;
	private int goodsId;
	private double sellPrice;
	private int amount;

	/**
	 * Returns id of island that provides this offer.
	 * 
	 * @return integer value
	 */
	public int getIslandId() {
		return islandId;
	}

	/**
	 * Returns goods id.
	 * 
	 * @return integer value
	 */
	public int getGoodsId() {
		return goodsId;
	}

	/**
	 * Returns sell price.
	 * 
	 * @return double value
	 */
	public double getSellPrice() {
		return sellPrice;
	}

	/**
	 * Returns an amount of product island able sell to current character.
	 * Returns -1 if this is an global sell offer.
	 * 
	 * @return integer value
	 */
	public int getAmount() {
		return amount;
	}
}
