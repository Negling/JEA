package kael.jea.sea.trades;

import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

import kael.jea.JEATimeStamp;

/**
 * {@link TradeOffers} class data object model.
 * 
 * @author Kael
 * @since JEA1.0
 * @see TradeOffers
 *
 */
class TradeOffersDOM {
	@SerializedName("islands")
	private HashMap<String, IslandShopInfo> shopsInfo;
	@SerializedName("shops")
	private HashMap<String, OfferInfo[]> offers;
	@SerializedName("info")
	private JEATimeStamp createdAt;

	/**
	 * Returns a map representation about islands shops.
	 * 
	 * @return HashMap
	 */
	public HashMap<String, IslandShopInfo> getShopsInfo() {
		return shopsInfo;
	}

	/**
	 * Returns a map representation about offers between islands.
	 * 
	 * @return HashMap
	 */
	public HashMap<String, OfferInfo[]> getOffers() {
		return offers;
	}

	/**
	 * Returns {@link JEATimeStamp} instance with info about API last update
	 * time.
	 * 
	 * @return JEATimeStamp
	 */
	public JEATimeStamp getCreatedAt() {
		return createdAt;
	}

	/**
	 * {@link TradeOffersDOM} support class. Represents information about island
	 * shops.
	 * 
	 * @author Kael
	 * @since JEA1.0
	 */
	protected class IslandShopInfo {
		@SerializedName("name")
		private String name;
		@SerializedName("shop")
		private int ShopId;

		/**
		 * Returns island name.
		 * 
		 * @return specified string
		 */
		public String getName() {
			return name;
		}

		/**
		 * Returns current island shop id.
		 * 
		 * @return integer value
		 */
		public int getShopId() {
			return ShopId;
		}
	}
}
