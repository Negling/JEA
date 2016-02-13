package kael.jea.sea.trades;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kael.jea.exeptions.NoSuchCharacterExeption;
import kael.jea.interfaces.Updatable;
import kael.jea.utils.DataLoader;
import kael.jea.utils.ReadOnlyArrayList;

/**
 * This class provides opportunity to represent island offers to concrete
 * character at moment of time.
 * 
 * @author Kael
 * @since JEA1.0
 * @see GlobalOffers
 */
public class CharacterOffers implements Updatable {
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
	private CharacterOffers(CharacterOffersDOM data, String url) {
		this.data = data;
		this.DATA_URL = url;
	}

	private static Gson gsonInstance = new GsonBuilder()
			.registerTypeAdapter(CharacterOffersDOM.class, new CharacterOffersDOMDeserializer()).create();
	private final String DATA_URL;
	private CharacterOffersDOM data;

	/**
	 * Returns simple instance of ConcreteCharacterOffers class, with data set
	 * by input nickname.
	 * 
	 * @param accessKey
	 *            - clan API key to access game API.
	 * @param characterId
	 *            - character Id, to look for.
	 * @return instance of {@link CharacterOffers} class.
	 * @throws IOException
	 *             - if game API is unavailable, or no net connection.
	 * @throws NoSuchCharacterExeption
	 *             - if character not exist.
	 */
	public static CharacterOffers initialize(String accessKey, int characterId)
			throws IOException, NoSuchCharacterExeption {
		String url = "http://api.ereality.ru/" + accessKey + "/cshops/?h_id=" + characterId;
		String info = DataLoader.getAPIData(url);
		if (info == null) {
			throw new NoSuchCharacterExeption("Character with id \"" + characterId + "\" not found!");
		}
		return new CharacterOffers(gsonInstance.fromJson(info, CharacterOffersDOM.class), url);
	}

	@Override
	public void updateData() throws IOException {
		data = gsonInstance.fromJson(DataLoader.getAPIData(DATA_URL), CharacterOffersDOM.class);
	}

	/**
	 * Returns {@link ReadOnlyArrayList} list with available sale offers at
	 * moment.
	 * 
	 * @return ReadOnlyArrayList offers
	 */
	public ReadOnlyArrayList<SellOffer> getSellOffers() {
		return new ReadOnlyArrayList<>(data.getSellOffers());
	}

	/**
	 * Returns {@link ReadOnlyArrayList} list with available buy offers at
	 * moment.
	 * 
	 * @return ReadOnlyArrayList offers
	 */
	public ReadOnlyArrayList<BuyOffer> getBuyOffers() {
		return new ReadOnlyArrayList<>(data.getBuyOffers());
	}
}
