package kael.jea.sea.trades;

import java.io.IOException;
import java.util.GregorianCalendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kael.jea.interfaces.Timed;
import kael.jea.interfaces.Updatable;
import kael.jea.utils.DataLoader;
import kael.jea.utils.ReadOnlyArrayList;

/**
 * This class represents global information about trade opportunities between
 * islands.
 * 
 * @author Kael
 * @since JEA1.0
 * @see CharacterOffers
 */
public class GlobalOffers implements Updatable, Timed {
	/**
	 * The only way to get an instance of class - static method initialize.
	 * 
	 * @param GlobalOffersDOM
	 *            data object model.
	 */
	private GlobalOffers(GlobalOffersDOM dom) {
		this.data = dom;
	}

	private static Gson gsonInstance = new GsonBuilder()
			.registerTypeAdapter(GlobalOffersDOM.class, new GlobalOffersDOMDeserializer()).create();
	private static final String DATA_URL = "http://api.ereality.ru/colonial_shops.txt";
	private GlobalOffersDOM data;

	/**
	 * Returns an instance of class.
	 * 
	 * @return {@link GlobalOffers}
	 * @throws IOException
	 *             if game API is unavailable.
	 * @see CharacterOffers
	 */
	public static GlobalOffers initialize() throws IOException {
		return new GlobalOffers(gsonInstance.fromJson(DataLoader.getAPIData(DATA_URL), GlobalOffersDOM.class));
	}

	@Override
	public void updateData() throws IOException {
		data = gsonInstance.fromJson(DataLoader.getAPIData(DATA_URL), GlobalOffersDOM.class);
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with information about current buy
	 * offers.
	 * 
	 * @return ReadOnlyArrayList list
	 */
	public ReadOnlyArrayList<BuyOffer> getBuyOffers() {
		return new ReadOnlyArrayList<>(data.getBuyOffers());
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with information about current sell
	 * offers.
	 * 
	 * @return ReadOnlyArrayList list
	 */
	public ReadOnlyArrayList<GlobalSellOffer> getSellOffers() {
		return new ReadOnlyArrayList<>(data.getSellOffers());
	}



	@Override
	public GregorianCalendar infoDate() {
		return data.getCreatedAt().getStampAsDate();
	}

	@Override
	public String infoDateAsString() {
		return data.getCreatedAt().getFormattedTime();
	}
}
