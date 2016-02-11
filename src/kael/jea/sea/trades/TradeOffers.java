package kael.jea.sea.trades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import kael.jea.GsonSingleton;
import kael.jea.ReadOnlyArrayList;
import kael.jea.interfaces.Timed;
import kael.jea.interfaces.Updatable;

/**
 * This class represents global information about trade opportunities between
 * islands.
 * 
 * @author Kael
 * @since JEA1.0
 * @see ConcreteCharacterOffers
 */
public class TradeOffers implements Updatable, Timed {
	/**
	 * The only way to get an instance of class - static method initialize.
	 * 
	 * @param TradeOffersDOM
	 *            data object model.
	 */
	private TradeOffers(TradeOffersDOM dom) {
		this.data = dom;
	}

	private TradeOffersDOM data;
	private OfferInfo[] allOffers;
	private ReadOnlyArrayList<SellOffer> sellOffers;
	private ReadOnlyArrayList<BuyOffer> buyOffers;

	/**
	 * Returns an instance of class.
	 * 
	 * @return {@link TradeOffers}
	 * @throws IOException
	 *             if game API is unavailable.
	 * @see ConcreteCharacterOffers
	 */
	public static TradeOffers initialize() throws IOException {
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL("http://api.ereality.ru/colonial_shops.txt").openStream()))) {
			return new TradeOffers(GsonSingleton.getInstance().fromJson(in.readLine(), TradeOffersDOM.class));
		}
	}

	@Override
	public void updateData() throws IOException {
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL("http://api.ereality.ru/colonial_shops.txt").openStream()))) {
			data = GsonSingleton.getInstance().fromJson(in.readLine(), TradeOffersDOM.class);
			buyOffers = null;
			sellOffers = null;
			allOffers = null;
		}

	}

	/**
	 * Returns {@link ReadOnlyArrayList} with information about current buy
	 * offers.
	 * 
	 * @return ReadOnlyArrayList list
	 */
	public ReadOnlyArrayList<BuyOffer> getBuyOffers() {
		if (buyOffers == null) {
			setBuyOffers();
		}
		return buyOffers;
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with information about current sell
	 * offers.
	 * 
	 * @return ReadOnlyArrayList list
	 */
	public ReadOnlyArrayList<SellOffer> getSellOffers() {
		if (sellOffers == null) {
			setSellOffers();
		}
		return sellOffers;
	}

	/**
	 * Returns an array which contains all currently available offers.
	 * 
	 * @return OfferInfo[] array
	 */
	public OfferInfo[] getAllOffers() {
		if (allOffers == null) {
			setAllOffers();
		}
		return allOffers;
	}

	/**
	 * Returns all offers which specified island suggest at the moment. If
	 * island id not match - returns null.
	 * 
	 * @param islandId
	 *            - specified island Id
	 * @return OfferInfo[] array
	 */
	public OfferInfo[] getIslandOffers(int islandId) {
		return data.getOffers().get("" + islandId);
	}

	/**
	 * Returns concrete island shop id. If island id not match - returns 0.
	 * 
	 * @param islandId
	 *            - specified island Id
	 * @return integer value
	 */
	public int getIslandShopId(int islandId) {
		if (data.getShopsInfo().get("" + islandId) != null) {
			return data.getShopsInfo().get("" + islandId).getShopId();
		} else
			return 0;
	}

	/**
	 * Returns concrete island name. If island id not match - returns null.
	 * 
	 * @param islandId
	 *            - specified island Id
	 * @return string value
	 */
	public String getIslandName(int islandId) {
		if (data.getShopsInfo().get("" + islandId) != null) {
			return data.getShopsInfo().get("" + islandId).getName();
		} else
			return null;
	}

	@Override
	public GregorianCalendar infoDate() {
		return data.getCreatedAt().getStampAsDate();
	}

	@Override
	public String infoDateAsString() {
		return data.getCreatedAt().getFormattedTime();
	}

	/**
	 * Fills sell offer's container with data, if there no sell offer's at the
	 * moment - fills container with null.
	 */
	private void setSellOffers() {
		ArrayList<SellOffer> offers = new ArrayList<>(2);
		for (String islandId : data.getOffers().keySet()) {
			for (OfferInfo offer : data.getOffers().get(islandId)) {
				if (offer.getBuyPrice() > 0) {
					offers.add(new SellOffer(Integer.parseInt(islandId), offer.getGoodsId(), offer.getBuyPrice(), -1));
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
	 * Fills buy offer's container with data, if there no buy offer's at the
	 * moment - fills container with null.
	 */
	private void setBuyOffers() {
		ArrayList<BuyOffer> offers = new ArrayList<>(2);
		for (String islandId : data.getOffers().keySet()) {
			for (OfferInfo offer : data.getOffers().get(islandId)) {
				if (offer.getSellPrice() > 0) {
					offers.add(new BuyOffer(Integer.parseInt(islandId), offer.getGoodsId(), offer.getSellPrice()));
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
	 * Fills all offer's container with data, if there no offer's at the moment
	 * - fills container with null.
	 */
	private void setAllOffers() {
		int counter = 0;
		int index = 0;
		for (String key : data.getOffers().keySet()) {
			counter += data.getOffers().get(key).length;
		}
		OfferInfo[] offers = new OfferInfo[counter];
		for (String key : data.getOffers().keySet()) {
			for (OfferInfo offerInfo : data.getOffers().get(key)) {
				offers[index] = offerInfo;
				index++;
			}
		}
		if (offers.length == 0) {
			allOffers = null;
		} else {
			allOffers = offers;
		}
	}
}
