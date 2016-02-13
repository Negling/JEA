package kael.jea.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.google.gson.annotations.SerializedName;

/**
 * Concrete class to work with Time Stamps which ereality.ru API provides. Also
 * used as part of DOM in Islands, Trades, etc classes.
 * 
 * @author Kael
 * @since JEA1.0
 */
public class JEATimeStamp {
	/**
	 * Creates simple instance of class with Unix TimeStamp as input parameter.
	 * 
	 * @param unixTimeStamp
	 *            long type primitive.
	 */
	public JEATimeStamp(long unixTimeStamp) {
		this.unixTimeStamp = unixTimeStamp;
	}

	@SerializedName("generated_at")
	private long unixTimeStamp;
	private static SimpleDateFormat dateFormat;
	private static GregorianCalendar calendar;

	/**
	 * static initialization block, to configure classes for work with
	 * ereaality.ru data.
	 */
	static {
		dateFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
		calendar = new GregorianCalendar(dateFormat.getTimeZone());
	}

	/**
	 * 
	 * @return value of Unix TimeStamp
	 */
	public long getValue() {
		return unixTimeStamp;
	}

	/**
	 * If unixTimeStamp class parameter is 0 - returns null, otherwise returns
	 * string kind of <b>"HH:mm:ss"</b> where <b>HH</b> - hours, <b>mm</b> -
	 * minutes, and <b>ss</b> - seconds respectively
	 * 
	 * <pre>
	 * Example: "14:06:12"
	 * </pre>
	 * 
	 * @return specified string
	 */
	public String getFormattedTime() {
		if (unixTimeStamp == 0) {
			return null;
		} else {
			Date date = new Date(unixTimeStamp * 1000L);
			return dateFormat.format(date);
		}
	}

	/**
	 * If unixTimeStamp class parameter is 0 - returns null, otherwise returns
	 * {@link GregorianCalendar} instance with TimeZone set to +3 GMT, and time
	 * set by unixTimeStamp.
	 * 
	 * @return specified {@link GregorianCalendar} instance
	 */
	public GregorianCalendar getStampAsDate() {
		if (unixTimeStamp == 0) {
			return null;
		} else {
			calendar.setTimeInMillis(unixTimeStamp * 1000L);
			return calendar;
		}
	}

	/**
	 * If unixTimeStamp class parameter is 0 - returns null, otherwise returns
	 * string kind of <b>"HH:mm:ss"</b> where <b>HH</b> - hours, <b>mm</b> -
	 * minutes, and <b>ss</b> - seconds respectively <blockquote>
	 * 
	 * <pre>
	 * Example: "14:06:12"
	 * </pre>
	 * 
	 * </blockquote>
	 * 
	 * @param unixTimeStamp
	 *            value
	 * @return specified string
	 */
	public static String getFormattedTime(long unixTimeStamp) {
		if (unixTimeStamp == 0) {
			return null;
		} else {
			Date date = new Date(unixTimeStamp * 1000L);
			return dateFormat.format(date);
		}
	}

	/**
	 * If unixTimeStamp parameter is 0 - returns null, otherwise returns
	 * {@link GregorianCalendar} instance with TimeZone set to +3 GMT, and time
	 * set by unixTimeStamp.
	 * 
	 * @param unixTimeStamp
	 *            value
	 * @return specified {@link GregorianCalendar} instance
	 */
	public static GregorianCalendar getStampAsdate(long unixTimeStamp) {
		if (unixTimeStamp == 0) {
			return null;
		} else {
			calendar.setTimeInMillis(unixTimeStamp * 1000L);
			return calendar;
		}
	}
}
