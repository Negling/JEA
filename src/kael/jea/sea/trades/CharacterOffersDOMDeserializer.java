package kael.jea.sea.trades;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

/**
 * This class is an implementation of JsonDeserializer interface, used to
 * deserialise information from ereality.ru API to Character Offers DOM.
 * 
 * @author Kael
 * @since JEA1.0
 * @see CharacterOffersDOM
 */
class CharacterOffersDOMDeserializer implements JsonDeserializer<CharacterOffersDOM> {

	@Override
	public CharacterOffersDOM deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {

		Type type = new TypeToken<HashMap<String, HashMap<String, TradeOffer>>>() {
		}.getType();
		ArrayList<BuyOffer> buyOffers = new ArrayList<>(3);
		ArrayList<SellOffer> sellOffers = new ArrayList<>(3);
		HashMap<String, HashMap<String, TradeOffer>> trades = context.deserialize(json.getAsJsonObject(), type);

		for (String island : trades.keySet()) {
			int islandId = Integer.parseInt(island);
			
			for (String goods : trades.get(island).keySet()) {
				int productId = Integer.parseInt(goods);
				
				TradeOffer localOffer = trades.get(island).get(goods);
				
				if (localOffer.getCount() > 0) {
					sellOffers.add(new SellOffer(islandId, productId, localOffer.getBuy(), localOffer.getCount()));
				} else {
					buyOffers.add(new BuyOffer(islandId, productId, localOffer.getSale()));
				}
			}
		}
		return new CharacterOffersDOM(buyOffers, sellOffers);
	}

	/**
	 * Intermediate inner class, uses to represent offers data model.
	 * 
	 * @author Kael
	 * @since JEA1.0
	 */
	private class TradeOffer {
		private double buy;
		private double sale;
		private int count;

		/**
		 * Returns buy price.
		 * 
		 * @return double value
		 */
		public double getBuy() {
			return buy;
		}

		/**
		 * Returns sale price.
		 * 
		 * @return double value
		 */
		public double getSale() {
			return sale;
		}
		
		/**
		 * Returns an amount of available product.
		 * 
		 * @return
		 */
		public int getCount() {
			return count;
		}
	}
}
