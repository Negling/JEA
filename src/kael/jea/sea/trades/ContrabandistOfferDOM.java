package kael.jea.sea.trades;

import com.google.gson.annotations.SerializedName;

import kael.jea.JEATimeStamp;

/**
 * {@link ContrabandistOffer} data object model.
 * 
 * @author Kael
 * @since JEA1.0
 * @see ContrabandistOffer
 */
class ContrabandistOfferDOM {
	@SerializedName("w_id")
	private String goodsId;
	@SerializedName("count_max")
	private String limit;
	@SerializedName("count_sold")
	private int currentValue;
	@SerializedName("info")
	private JEATimeStamp lastUpdated;

	/**
	 * Returns goods id.
	 * 
	 * @return string value
	 */
	public String getGoodsId() {
		return goodsId;
	}

	/**
	 * Returns max product amount, that contrabandist can buy at moment.
	 * 
	 * @return string value
	 */
	public String getLimit() {
		return limit;
	}

	/**
	 * Returns current amount, that contrabandist is already bought.
	 * 
	 * @return string value
	 */
	public int getCurrentValue() {
		return currentValue;
	}

	/**
	 * Returns {@link JEATimeStamp} instance with info about API last update
	 * time.
	 * 
	 * @return JEATimeStamp
	 */
	public JEATimeStamp getTimeStamp() {
		return lastUpdated;
	}
}
