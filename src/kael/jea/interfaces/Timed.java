package kael.jea.interfaces;

import java.util.GregorianCalendar;

/**
 * Classes, that realize this interface is able to provide information about
 * time, when data they are containing, was updated last time. It may happens in
 * two ways, by a specified string, formated as time value, or instance of
 * {@link GregorianCalendar} calendar, set to specified data.
 * 
 * @author Kael
 * @since JEA1.0
 */
public interface Timed {
	/**
	 * Returns instance of {@link GregorianCalendar} with specified time set.
	 * 
	 * @return specified {@link GregorianCalendar} instance
	 */
	public GregorianCalendar infoDate();

	/**
	 * Returns specified formatted string, contains time value.
	 * 
	 * @return specified string
	 */
	public String infoDateAsString();
}
