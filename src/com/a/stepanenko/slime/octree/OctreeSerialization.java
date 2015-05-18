package com.a.stepanenko.slime.octree;

import com.google.gson.*;
import org.apache.log4j.Logger;

import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 16.05.2015.
 */
public class OctreeSerialization implements JsonSerializer<Octree> {
    private static final Logger log = Logger.getLogger(OctreeSerialization.class);

    @Override
    public JsonElement serialize(Octree octree, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();

        ArrayList<Node> nodes = new ArrayList<>();

        nodes.add(octree.getRoot());

        int previousIterationArraySize = 0;

        while (previousIterationArraySize != nodes.size()) {
            int tmp = previousIterationArraySize;

            previousIterationArraySize = nodes.size();

            for (int i = tmp; i < previousIterationArraySize; i++) {
                Node localNode = nodes.get(i);
                nodes.addAll(localNode.getChildNodes() == null ? new ArrayList<>() : localNode.getChildNodes());
            }
        }

        JsonArray jsonElement = new JsonArray();
        for (Node node : nodes) {
            jsonElement.add(jsonSerializationContext.serialize(node));
        }

        result.add("nodesAmount", jsonSerializationContext.serialize(nodes.size()));
        result.add("rootNode", jsonSerializationContext.serialize(octree.getRoot()));
        result.add("nodesList", jsonElement);

        return result;
    }
}
