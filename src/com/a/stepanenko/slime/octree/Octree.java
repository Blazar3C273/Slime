package com.a.stepanenko.slime.octree;

import com.a.stepanenko.slime.Cube;
import com.a.stepanenko.slime.Dot;
import org.apache.log4j.Logger;

import java.util.ArrayList;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 12.05.2015.
 */
public class Octree {
    private static final Logger log = Logger.getLogger(Octree.class);
    private Node root;

    public Octree(ArrayList<Dot> vertices) {


    }

    public static Cube getSurroundingCube(ArrayList<Dot> in_vertexes) {
        ArrayList<Dot> vertexes = new ArrayList<>(in_vertexes);
        Double xMin, xMax, yMin, yMax, zMin, zMax;
        vertexes.sort((o1, o2) -> o1.x.compareTo(o2.x));
        xMin = vertexes.get(0).x;
        xMax = vertexes.get(vertexes.size() - 1).x;
        vertexes.sort(((o1, o2) -> o1.y.compareTo(o2.y)));
        yMin = vertexes.get(0).y;
        yMax = vertexes.get(vertexes.size() - 1).y;
        vertexes.sort(((o1, o2) -> o1.z.compareTo(o2.z)));
        zMin = vertexes.get(0).z;
        zMax = vertexes.get(vertexes.size() - 1).z;

        return new Cube((new Dot(xMax, yMax, zMax)),
                new Dot(xMin, yMin, zMin));
    }
}
