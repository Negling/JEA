package kael.jea.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * This is an simple class, created to get data from ereality.ru API.
 * 
 * @author Kael
 * @since JEA1.1
 */
public class DataLoader {
	/**
	 * Returns an string representation of data from current URL.
	 * 
	 * @param url
	 *            from get data.
	 * @return string representation of received data.
	 * @throws IOException
	 *             if URL is incorrect, or no connection/access to game API.
	 */
	public static String getAPIData(String url) throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
			return in.readLine();
		}
	}
}
