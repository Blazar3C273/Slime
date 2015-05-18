package com.a.stepanenko.slime.octree;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.apache.log4j.Logger;

import java.lang.reflect.Type;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 16.05.2015.
 */

public class NodeSerialization implements JsonSerializer<Node> {
    private static final Logger log = Logger.getLogger(NodeSerialization.class);

    @Override
    public JsonElement serialize(Node node, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result;
        result = new JsonObject();
        result.add("center", jsonSerializationContext.serialize(node.center));
        result.add("edgeLength", jsonSerializationContext.serialize(node.length));
        result.add("nodeType", jsonSerializationContext.serialize(node.getType()));
        result.add("deepLevel", jsonSerializationContext.serialize(node.getDeepLevel()));
        return result;
    }
}
