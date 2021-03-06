package com.a.stepanenko.slime.octree;

import com.a.stepanenko.slime.Dot;
import org.apache.log4j.Logger;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 15.05.2015.
 */
public class Polygon {
    private static final Logger log = Logger.getLogger(Polygon.class);
    private final Dot[] dots;
    private float[][] floats;

    public Polygon(Dot[] dots) {
        this.dots = dots;
        this.floats = new float[][]{dots[0].getDotAsFloat(), dots[1].getDotAsFloat(), dots[2].getDotAsFloat()};
    }

    public Dot[] getDots() {
        return dots;
    }

    public float[][] getDotsAsFloat() {
        return floats;
    }
}
