package kael.jea.sea.trades;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import kael.jea.utils.JEATimeStamp;

/**
 * This class is an implementation of JsonDeserializer interface, used to
 * deserialise information from ereality.ru API to Global Offers DOM.
 * 
 * @author Kael
 * @since JEA1.0
 * @see GlobalOffersDOM
 */
class GlobalOffersDOMDeserializer implements JsonDeserializer<GlobalOffersDOM> {

	@Override
	public GlobalOffersDOM deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		Type type = new TypeToken<HashMap<String, OfferInfo[]>>() {
		}.getType();
		ArrayList<BuyOffer> buyOffers = new ArrayList<>(3);
		ArrayList<GlobalSellOffer> sellOffers = new ArrayList<>(3);
		HashMap<String, OfferInfo[]> trades = context.deserialize(json.getAsJsonObject().get("shops"), type);

		for (String island : trades.keySet()) {
			int islandId = Integer.parseInt(island);
			for (OfferInfo offer : trades.get(island)) {
				if (offer.getSellPrice() > 0) {
					buyOffers.add(new BuyOffer(islandId, offer.getGoodsId(), offer.getSellPrice()));
				} else {
					sellOffers.add(new GlobalSellOffer(islandId, offer.getGoodsId(), offer.getBuyPrice()));
				}
			}
		}
		return new GlobalOffersDOM(buyOffers, sellOffers,
				context.deserialize(json.getAsJsonObject().get("info"), JEATimeStamp.class));
	}

	/**
	 * This is a utility class, used to represent information about abstract island
	 * offer.
	 * 
	 * @author Kael
	 * @since JEA 1.0
	 * @see GlobalOffers
	 */
	private class OfferInfo {
		@SerializedName("w_id")
		private int goodsId;
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

		/**
		 * Returns default product price.
		 * 
		 * @return double value
		 */

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
	}
}
