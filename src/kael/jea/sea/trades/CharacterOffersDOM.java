package kael.jea.sea.trades;

import java.util.ArrayList;

/**
 * {@link CharacterOffers} data object model.
 * 
 * @author Kael
 * @since JEA1.0
 * @see CharacterOffers
 */
class CharacterOffersDOM {
	/**
	 * Simple constructor.
	 * 
	 * @param buyOffers
	 * @param sellOffers
	 */
	protected CharacterOffersDOM(ArrayList<BuyOffer> buyOffers, ArrayList<SellOffer> sellOffers) {
		this.buyOffers = buyOffers;
		this.sellOffers = sellOffers;
	}

	private ArrayList<BuyOffer> buyOffers;
	private ArrayList<SellOffer> sellOffers;

	/**
	 * Returns list with buy offers.
	 * 
	 * @return
	 */
	public ArrayList<BuyOffer> getBuyOffers() {
		return buyOffers;
	}

	/**
	 * returns list with island sell offers;
	 * 
	 * @return
	 */
	public ArrayList<SellOffer> getSellOffers() {
		return sellOffers;
	}
}
