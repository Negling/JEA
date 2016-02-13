package kael.jea.sea.trades;

import java.util.ArrayList;

import kael.jea.utils.JEATimeStamp;

/**
 * {@link GlobalOffers} class data object model.
 * 
 * @author Kael
 * @since JEA1.0
 * @see GlobalOffers
 *
 */
class GlobalOffersDOM {
	protected GlobalOffersDOM(ArrayList<BuyOffer> buyOffers, ArrayList<GlobalSellOffer> sellOffers,
			JEATimeStamp createdAt) {
		this.buyOffers = buyOffers;
		this.sellOffers = sellOffers;
		this.createdAt = createdAt;
	}

	private ArrayList<BuyOffer> buyOffers;
	private ArrayList<GlobalSellOffer> sellOffers;
	private JEATimeStamp createdAt;

	public JEATimeStamp getCreatedAt() {
		return createdAt;
	}

	public ArrayList<BuyOffer> getBuyOffers() {
		return buyOffers;
	}

	public ArrayList<GlobalSellOffer> getSellOffers() {
		return sellOffers;
	}
}
