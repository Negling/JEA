package kael.jea.sea.trades;

/**
 * This is {@link Shipload} a utility class, used to store and represent
 * information about stored goods.
 * 
 * @author Kael
 * @since JEA1.0
 * @see Shipload
 */
public class GoodsContainer {
	/**
	 * Creates simple instance of GoodsContainer class, with product Id and
	 * product amount as as input parameters.
	 * 
	 * @param productId
	 *            - id of stored goods
	 * @param productAmount
	 *            - amount of stored product
	 * @see Shipload
	 */
	protected GoodsContainer(int productId, int productAmount) {
		this.productId = productId;
		this.productAmount = productAmount;
	}

	private int productId;
	private int productAmount;

	/**
	 * Returns product id.
	 * 
	 * @return integer value
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Returns product amount.
	 * 
	 * @return integer value
	 */
	public int getProductAmount() {
		return productAmount;
	}
}
