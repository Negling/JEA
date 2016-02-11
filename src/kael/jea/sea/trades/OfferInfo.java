package kael.jea.sea.trades;

import com.google.gson.annotations.SerializedName;

/**
 * This is a utility class, used to represent information about abstract island
 * offer.
 * 
 * @author Kael
 * @since JEA 1.0
 * @see TradeOffers
 */
public class OfferInfo {
	/**
	 * Creates simple instance of OfferInfo class.
	 * 
	 * @param goodsId
	 *            - specified product id
	 * @param goodsName
	 *            - specified product name
	 * @param defaultPrice
	 *            - default product price
	 * @param buyPrice
	 *            - price, that shop will buy product
	 * @param salePrice
	 *            - price, that shop will sell product
	 */
	protected OfferInfo(int goodsId, String goodsName, double defaultPrice, double buyPrice, double salePrice) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.defaultPrice = defaultPrice;
		this.buyPrice = buyPrice;
		this.salePrice = salePrice;
	}

	@SerializedName("w_id")
	private int goodsId;
	@SerializedName("w_name")
	private String goodsName;
	@SerializedName("price")
	private double defaultPrice;
	@SerializedName("buy")
	private double buyPrice;
	@SerializedName("sale")
	private double salePrice;

	/**
	 * Returns goods id.
	 * 
	 * @return integer value
	 */
	public int getGoodsId() {
		return goodsId;
	}

	/**
	 * Returns product name.
	 * 
	 * @return string value
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * Returns default product price.
	 * 
	 * @return double value
	 */
	public double getDefaultPrice() {
		return defaultPrice;
	}

	/**
	 * Returns buy price.
	 * 
	 * @return double value
	 */
	public double getBuyPrice() {
		return buyPrice;
	}

	/**
	 * Returns sale price.
	 * 
	 * @return double value
	 */
	public double getSellPrice() {
		return salePrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(buyPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(defaultPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + goodsId;
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		temp = Double.doubleToLongBits(salePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OfferInfo)) {
			return false;
		}
		OfferInfo other = (OfferInfo) obj;
		if (Double.doubleToLongBits(buyPrice) != Double.doubleToLongBits(other.buyPrice)) {
			return false;
		}
		if (Double.doubleToLongBits(defaultPrice) != Double.doubleToLongBits(other.defaultPrice)) {
			return false;
		}
		if (goodsId != other.goodsId) {
			return false;
		}
		if (goodsName == null) {
			if (other.goodsName != null) {
				return false;
			}
		} else if (!goodsName.equals(other.goodsName)) {
			return false;
		}
		if (Double.doubleToLongBits(salePrice) != Double.doubleToLongBits(other.salePrice)) {
			return false;
		}
		return true;
	}
}
