package kael.jea.sea.trades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;

import kael.exeptions.NoSuchCharacterExeption;
import kael.jea.GsonSingleton;
import kael.jea.ReadOnlyArrayList;
import kael.jea.interfaces.Updatable;

/**
 * This class provides opportunity to represent island offers to concrete
 * character at moment of time.
 * 
 * @author Kael
 * @since JEA1.0
 * @see TradeOffers
 */
public class ConcreteCharacterOffers implements Updatable {
	/**
	 * * The only way to get an instance of ConcreteCharacterOffers class -
	 * static method initialize.
	 * 
	 * @param data
	 *            HashMap with information about offers.
	 * @param accessKey
	 *            - clan API key to access game API.
	 * @param characterId
	 *            - character Id, to look for.
	 */
	private ConcreteCharacterOffers(HashMap<String, HashMap<String, TradeOffer>> data, String accessKey,
			int characterId) {
		this.data = data;
		this.accessKey = accessKey;
		this.characterId = characterId;
	}

	final private static Type COLLECTION_TYPE = new TypeToken<HashMap<String, HashMap<String, TradeOffer>>>() {
	}.getType();
	private ReadOnlyArrayList<SellOffer> sellOffers;
	private ReadOnlyArrayList<BuyOffer> buyOffers;
	private HashMap<String, HashMap<String, TradeOffer>> data;
	private String accessKey;
	private int characterId;

	/**
	 * Returns simple instance of ConcreteCharacterOffers class, with data set
	 * by input nickname.
	 * 
	 * @param accessKey
	 *            - clan API key to access game API.
	 * @param characterId
	 *            - character Id, to look for.
	 * @return instance of {@link ConcreteCharacterOffers} class.
	 * @throws IOException
	 *             - if game API is unavailable, or no net connection.
	 * @throws NoSuchCharacterExeption
	 *             - if character not exist.
	 */
	public static ConcreteCharacterOffers initialize(String accessKey, int characterId)
			throws IOException, NoSuchCharacterExeption {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				new URL("http://api.ereality.ru/" + accessKey + "/cshops/?h_id=" + characterId).openStream()))) {
			String info = in.readLine();
			if (info == null) {
				throw new NoSuchCharacterExeption("Character with id \"" + characterId + "\" not found!");
			}
			return new ConcreteCharacterOffers(GsonSingleton.getInstance().fromJson(info, COLLECTION_TYPE), accessKey,
					characterId);
		}
	}

	@Override
	public void updateData() throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				new URL("http://api.ereality.ru/" + accessKey + "/cshops/?h_id=" + characterId).openStream()))) {
			data = GsonSingleton.getInstance().fromJson(in.readLine(), COLLECTION_TYPE);
			buyOffers = null;
			sellOffers = null;
		}
	}

	/**
	 * Returns {@link ReadOnlyArrayList} list with available sale offers at
	 * moment.
	 * 
	 * @return ReadOnlyArrayList offers
	 */
	public ReadOnlyArrayList<SellOffer> getSellOffers() {
		if (sellOffers == null) {
			setSellOffers();
		}
		return sellOffers;
	}

	/**
	 * Returns {@link ReadOnlyArrayList} list with available buy offers at
	 * moment.
	 * 
	 * @return ReadOnlyArrayList offers
	 */
	public ReadOnlyArrayList<BuyOffer> getBuyOffers() {
		if (buyOffers == null) {
			setBuyOffers();
		}
		return buyOffers;
	}

	/**
	 * Sets Sell offer's container with offers data. Sets <b>null</b> if there
	 * no sell offers at moment.
	 */
	private void setSellOffers() {
		ArrayList<SellOffer> offers = new ArrayList<>(2);
		for (String islandId : data.keySet()) {

			for (String goodsId : data.get(islandId).keySet()) {

				if (data.get(islandId).get(goodsId).getBuy() > 0) {

					offers.add(new SellOffer(Integer.parseInt(islandId), Integer.parseInt(goodsId),
							data.get(islandId).get(goodsId).getBuy(), data.get(islandId).get(goodsId).getCount()));
				}
			}
		}
		if (offers.isEmpty()) {
			sellOffers = null;
		} else {
			sellOffers = new ReadOnlyArrayList<>(offers);
		}
	}

	/**
	 * Sets Buy offer's container with offers data. Sets <b>null</b> if there no
	 * buy offers at moment.
	 */
	private void setBuyOffers() {
		ArrayList<BuyOffer> offers = new ArrayList<>(2);
		for (String islandId : data.keySet()) {

			for (String goodsId : data.get(islandId).keySet()) {

				if (data.get(islandId).get(goodsId).getSale() > 0) {

					offers.add(new BuyOffer(Integer.parseInt(islandId), Integer.parseInt(goodsId),
							data.get(islandId).get(goodsId).getSale()));
				}
			}
		}
		if (offers.isEmpty()) {
			buyOffers = null;
		} else {
			buyOffers = new ReadOnlyArrayList<>(offers);
		}
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			long temp;
			temp = Double.doubleToLongBits(buy);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + count;
			temp = Double.doubleToLongBits(sale);
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
			if (!(obj instanceof TradeOffer)) {
				return false;
			}
			TradeOffer other = (TradeOffer) obj;
			if (!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if (Double.doubleToLongBits(buy) != Double.doubleToLongBits(other.buy)) {
				return false;
			}
			if (count != other.count) {
				return false;
			}
			if (Double.doubleToLongBits(sale) != Double.doubleToLongBits(other.sale)) {
				return false;
			}
			return true;
		}

		private ConcreteCharacterOffers getOuterType() {
			return ConcreteCharacterOffers.this;
		}
	}
}
