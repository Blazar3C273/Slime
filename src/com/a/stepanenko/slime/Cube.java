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

    public Cube(@NotNull Dot max, @NotNull Dot min) {
        if (max == null || min == null) {
            NullPointerException exception = new NullPointerException("Dot might be not null.");
            log.error(exception.getMessage(), exception);
            throw exception;
        }
        this.max = max;
        this.min = min;
    }

    public static class Dot {
        public final Double x;
        public final Double y;
        public final Double z;

        public Dot(@NotNull Double x, @NotNull Double y, @NotNull Double z) {
            if (x == null || y == null || z == null) {
                NullPointerException exception = new NullPointerException("Dimensions might be not null.");
                log.error(exception.getMessage(), exception);
                throw exception;
            }
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Dot)) return false;

            Dot dot = (Dot) o;

            if (!x.equals(dot.x)) return false;
            if (!y.equals(dot.y)) return false;
            return z.equals(dot.z);

        }

        @Override
        public int hashCode() {
            int result = x.hashCode();
            result = 31 * result + y.hashCode();
            result = 31 * result + z.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Dot{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
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
                '}';
    }
}
