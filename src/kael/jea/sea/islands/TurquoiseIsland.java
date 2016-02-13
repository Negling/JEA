package kael.jea.sea.islands;

import java.io.IOException;

import kael.jea.gson.GsonSingleton;
import kael.jea.utils.DataLoader;

/**
 * Concrete realization of Island class, which provides opportunity to work with
 * turquoise island explore status.
 * 
 * @author Kael
 * @since JEA1.0
 * @see MalachiteIsland
 */
public class TurquoiseIsland extends Island {

	/**
	 * Current island URL location, represented as string.
	 */
	private final static String ISLAND_URL = "http://api.ereality.ru/geologist_map25.txt";

	/**
	 * The only way to get an instance of class - static method initialize.
	 * 
	 * @param IslandDOM
	 *            data object model.
	 */
	private TurquoiseIsland(IslandDOM data) {
		super(data);
	}

	/**
	 * Returns an instance of TurquoiseIsland class.
	 * 
	 * @return {@link TurquoiseIsland}
	 * @throws IOException
	 *             if game API is unavailable.
	 * @see MalachiteIsland
	 */
	public static TurquoiseIsland initialize() throws IOException {
		return new TurquoiseIsland(
				GsonSingleton.getInstance().fromJson(DataLoader.getAPIData(ISLAND_URL), IslandDOM.class));
	}

	@Override
	public void updateData() throws IOException {
		setData(GsonSingleton.getInstance().fromJson(DataLoader.getAPIData(ISLAND_URL), IslandDOM.class));
	}
}
