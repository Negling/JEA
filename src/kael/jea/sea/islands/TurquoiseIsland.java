package kael.jea.sea.islands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import kael.jea.GsonSingleton;
import kael.jea.interfaces.Updatable;

/**
 * Concrete realization of Island class, which provides opportunity to work with
 * turquoise island explore status.
 * 
 * @author Kael
 * @since JEA1.0
 * @see MalachiteIsland
 */
public class TurquoiseIsland extends Island implements Updatable {
	/**
	 * The only way to get an instance of class - static method initialize.
	 * 
	 * @param IslandDOM data object model.
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
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL("http://api.ereality.ru/geologist_map25.txt").openStream()))) {
			return new TurquoiseIsland(GsonSingleton.getInstance().fromJson(in.readLine(), IslandDOM.class));
		}
	}

	@Override
	public void updateData() throws IOException {
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL("http://api.ereality.ru/geologist_map25.txt").openStream()))) {
			setData(GsonSingleton.getInstance().fromJson(in.readLine(), IslandDOM.class));
		}
	}
}
