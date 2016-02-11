package kael.jea.interfaces;

import java.io.IOException;

/**
 * Classes, that realize this interface is able to update containing data from
 * outer source.
 * 
 * @author Kael
 * @since JEA 1.0
 */
public interface Updatable {
	/**
	 * Updates class data from outer source. Outer source is specified to each
	 * class realization.
	 * 
	 * @throws IOException
	 *             of outer resource is unavailable.
	 */
	public void updateData() throws IOException;
}
