package com.a.stepanenko.slime;

import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 11.05.2015.
 */
public class Cube {
    private static final Logger log = Logger.getLogger(Cube.class);
    public final Dot max;
    public final Dot min;
    public final Dot edgeBegin;
    public final Dot edgeEnd;
    public final double edgeLength;

    public Dot getCubeCenter() {
        return new Dot(edgeBegin.x + edgeLength / 2, edgeBegin.y + edgeLength / 2, edgeBegin.z + edgeLength / 2);
    }

    public Cube(@NotNull Dot dotA, @NotNull Dot dotB) {

        if (dotA == null || dotB == null) {
            NullPointerException exception = new NullPointerException("Dot might be not null.");
            log.error(exception.getMessage(), exception);
            throw exception;
        }

        this.max = dotA.x + dotA.y + dotA.z > dotB.x + dotB.y + dotB.z ? dotA : dotB;
        this.min = this.max.equals(dotA) ? dotB : dotA;
        //find out what axis is longer
        double xLength, yLength, zLength;

        xLength = Math.abs(dotA.x - dotB.x);
        yLength = Math.abs(dotA.y - dotB.y);
        zLength = Math.abs(dotA.z - dotA.z);


        if (xLength >= yLength && xLength >= zLength) {
            edgeLength = xLength;
        } else if (yLength >= xLength && yLength >= zLength) {
            edgeLength = yLength;
        } else {
            edgeLength = zLength;
        }

        //create edge from min to maxAxis length
        edgeBegin = this.min;
        edgeEnd = new Dot(min.x + edgeLength, min.y + edgeLength, min.z + edgeLength);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cube)) return false;

        Cube cube = (Cube) o;

        if (!max.equals(cube.max)) return false;
        return min.equals(cube.min);

    }

    @Override
    public int hashCode() {
        int result = max.hashCode();
        result = 31 * result + min.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "max=" + max +
                ", min=" + min +
                ", edgeBegin=" + edgeBegin +
                ", edgeEnd=" + edgeEnd +
                ", edgeLength=" + edgeLength +
                ", cubeCenter=" + getCubeCenter() +
                '}';
    }

}
