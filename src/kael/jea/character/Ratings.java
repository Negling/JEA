package kael.jea.character;

import de.ailis.pherialize.MixedArray;

/**
 * This is a {@link ErealityCharacter} utility class, used to store and represent
 * information about specified personage ratings.
 * 
 * @author Kael
 * @since JEA1.0
 * @see ErealityCharacter
 */
public class Ratings {
	/**
	 * Creates simple instance of Ratings class, with specified unserialized PHP
	 * array as input parameter.
	 * 
	 * @param data
	 * @see MixedArray
	 */
	protected Ratings(MixedArray data) {
		this.data = data.getArray("ratings");
	}

	/**
	 * Ratings data storage.
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
		this.data = data.getArray("ratings");
	}

	/**
	 * Returns character general rating.
	 * 
	 * @return integer value
	 */
	public int generalRating() {
		return data.getInt("h_rat1");

	}

	/**
	 * Returns character battle rating.
	 * 
	 * @return integer value
	 */
	public int battleRating() {
		return data.getInt("h_rat2");
	}

	/**
	 * Returns character professions rating.
	 * 
	 * @return integer value
	 */
	public int laborRating() {
		return data.getInt("h_rat3");
	}

	/**
	 * Returns character tournament rating.
	 * 
	 * @return integer value
	 */
	public int tournamentRating() {
		return data.getInt("h_rat4");
	}

	/**
	 * Returns character DP angel rating.
	 * 
	 * @return integer value
	 */
	public int angelDPPoints() {
		return data.getInt("h_rat11");
	}

	/**
	 * Returns character chaos victories value.
	 * 
	 * @return integer value
	 */
	public int chaosVictories() {
		return data.getInt("h_rat5");
	}

	/**
	 * Returns character fighter with evil victories value.
	 * 
	 * @return integer value
	 */
	public int evilFighterPoints() {
		return data.getInt("h_rat13");
	}

	/**
	 * Returns character Ice Breath Island victories value.
	 * 
	 * @return integer value
	 */
	public int iceWins() {
		return data.getInt("h_rat6");
	}

	/**
	 * Returns character polemarh value.
	 * 
	 * @return integer value
	 */
	public int polemarhPoints() {
		return data.getInt("h_rat7");
	}

	/**
	 * Returns character agromage victories value.
	 * 
	 * @return integer value
	 */
	public int agromageVictories() {
		return data.getInt("h_rat8_1");
	}

	/**
	 * Returns character agromage draws value.
	 * 
	 * @return integer value
	 */
	public int agromageDraws() {
		return data.getInt("h_rat8_2");
	}

	/**
	 * Returns character agromage losses value.
	 * 
	 * @return integer value
	 */
	public int agromageLosses() {
		return data.getInt("h_rat8_3");
	}

	/**
	 * Returns character gobivan victories value.
	 * 
	 * @return integer value
	 */
	public int gobivanVictories() {
		return data.getInt("h_rat9");
	}

	/**
	 * Returns character referal program points value.
	 * 
	 * @return integer value
	 */
	public int referalProgrammPoints() {
		return data.getInt("h_rat10");
	}

	/**
	 * Returns character mentor points value.
	 * 
	 * @return integer value
	 */
	public int mentorPoints() {
		return data.getInt("h_rat10_1");
	}

	/**
	 * Returns character alien frags value.
	 * 
	 * @return integer value
	 */
	public int alienKills() {
		return data.getInt("h_rat14");
	}

	/**
	 * Returns character alien ksenoteks value.
	 * 
	 * @return integer value
	 */
	public int alienKsenoteks() {
		return data.getInt("h_rat14_2");
	}

	/**
	 * Returns character elven wood instance points.
	 * 
	 * @return integer value
	 */
	public int elvenWoodPoints() {
		return data.getInt("h_rat15_1");
	}

	/**
	 * Returns character necropolis instance points.
	 * 
	 * @return integer value
	 */
	public int necropolisPoints() {
		return data.getInt("h_rat15_2");
	}

	/**
	 * Returns true if character is on top 100 most strong characters, otherwise
	 * returns false.
	 * 
	 * @return boolean value
	 */
	public boolean isMostStrong() {
		return data.getBoolean("h_top1");
	}

	/**
	 * Returns true if character is on top 100 chaos victories rating, otherwise
	 * returns false.
	 * 
	 * @return boolean value
	 */
	public boolean isMostLucky() {
		return data.getBoolean("h_top2");
	}

	/**
	 * Returns true if character is on top 100 mentor rating, otherwise returns
	 * false.
	 * 
	 * @return boolean value
	 */
	public boolean isMostCommunicative() {
		return data.getBoolean("h_top3");
	}

	/**
	 * Returns true if character is on top 100 blood island rating, otherwise
	 * returns false.
	 * 
	 * @return boolean value
	 */
	public boolean isMostBloodthirsty() {
		return data.getBoolean("h_top4");
	}

	/**
	 * Returns true if character is on top 60 ice breath island rating, or top
	 * 60 alien ksenoteks rating, otherwise returns false.
	 * 
	 * @return boolean value
	 */
	public boolean isMostPrudent() {
		return data.getBoolean("h_top5");
	}

	/**
	 * Returns true if character is on top 100 most labor characters, otherwise
	 * returns false.
	 * 
	 * @return boolean value
	 */
	public boolean isMostLaborious() {
		return data.getBoolean("h_top6");
	}
}
