package com.a.stepanenko.slime;

import com.google.gson.*;
import org.apache.log4j.Logger;

import java.lang.reflect.Type;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 17.05.2015.
 */
public class DotSerializator implements JsonSerializer<Dot> {
    private static final Logger log = Logger.getLogger(DotSerializator.class);

    @Override
    public JsonElement serialize(Dot src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("x", new JsonPrimitive(src.x));
        result.add("y", new JsonPrimitive(src.y));
        result.add("z", new JsonPrimitive(src.z));
        return result;
    }
}
