package kael.jea.sea.islands;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import kael.jea.sea.islands.IslandDOM.Sector;
import kael.jea.utils.JEATimeStamp;

/**
 * This class is an implementation of JsonDeserializer interface, used to
 * deserialise information from ereality.ru API to Island DOM.
 * 
 * @author Kael
 * @since JEA1.0
 * @see IslandDOM
 */
class IslandDOMDesializer implements JsonDeserializer<IslandDOM> {

	@Override
	public IslandDOM deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		Type collectionType = new TypeToken<ArrayList<Sector>>() {
		}.getType();
		ArrayList<Sector> sectors = context.deserialize(json.getAsJsonObject().get("map"), collectionType);
		HashMap<String, Sector> map = new HashMap<>(150);
		for (Sector sector : sectors) {
			map.put(sector.getLocation(), sector);
		}
		return new IslandDOM(map, context.deserialize(json.getAsJsonObject().get("info"), JEATimeStamp.class));
	}
}
