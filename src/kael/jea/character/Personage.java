package kael.jea.character;

import java.io.IOException;
import java.net.URLEncoder;
import de.ailis.pherialize.MixedArray;
import de.ailis.pherialize.Pherialize;
import kael.jea.exeptions.NoSuchCharacterExeption;
import kael.jea.interfaces.Updatable;
import kael.jea.utils.DataLoader;

/**
 * This class provides access and information about specified ereality.ru game
 * character.
 * 
 * @author Kael
 * @since JEA1.0
 */
public class Personage implements Updatable {
	/**
	 * The only way to get an instance of Personage class - static method
	 * initialize.
	 * 
	 * @param data
	 *            - unserialized PHP array with character data.
	 * @param nickname
	 *            - character nickname, to look for.
	 * @param accessKey
	 *            - clan API key to access game API.
	 */
	private Personage(MixedArray data, String url) {
		this.data = data;
		this.CHARACTER_DATA_URL = url;
	}

	private final String CHARACTER_DATA_URL;
	private MixedArray data;
	private MainInfo info;
	private Inventory inventory;
	private Ratings ratings;
	private Achievements achievements;

	/**
	 * Returns simple instance of Personage class, with data set by input
	 * nickname.
	 * 
	 * @param nickname
	 *            - character nickname, to look for.
	 * @param accessKey
	 *            - clan API key to access game API.
	 * @return instance of {@link Personage} class.
	 * @throws IOException
	 *             if game API is unavailable, or no net connection.
	 * @throws NoSuchCharacterExeption
	 *             - if character not exist.
	 */
	public static Personage initialize(String nickname, String accessKey) throws IOException, NoSuchCharacterExeption {
		MixedArray data;
		String charUrl = "http://api.ereality.ru/" + accessKey + "/pinfo/?h_name="
				+ URLEncoder.encode(nickname, "Cp1251");
		data = Pherialize.unserialize(DataLoader.getAPIData(charUrl)).toArray();
		if (data.isEmpty()) {
			throw new NoSuchCharacterExeption("Character \"" + nickname + "\" not found!");
		}
		return new Personage(data, charUrl);
	}

	public void updateData() throws IOException {
		data = Pherialize.unserialize(DataLoader.getAPIData(CHARACTER_DATA_URL)).toArray();
		if (info != null) {
			info.refresh(data);
		}
		if (ratings != null) {
			ratings.refresh(data);
		}
		if (inventory != null) {
			inventory.refresh(data);
		}
		if (achievements != null) {
			achievements.refresh(data);
		}
	}

	/**
	 * Returns personage main information instance.
	 * 
	 * @return personage main information
	 * @see MainInfo
	 */
	public MainInfo getMainInfo() {
		if (info == null) {
			info = new MainInfo(data);
		}
		return info;
	}

	/**
	 * Returns personage inventory instance.
	 * 
	 * @return personage inventory data
	 * @see Inventory
	 */
	public Inventory getInvertory() {
		if (inventory == null) {
			inventory = new Inventory(data);
		}
		return inventory;
	}

	/**
	 * Returns personage ratings instance.
	 * 
	 * @return personage ratings data
	 * @see Ratings
	 */
	public Ratings getRatings() {
		if (ratings == null) {
			return new Ratings(data);
		}
		return ratings;
	}

	/**
	 * Returns personage achievements instance.
	 * 
	 * @return personage achievements data
	 * @see Achievements
	 */
	public Achievements getAchievements() {
		if (achievements == null) {
			achievements = new Achievements(data);
		}
		return achievements;
	}
}
