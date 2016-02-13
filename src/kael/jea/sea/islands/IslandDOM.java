package kael.jea.sea.islands;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

import kael.jea.utils.JEATimeStamp;

/**
 * {@link Island} class data object model.
 * 
 * @author Kael
 * @since JEA1.0
 * @see Island
 */
class IslandDOM {
	
	protected IslandDOM(HashMap<String, Sector> sectors, JEATimeStamp createdAt) {
		this.sectors = sectors;
		this.createdAt = createdAt;
	}

	@SerializedName("map")
	private HashMap<String, Sector> sectors;
	@SerializedName("info")
	private JEATimeStamp createdAt;

	/**
	 * Returns list with all explored sectors at current moment of time.
	 * 
	 * @return {@link ArrayList} list
	 */
	public HashMap<String, Sector> getSectors() {
		return sectors;
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

	/**
	 * Simple class, that represent information about specified island sector.
	 * 
	 * @author Kael
	 * @since JEA1.0
	 */
	public class Sector {
		private int objectId;
		private int resourceId;
		private int resourceCount;
		private int[] clanOwners;
		private int[] heroOwners;
		@SerializedName("place")
		private String location;

		/**
		 * Returns sector object id.
		 * 
		 * @return integer value
		 */
		public int getObjectId() {
			return objectId;
		}

		/**
		 * Returns sector resource id.
		 * 
		 * @return integer value
		 */
		public int getResourceId() {
			return resourceId;
		}

		/**
		 * Returns sector resources value.
		 * 
		 * @return integer value
		 */
		public int getResourceCount() {
			return resourceCount;
		}

		/**
		 * Returns sector clan owners id as array.
		 * 
		 * @return int[] array
		 */
		public int[] getClanOwners() {
			return clanOwners;
		}

		/**
		 * Returns sector character owners id as array.
		 * 
		 * @return int[] array
		 */
		public int[] getHeroOwners() {
			return heroOwners;
		}

		/**
		 * Returns sector location id as string value.
		 * 
		 * @return string value
		 */
		public String getLocation() {
			return location;
		}
	}
}
