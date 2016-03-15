package kael.jea.character;

import de.ailis.pherialize.MixedArray;

/**
 * This is a {@link ErealityCharacter} utility class, used to store and represent
 * information about specified personage parameters.
 * 
 * @author Kael
 * @since JEA1.0
 * @see ErealityCharacter
 */
public class MainInfo {
	/**
	 * Creates simple instance of {@link MainInfo} class, with specified
	 * unserialized PHP array as input parameter.
	 * 
	 * @param data
	 * @see MixedArray
	 */
	protected MainInfo(MixedArray data) {
		this.data = data.getArray("info");
	}

	/**
	 * Main Info data storage.
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
		this.data = data.getArray("info");
	}

	/**
	 * Returns info about character marriage status.
	 * 
	 * @return boolean value
	 */
	public boolean isMarried() {
		return data.getBoolean("h_marr");
	}

	/**
	 * Returns info about character faction rights status.
	 * 
	 * @return boolean value
	 */
	public boolean isFactionLeader() {
		return data.getBoolean("r_func");
	}

	/**
	 * Returns info about character gender.
	 * 
	 * @return boolean value
	 */
	public boolean isMale() {
		return data.getBoolean("h_sex");

	}

	/**
	 * Returns info about character online status.
	 * 
	 * @return boolean value
	 */
	public boolean isOnline() {
		return data.getBoolean("h_online");
	}

	/**
	 * Returns character nickname.
	 * 
	 * @return string value
	 */
	public String nickname() {
		return data.getString("h_name");
	}

	/**
	 * Returns character personal status. If character has no personal status -
	 * returns empty string.
	 * 
	 * @return string value
	 */
	public String personalStatus() {
		return data.getString("p_status");
	}

	/**
	 * Returns character clan status. If character has no clan, or status is
	 * empty - returns empty string.
	 * 
	 * @return string value
	 */
	public String clanStatus() {
		return data.getString("c_status");
	}

	/**
	 * Returns character clan name status. If character has no clan - returns
	 * empty string.
	 * 
	 * @return string value
	 */
	public String clanName() {
		return data.getString("c_name");
	}

	/**
	 * Returns character class info.
	 * 
	 * <pre>
	 * Example: "A7"
	 * </pre>
	 * 
	 * @return specified string value
	 */
	public String charClass() {
		return data.getString("h_class");
	}

	/**
	 * Returns character avatar path.
	 * 
	 * <pre>
	 * Example: "https://img.ereality.ru/68x-/w/kit/armor.png"
	 * </pre>
	 * 
	 * @return specified string value
	 */
	public String avatarPath() {
		return "https://img.ereality.ru/avatar/" + data.getString("h_avatar");
	}

	/**
	 * Returns character ID.
	 * 
	 * @return integer value
	 */
	public int getId() {
		return data.getInt("id");
	}

	/**
	 * Returns character PVP division.
	 * 
	 * @return integer value
	 */
	public int PVPDivision() {
		return data.getInt("r_level");
	}

	/**
	 * Returns character PVP rank.
	 * 
	 * @return integer value
	 */
	public int PVPRank() {
		return data.getInt("r_rang");
	}

	/**
	 * Returns character experience.
	 * 
	 * @return integer value
	 */
	public int PVPExp() {
		return data.getInt("r_exp");
	}

	/**
	 * Returns character available PVP points.
	 * 
	 * @return integer value
	 */
	public int PVPPoints() {
		return data.getInt("r_balls");
	}

	/**
	 * Returns character clan ID. If character has no clan - returns 0.
	 * 
	 * @return integer value
	 */
	public int clanId() {
		return data.getInt("c_id");
	}

	/**
	 * Returns character maximum hit points.
	 * 
	 * @return integer value
	 */
	public int maxHp() {
		return data.getInt("h_hp");
	}

	/**
	 * Returns character max mana points.
	 * 
	 * @return integer value
	 */
	public int maxMana() {
		return data.getInt("h_ma");
	}

	/**
	 * Returns character energy points.
	 * 
	 * @return integer value
	 */
	public int maxEnergy() {
		return data.getInt("h_en");
	}

	/**
	 * Returns character level.
	 * 
	 * @return integer value
	 */
	public int level() {
		return data.getInt("h_level");
	}

	/**
	 * Returns character strength bonus.
	 * 
	 * @return integer value
	 */
	public int strengthBonus() {
		return data.getInt("h_add_str");
	}

	/**
	 * Returns character agility bonus.
	 * 
	 * @return integer value
	 */
	public int agilityBonus() {
		return data.getInt("h_add_dex");
	}

	/**
	 * Returns character intuition bonus.
	 * 
	 * @return integer value
	 */
	public int intuitionBonus() {
		return data.getInt("h_add_luk");
	}

	/**
	 * Returns character intelligence bonus.
	 * 
	 * @return integer value
	 */
	public int intelligenceBonus() {
		return data.getInt("h_add_int");
	}

