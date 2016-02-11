package kael.jea.sea.islands;

import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

import kael.jea.JEATimeStamp;

/**
 * {@link ResoursesUpdateTimer} class data object model.
 * 
 * @author Kael
 * @since JEA1.0
 * @see ResoursesUpdateTimer
 */
class ResoursesUpdateTimerDOM {
	@SerializedName("generation")
	private HashMap<String, String> updateData;
	@SerializedName("info")
	private JEATimeStamp createdAt;

	/**
	 * Returns map representation about islands update timecodes.
	 * 
	 * @return
	 */
	public HashMap<String, String> getUpdateData() {
		return updateData;
	}

	/**
	 * Returns {@link JEATimeStamp} instance with info about API last update
	 * time.
	 * 
	 * @return JEATimeStamp
	 */
	public JEATimeStamp getCreatedAt() {
		return createdAt;
	}
}
