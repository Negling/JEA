package kael.jea.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kael.jea.gson.deserializers.IslandDOMDesializer;
import kael.jea.sea.islands.IslandDOM;

/**
 * Class - container for static synchronized instance of {@link Gson}
 * 
 * @author Kael
 * @since JEA1.0
 * @see com.google.gson.Gson
 */
public class GsonSingleton {

	private static volatile Gson instance;

	/**
	 * 
	 * @return {@link Gson} simple instance with all registered deserializers,
	 *         that are important to sea classes correct work. Thread safe.
	 */
	public static Gson getInstance() {
		Gson localInstance = instance;
		if (localInstance == null) {
			synchronized (Gson.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new GsonBuilder()
							.registerTypeAdapter(IslandDOM.class, new IslandDOMDesializer()).create();
				}
			}
		}
		return localInstance;
	}
}