	/**
	 * Returns character wisdom bonus.
	 * 
	 * @return integer value
	 */
	public int wisdomBonus() {
		return data.getInt("h_add_sta");
	}

	/**
	 * Returns character accuracy.
	 * 
	 * @return integer value
	 */
	public int accuracy() {
		return data.getInt("h_anuv");
	}

	/**
	 * Returns character dodge.
	 * 
	 * @return integer value
	 */
	public int dodge() {
		return data.getInt("h_uv");
	}

	/**
	 * Returns character crushing.
	 * 
	 * @return integer value
	 */
	public int crushing() {
		return data.getInt("h_kr");
	}

	/**
	 * Returns character durability.
	 * 
	 * @return integer value
	 */
	public int durability() {
		return data.getInt("h_ankr");
	}

	/**
	 * Returns character armor disruption.
	 * 
	 * @return integer value
	 */
	public int armorDisruption() {
		return data.getInt("h_anar");
	}

	/**
	 * Returns character block disruption.
	 * 
	 * @return integer value
	 */
	public int blockDisruption() {
		return data.getInt("h_anbl");
	}

	/**
	 * Returns character minimal pure damage.
	 * 
	 * @return integer value
	 */
	public int minDamage() {
		return data.getInt("h_min_dam");
	}

	/**
	 * Returns character maximal pure damage.
	 * 
	 * @return integer value
	 */
	public int maxDamage() {
		return data.getInt("h_max_dam");
	}

	/**
	 * Returns character head armor points.
	 * 
	 * @return integer value
	 */
	public int headArmor() {
		return data.getInt("h_bl_1");
	}

	/**
	 * Returns character body armor points.
	 * 
	 * @return integer value
	 */
	public int bodyArmor() {
		return data.getInt("h_bl_2");
	}

	/**
	 * Returns character hands armor points.
	 * 
	 * @return integer value
	 */
	public int handsArmor() {
		return data.getInt("h_bl_3");
	}

	/**
	 * Returns character belt armor points.
	 * 
	 * @return integer value
	 */
	public int beltArmor() {
		return data.getInt("h_bl_4");
	}

	/**
	 * Returns character legs armor points.
	 * 
	 * @return integer value
	 */
	public int legsArmor() {
		return data.getInt("h_bl_5");
	}

	/**
	 * Returns character victories value.
	 * 
	 * @return integer value
	 */
	public int wins() {
		return data.getInt("h_win");
	}

	/**
	 * Returns character losses value.
	 * 
	 * @return integer value
	 */
	public int losses() {
		return data.getInt("h_lost");
	}

	/**
	 * Returns character draws value.
	 * 
	 * @return integer value
	 */
	public int draws() {
		return data.getInt("h_draw");
	}

	/**
	 * Returns character global location ID.
	 * 
	 * @return integer value
	 */
	public int location() {
		return data.getInt("h_place2");
	}

	/**
	 * Returns character strength value.
	 * 
	 * @return integer value
	 */
	public int strength() {
		return data.getInt("h_str");
	}

	/**
	 * Returns character agility value.
	 * 
	 * @return integer value
	 */
	public int agility() {
		return data.getInt("h_dex");
	}

	/**
	 * Returns character intuition value.
	 * 
	 * @return integer value
	 */
	public int intuition() {
		return data.getInt("h_luk");
	}

	/**
	 * Returns character intelligence value.
	 * 
	 * @return integer value
	 */
	public int intelligence() {
		return data.getInt("h_int");
	}

	/**
	 * Returns character wisdom value.
	 * 
	 * @return integer value
	 */
	public int wisdom() {
		return data.getInt("h_sta");
	}

	/**
	 * Returns character health stats value.
	 * 
	 * @return integer value
	 */
	public int health() {
		return data.getInt("h_liv");
	}

	/**
	 * Returns character hunter profession value.
	 * 
	 * @return integer value
	 */
	public int hunterLevel() {
		return data.getInt("h_pro1");
	}

	/**
	 * Returns character priest profession value.
	 * 
	 * @return integer value
	 */
	public int priestLevel() {
		return data.getInt("h_pro2");
	}

	/**
	 * Returns character craftsman profession value.
	 * 
	 * @return integer value
	 */
	public int craftsmanLevel() {
		return data.getInt("h_pro3");
	}

	/**
	 * Returns character fisherman profession value.
	 * 
	 * @return integer value
	 */
	public int fishermanLevel() {
		return data.getInt("h_pro4");
	}

	/**
	 * Returns character cook profession value.
	 * 
	 * @return integer value
	 */
	public int cookLevel() {
		return data.getInt("h_pro5");
	}

	/**
	 * Returns character digger profession value.
	 * 
	 * @return integer value
	 */
	public int diggerlevel() {
		return data.getInt("h_pro6");
	}

	/**
	 * Returns character builder profession value.
	 * 
	 * @return integer value
	 */
	public int builderlevel() {
		return data.getInt("h_pro7");
	}

