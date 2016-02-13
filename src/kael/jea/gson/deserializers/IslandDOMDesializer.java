package kael.jea.gson.deserializers;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import kael.jea.sea.islands.IslandDOM;
import kael.jea.sea.islands.IslandDOM.Sector;
import kael.jea.utils.JEATimeStamp;

/**
 * This class is an implementation of JsonDeserializer interface, used to
 * deserialise information from ereality.ru API to Island DOM.
 * 
 * @author Kael
 * @since JEA1.1
 * @see IslandDOM
 */
public class IslandDOMDesializer implements JsonDeserializer<IslandDOM> {

	@Override
	public IslandDOM deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		IslandDOM dom = new IslandDOM();
		Type collectionType = new TypeToken<ArrayList<Sector>>() {
		}.getType();
		ArrayList<Sector> sectors = context.deserialize(json.getAsJsonObject().get("map"), collectionType);
		HashMap<String, Sector> map = new HashMap<>(150);
		for (Sector sector : sectors) {
			map.put(sector.getLocation(), sector);
		}
		try {
			Field sectorsField = dom.getClass().getDeclaredField("sectors");
			Field timeField = dom.getClass().getDeclaredField("createdAt");
			timeField.setAccessible(true);
			sectorsField.setAccessible(true);
			timeField.set(dom, context.deserialize(json.getAsJsonObject().get("info"), JEATimeStamp.class));
			sectorsField.set(dom, map);
			timeField.setAccessible(false);
			sectorsField.setAccessible(false);
		} catch (Exception exeption) {
			throw new JsonParseException(exeption.getMessage());
		}
		return dom;
	}
}
