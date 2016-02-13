package kael.jea.sea.trades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.GregorianCalendar;

import kael.jea.gson.GsonSingleton;
import kael.jea.interfaces.Timed;
import kael.jea.interfaces.Updatable;

/**
 * This class represents information about contrabandist offer.
 * 
 * @author Kael
 * @since JEA1.0
 */
public class ContrabandistOffer implements Updatable, Timed {
	private ContrabandistOfferDOM data;

	/**
	 * The only way to get an instance of class - static method initialize.
	 * 
	 * @param ContrabandistOfferDOM
	 *            data object model.
	 */
	private ContrabandistOffer(ContrabandistOfferDOM data) {
		this.data = data;
	}

	/**
	 * Returns an instance of class.
	 * 
	 * @return {@link ContrabandistOffer}
	 * @throws IOException
	 *             if game API is unavailable.
	 */
	public static ContrabandistOffer initialize() throws IOException {
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL("http://api.ereality.ru/contrabandist.txt").openStream()))) {
			return new ContrabandistOffer(
					GsonSingleton.getInstance().fromJson(in.readLine(), ContrabandistOfferDOM.class));
		}
	}

	@Override
	public void updateData() throws IOException {
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL("http://api.ereality.ru/contrabandist.txt").openStream()))) {
			data = GsonSingleton.getInstance().fromJson(in.readLine(), ContrabandistOfferDOM.class);
		}
	}

	/**
	 * Returns goods id.
	 * 
	 * @return integer value
	 */
	public int getGoodsId() {
		return Integer.parseInt(data.getGoodsId());
	}

	/**
	 * Returns max product amount, that contrabandist can buy at moment.
	 * 
	 * @return integer value
	 */
	public int getLimit() {
		return Integer.parseInt(data.getLimit());
	}

	/**
	 * Returns current amount, that contrabandist is already bought.
	 * 
	 * @return integer value
	 */
	public int getCurrentValue() {
		return data.getCurrentValue();
	}

	@Override
	public GregorianCalendar infoDate() {
		return data.getTimeStamp().getStampAsDate();
	}

	@Override
	public String infoDateAsString() {
		return data.getTimeStamp().getFormattedTime();
	}
}