package kael.jea.sea.trades;

/**
 * This is a utility class, used to represent information about islands sell
 * offer's.
 * 
 * @author Kael
 * @since JEA1.0
 * @see BuyOffer
 */
public class SellOffer extends GlobalSellOffer {
	/**
	 * Creates simple instance of SellOffer class.
	 * 
	 * @param islandId
	 *            - island id, that is currently selling product
	 * @param goodsId
	 *            - specified product id
	 * @param sellPrice
	 *            - price, that shop will sell product
	 * @param amount
	 *            - amount of product
	 */
	protected SellOffer(int islandId, int goodsId, double sellPrice, int amount) {
		super(islandId, goodsId, sellPrice);
		this.amount = amount;
	}

	private int amount;

	/**
	 * Returns an amount of product island able sell to current character.
	 * 
	 * @return integer value
	 */
	public int getAmount() {
		return amount;
	}
}
