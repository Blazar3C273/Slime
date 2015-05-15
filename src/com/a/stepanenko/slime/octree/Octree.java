package com.a.stepanenko.slime.octree;

import org.apache.log4j.Logger;

import java.util.ArrayList;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 12.05.2015.
 */
public class Octree {
    private static final Logger log = Logger.getLogger(Octree.class);
    private Node root;
    private ArrayList<Polygon> polygons;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
