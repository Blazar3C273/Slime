package com.a.stepanenko.slime;

import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 11.05.2015.
 */
public class Cube {
    private static final Logger log = Logger.getLogger(Cube.class);
    public final Dot a;
    public final Dot b;

    public Cube(@NotNull Dot a, @NotNull Dot b) {
        if (a == null || b == null) {
            NullPointerException exception = new NullPointerException("Dot might be not null.");
            log.error(exception.getMessage(), exception);
            throw exception;
        }
        this.a = a;
        this.b = b;
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
    }
}
