package kael.jea.sea.islands;

import java.io.IOException;
import java.util.GregorianCalendar;

import kael.jea.interfaces.Timed;
import kael.jea.interfaces.Updatable;
import kael.jea.utils.DataLoader;
import kael.jea.utils.GsonSingleton;
import kael.jea.utils.JEATimeStamp;

/**
 * This class provides ability to work with geologist islands update timers.
 * 
 * @author Kael
 * @since JEA1.0
 */
public class ResoursesUpdateTimer implements Updatable, Timed {
	/**
	 * Timer URL location, represented as string.
	 */
	private final static String TIMER_URL = "http://api.ereality.ru/geologist_map_update.txt";
	private ResoursesUpdateTimerDOM data;

	/**
	 * The only way to get an instance of class - static method initialize.
	 * 
	 * @param ResoursesUpdateTimerDOM
	 *            - data object model.
	 */
	private ResoursesUpdateTimer(ResoursesUpdateTimerDOM data) {
		this.data = data;
	}

	/**
	 * Returns an instance of ResoursesUpdateTimer class.
	 * 
	 * @return {@link ResoursesUpdateTimer}
	 * @throws IOException
	 *             if game API is unavailable.
	 */
	public static ResoursesUpdateTimer initialize() throws IOException {
		return new ResoursesUpdateTimer(
				GsonSingleton.getInstance().fromJson(DataLoader.getAPIData(TIMER_URL), ResoursesUpdateTimerDOM.class));
	}

	@Override
	public void updateData() throws IOException {
		data = GsonSingleton.getInstance().fromJson(DataLoader.getAPIData(TIMER_URL), ResoursesUpdateTimerDOM.class);
	}

	@Override
	public GregorianCalendar infoDate() {
		return data.getCreatedAt().getStampAsDate();
	}

	@Override
	public String infoDateAsString() {
		return data.getCreatedAt().getFormattedTime();
	}

	/**
	 * If malachite island is under exploring on the moment - returns
	 * <b>null</b>, otherwise returns string kind of <b>"HH:mm:ss"</b> where
	 * <b>HH</b> - hours, <b>mm</b> - minutes, and <b>ss</b> - seconds
	 * respectively with info when next island update appears.
	 * 
	 * <pre>
	 * Example: "14:06:12"
	 * </pre>
	 * 
	 * @return specified string
	 */
	public String malachiteTimerAsString() {
		return JEATimeStamp.getFormattedTime(Long.parseLong(data.getUpdateData().get("28")));
	}

	/**
	 * If malachite island is under exploring on the moment - returns
	 * <b>null</b>, otherwise returns {@link GregorianCalendar} instance with
	 * TimeZone set to +3 GMT, and set with time when next island update
	 * appears.
	 * 
	 * @return specified {@link GregorianCalendar} instance
	 */
	public GregorianCalendar malachiteTimerAsDate() {
		return JEATimeStamp.getStampAsdate(Long.parseLong(data.getUpdateData().get("28")));
	}

	/**
	 * If turquoise island is under exploring on the moment - returns
	 * <b>null</b>, otherwise returns string kind of <b>"HH:mm:ss"</b> where
	 * <b>HH</b> - hours, <b>mm</b> - minutes, and <b>ss</b> - seconds
	 * respectively with info when next island update appears.
	 * 
	 * <pre>
	 * Example: "14:06:12"
	 * </pre>
	 * 
	 * @return specified string
	 */
	public String turquoiseTimerAsString() {
		return JEATimeStamp.getFormattedTime(Long.parseLong(data.getUpdateData().get("25")));
	}

	/**
	 * If turquoise island is under exploring on the moment - returns
	 * <b>null</b>, otherwise returns {@link GregorianCalendar} instance with
	 * TimeZone set to +3 GMT, and set with time when next island update
	 * appears.
	 * 
	 * @return specified {@link GregorianCalendar} instance
	 */
	public GregorianCalendar turquoiseTimerAsDate() {
		return JEATimeStamp.getStampAsdate(Long.parseLong(data.getUpdateData().get("25")));
	}
}
