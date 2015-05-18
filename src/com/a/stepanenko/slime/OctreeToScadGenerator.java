package com.a.stepanenko.slime;

import com.a.stepanenko.slime.octree.Node;
import com.a.stepanenko.slime.octree.Octree;
import com.a.stepanenko.slime.octree.OctreeFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 18.05.2015.
 */
public class OctreeToScadGenerator {
    private static final Logger log = Logger.getLogger(OctreeToScadGenerator.class);

    public static String generateToFile(Octree octree) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Node> nodes = OctreeFactory.getNodesAsArrayList(octree);
        String first = "cubes = [";
        String last = "];\nimport (\"" + octree.getFileName().substring(1) + "\");\nfor (i = [0:" + nodes.size() + "]){" +
                " translate([cubes[i][0],cubes[i][1],cubes[i][2]]) cube(cubes[i][3],center=true);" +
                "}";
        stringBuilder.append(first);
        for (Node node : nodes) {
            if (node.getType() == Node.Type.BLACK)
                stringBuilder.append("[").append(node.center.x).append(",").append(node.center.y).
                        append(",").append(node.center.z).append(",").append(node.length).append("],\n");
        }
        stringBuilder.append(last);
        return stringBuilder.toString();
    }
}