	/**
	 * Returns character miner profession value.
	 * 
	 * @return integer value
	 */
	public int minerLevel() {
		return data.getInt("h_pro8");
	}

	/**
	 * Returns character trapper profession value.
	 * 
	 * @return integer value
	 */
	public int trapperLevel() {
		return data.getInt("h_pro9");
	}

	/**
	 * Returns character metallurgist profession value.
	 * 
	 * @return integer value
	 */
	public int metallurgistLevel() {
		return data.getInt("h_pro10");
	}

	/**
	 * Returns character lumberjack profession value.
	 * 
	 * @return integer value
	 */
	public int lumberjackLevel() {
		return data.getInt("h_pro11");
	}

	/**
	 * Returns character carpenter profession value.
	 * 
	 * @return integer value
	 */
	public int carpenterLevel() {
		return data.getInt("h_pro12");
	}

	/**
	 * Returns character "kudesnik" profession value.
	 * 
	 * @return integer value
	 */
	public int thaumaturgeLevel() {
		return data.getInt("h_pro13");
	}

	/**
	 * Returns character swordsman profession value.
	 * 
	 * @return integer value
	 */
	public int swordsmanLevel() {
		return data.getInt("h_pro14");
	}

	/**
	 * Returns character exorcist profession value.
	 * 
	 * @return integer value
	 */
	public int exorcistLevel() {
		return data.getInt("h_pro15");
	}

	/**
	 * Returns character geologist profession value.
	 * 
	 * @return integer value
	 */
	public int geologistLevel() {
		return data.getInt("h_pro16");
	}

	/**
	 * Returns character jeweler profession value.
	 * 
	 * @return integer value
	 */
	public int jewelerLevel() {
		return data.getInt("h_pro17");
	}

	/**
	 * Returns character DP angel value.
	 * 
	 * @return integer value
	 */
	public int dpAngelLevel() {
		return data.getInt("septikon_rang");
	}

	/**
	 * Returns character fighter with evil value.
	 * 
	 * @return integer value
	 */
	public int evilFighterLevel() {
		return data.getInt("u_fighter_rang");
	}

	/**
	 * Returns character chaos knight value.
	 * 
	 * @return integer value
	 */
	public int chaosKnightLevel() {
		return data.getInt("c_rang");
	}

	/**
	 * Returns character school of iron body value.
	 * 
	 * @return integer value
	 */
	public int ironBodyLevel() {
		return data.getInt("q3_rang");
	}

	/**
	 * Returns character current hit points.
	 * 
	 * @return integer value
	 */
	public int currentHPLevel() {
		return data.getInt("h_curhp");
	}

	/**
	 * Returns character current mana points.
	 * 
	 * @return integer value
	 */
	public int currentManaLevel() {
		return data.getInt("h_curma");
	}

	/**
	 * Returns character current energy points.
	 * 
	 * @return integer value
	 */
	public int currentEnergyLevel() {
		return data.getInt("h_curen");
	}

	/**
	 * Returns character current level up's points.
	 * 
	 * @return integer value
	 */
	public int currentLevelUPs() {
		return data.getInt("h_levup");
	}

	/**
	 * Returns character fists skill value.
	 * 
	 * @return integer value
	 */
	public int fistSkill() {
		return data.getInt("h_um1");
	}

	/**
	 * Returns character sword skill value.
	 * 
	 * @return integer value
	 */
	public int swordSkill() {
		return data.getInt("h_um2");
	}

	/**
	 * Returns character axes skill value.
	 * 
	 * @return integer value
	 */
	public int axeSkill() {
		return data.getInt("h_um3");
	}

	/**
	 * Returns character staffs skill value.
	 * 
	 * @return integer value
	 */
	public int staffSkill() {
		return data.getInt("h_um4");
	}

	/**
	 * Returns character knifes skill value.
	 * 
	 * @return integer value
	 */
	public int knifeSkill() {
		return data.getInt("h_um5");
	}

	/**
	 * Returns character spear skill value.
	 * 
	 * @return integer value
	 */
	public int spearSkill() {
		return data.getInt("h_um6");
	}

	/**
	 * Returns character shield skill value.
	 * 
	 * @return integer value
	 */
	public int shieldSkill() {
		return data.getInt("h_um7");
	}

	/**
	 * Returns character one weapon style value.
	 * 
	 * @return integer value
	 */
	public int oneWeaponStye() {
		return data.getInt("h_st1");
	}

	/**
	 * Returns character two weapon style value.
	 * 
	 * @return integer value
	 */
	public int twoWeaponsStyle() {
		return data.getInt("h_st2");
	}

	/**
	 * Returns character two-handed style value.
	 * 
	 * @return integer value
	 */
	public int twoHandedStyle() {
		return data.getInt("h_st3");
	}

	/**
	 * Returns character one weapon and shiels style value.
	 * 
	 * @return integer value
	 */
	public int weaponAndShieldStyle() {
		return data.getInt("h_st4");
	}
}