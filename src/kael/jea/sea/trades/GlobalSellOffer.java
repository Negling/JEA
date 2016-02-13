package kael.jea.sea.trades;

public class GlobalSellOffer {
	/**
	 * @param islandId
	 * @param goodsId
	 * @param sellPrice
	 */
	protected GlobalSellOffer(int islandId, int goodsId, double sellPrice) {
		this.islandId = islandId;
		this.goodsId = goodsId;
		this.sellPrice = sellPrice;
	}

	private int islandId;
	private int goodsId;
	private double sellPrice;

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

}
