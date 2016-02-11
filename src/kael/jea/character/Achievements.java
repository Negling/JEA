package kael.jea.character;

import de.ailis.pherialize.MixedArray;

/**
 * This is a {@link Personage} utility class, used to store and represent
 * information about specified personage achievements.
 * 
 * @author Kael
 * @since JEA1.0
 * @see Personage
 */
public class Achievements {
	/**
	 * Creates simple instance of Achievements class, with specified
	 * unserialized PHP array as input parameter.
	 * 
	 * @param data
	 * @see MixedArray
	 */
	protected Achievements(MixedArray data) {
		this.data = data.getArray("achievements");
	}

	/**
	 * Achievements data storage.
	 * 
	 * @see MixedArray
	 */
	private MixedArray data;

	/**
	 * This method replacing old storage data and sets new.
	 * 
	 * @param data
	 *            specified {@link MixedArray}
	 */
	protected void refresh(MixedArray data) {
		this.data = data.getArray("achievements");
	}

	/**
	 * Returns value of years passed from character registration achievement.
	 * 
	 * @return achievement value
	 */
	public int yearsFromRegistration() {
		return data.getInt(1);
	}

	/**
	 * Returns value of years online achievement.
	 * 
	 * @return achievement value
	 */
	public int yearsOnline() {
		return data.getInt(2);
	}

	/**
	 * Returns value of gold scored during Ereality.ru birthday events
	 * achievement.
	 * 
	 * @return achievement value
	 */
	public int goldFromAnniversaryLevel() {
		return data.getInt(5);
	}

	/**
	 * Returns value of snow spirits conqueror achievement.
	 * 
	 * @return achievement value
	 */
	public int snowSpiritsConqueror() {
		return data.getInt(6);
	}

	/**
	 * Returns value of blood island hunter achievement.
	 * 
	 * @return achievement value
	 */
	public int bloodIslandHunter() {
		return data.getInt(7);
	}

	/**
	 * Returns value of soul sufferings achievement.
	 * 
	 * @return achievement value
	 */
	public int soulSufferings() {
		return data.getInt(8);
	}

	/**
	 * Returns value of character military rank achievement.
	 * 
	 * @return achievement value
	 */
	public int rank() {
		return data.getInt(9);
	}

	/**
	 * Returns value of ereality.ru clans championship achievement.
	 * 
	 * @return achievement value
	 */
	public int erealityChampionship() {
		return data.getInt(10);
	}

	/**
	 * Returns value of chaos lord achievement.
	 * 
	 * @return achievement value
	 */
	public int chaosLord() {
		return data.getInt(11);
	}

	/**
	 * Returns value of frosty gift 2013 year achievement.
	 * 
	 * @return achievement value
	 */
	public int frostyGift2013() {
		return data.getInt(3);
	}

	/**
	 * Returns value of frosty gift 2014 year achievement.
	 * 
	 * @return achievement value
	 */
	public int frostyGift2014() {
		return data.getInt(4);
	}

	/**
	 * Returns value of frosty gift 2015 year achievement.
	 * 
	 * @return achievement value
	 */
	public int frostyGift2015() {
		return data.getInt(12);
	}
}