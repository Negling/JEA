package kael.jea.sea.islands;

import java.io.IOException;

import kael.jea.gson.GsonSingleton;
import kael.jea.utils.DataLoader;

/**
 * Concrete realization of Island class, which provides opportunity to work with
 * green island explore status.
 * 
 * @author Kael
 * @since JEA1.0
 * @see TurquoiseIsland
 */
public class MalachiteIsland extends Island {
	/**
	 * Current island URL location, represented as string.
	 */
	private final static String ISLAND_URL = "http://api.ereality.ru/geologist_map28.txt";

	/**
	 * The only way to get an instance of class - static method initialize.
	 * 
	 * @param IslandDOM
	 *            data object model.
	 */
	private MalachiteIsland(IslandDOM data) {
		super(data);
	}

	/**
	 * Returns an instance of MalachiteIsland class.
	 * 
	 * @return {@link MalachiteIsland}
	 * @throws IOException
	 *             if game API is unavailable.
	 * @see TurquoiseIsland
	 */
	public static MalachiteIsland initialize() throws IOException {
		return new MalachiteIsland(
				GsonSingleton.getInstance().fromJson(DataLoader.getAPIData(ISLAND_URL), IslandDOM.class));
	}

	@Override
	public void updateData() throws IOException {
		setData(GsonSingleton.getInstance().fromJson(DataLoader.getAPIData(ISLAND_URL), IslandDOM.class));
	}
}
