package com.a.stepanenko.slime.octree;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.log4j.Logger;

import java.util.ArrayList;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 12.05.2015.
 */
public class Octree {
    @Expose(serialize = false, deserialize = false)
    private static final Logger log = Logger.getLogger(Octree.class);
    @SerializedName("Root node")
    private Node root;
    @Expose(serialize = false, deserialize = false)
    private ArrayList<Polygon> polygons;
    private String fileName;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
