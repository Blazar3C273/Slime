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

    public Cube(@NotNull Dot max, @NotNull Dot min) {
        if (max == null || min == null) {
            NullPointerException exception = new NullPointerException("Dot might be not null.");
            log.error(exception.getMessage(), exception);
            throw exception;
        }
        this.max = max;
        this.min = min;
        //find out what axis is longer
        double xLength, yLength, zLength;

        xLength = max.x - min.x;
        yLength = max.y - min.y;
        zLength = max.z - max.z;


        if (xLength > yLength && xLength > zLength) {
            edgeLength = xLength;
        } else if (yLength > xLength && yLength > zLength) {
            edgeLength = yLength;
        } else {
            edgeLength = zLength;
        }

        //create edge from min to maxAxis length
        edgeBegin = min;
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
                '}';
    }

}
