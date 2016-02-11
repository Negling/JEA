package kael.jea.sea.trades;

/**
 * This is a utility class, used to represent information about islands buy
 * offer's.
 * 
 * @author Kael
 * @since JEA1.0
 * @see SellOffer
 */
public class BuyOffer {
	/**
	 * Creates simple instance of BuyOffer class.
	 * 
	 * @param islandId
	 *            - island id, that is currently selling product
	 * @param goodsId
	 *            - specified product id
	 * @param buyPrice
	 *            - price, that shop will buy product
	 */
	protected BuyOffer(int islandId, int goodsId, double buyPrice) {
		this.islandId = islandId;
		this.goodsId = goodsId;
		this.buyPrice = buyPrice;
	}

	private int islandId;
	private int goodsId;
	private double buyPrice;

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
	 * Returns buy price.
	 * 
	 * @return double value
	 */
	public double getBuyPrice() {
		return buyPrice;
	}
}
