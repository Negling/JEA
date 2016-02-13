package kael.jea.sea.trades;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;

import kael.jea.interfaces.Updatable;
import kael.jea.utils.DataLoader;
import kael.jea.utils.GsonSingleton;
import kael.jea.utils.ReadOnlyArrayList;

/**
 * This class provides ability to review specified characters shipload.
 * 
 * @author Kael
 * @since JEA1.0
 * @see GoodsContainer
 */
public class Shipload implements Updatable {
	/**
	 * The only way to get an instance of Shipload class - static method
	 * initialize.
	 * 
	 * @param goodsMap
	 *            - HashMap with specified character goods data.
	 * @param characterId
	 *            - character id, to look for.
	 * @param accessKey
	 *            - clan API key to access game API.
	 */
	private Shipload(String url, HashMap<String, String> goodsMap) {
		this.DATA_URL = url;
		this.data = goodsMap;
		this.goods = setGoods();
	}
	private final static Type COLLECTION_TYPE = new TypeToken<HashMap<String, String>>() {
	}.getType();
	private final String DATA_URL;
	private HashMap<String, String> data;
	private ReadOnlyArrayList<GoodsContainer> goods;

	/**
	 * Returns simple instance of Shipload class, with data set by input
	 * nickname.
	 * 
	 * @param characterId
	 *            - character Id, to look for.
	 * @param accessKey
	 *            - clan API key to access game API.
	 * @return instance of {@link Shipload} class.
	 * @throws IOException
	 *             if game API is unavailable, or no net connection.
	 * @throws NoSuchCharacterExeption
	 *             - if character not exist.
	 */
	public static Shipload initialize(String accessKey, int characterId) throws IOException {
		HashMap<String, String> goodsMap;
		String url = "http://api.ereality.ru/" + accessKey + "/shipload/?h_id=" + characterId;
		String result = DataLoader.getAPIData(url);
		if (result == null || result.equals("false")) {
			goodsMap = new HashMap<>();
		} else {
			goodsMap = GsonSingleton.getInstance().fromJson(result, COLLECTION_TYPE);
		}
		return new Shipload(url, goodsMap);
	}

	@Override
	public void updateData() throws IOException {
		String result = DataLoader.getAPIData(DATA_URL);
		if (result == null || result.equals("false")) {
			data = new HashMap<>();
			goods = new ReadOnlyArrayList<>();
		} else {
			data = GsonSingleton.getInstance().fromJson(result, COLLECTION_TYPE);
			goods = setGoods();
		}
	}

	/**
	 * Returns {@link ReadOnlyArrayList} with data about goods, that character
	 * is currently carrying, represented as {@link GoodsContainer}
	 * 
	 * @return GoodsContainer data
	 * @see GoodsContainer
	 */
	public ReadOnlyArrayList<GoodsContainer> getGoods() {
		return goods;
	}

	/**
	 * Sets GoodsContainer data with specified data from goods Map.
	 * 
	 * @return {@link ReadOnlyArrayList} goods
	 */
	private ReadOnlyArrayList<GoodsContainer> setGoods() {
		if (data.isEmpty()) {
			return new ReadOnlyArrayList<>();
		}
		ArrayList<GoodsContainer> products = new ArrayList<>(5);
		for (String iD : data.keySet()) {
			products.add(new GoodsContainer(Integer.parseInt(iD), Integer.parseInt(data.get(iD))));
		}
		return new ReadOnlyArrayList<>(products);
	}
}
