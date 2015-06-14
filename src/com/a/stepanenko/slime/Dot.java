package com.a.stepanenko.slime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sun.istack.internal.NotNull;
import org.apache.log4j.Logger;


/**
 * Project S.L.I.M.E.
 * Created by Anatoliy on 13.05.2015.
 */
public class Dot {
    @Expose(serialize = false, deserialize = false)
    private Logger log = Logger.getLogger(Dot.class);
    @Expose
    @SerializedName("x")
    public final Double x;
    @Expose
    @SerializedName("y")
    public final Double y;
    @Expose
    @SerializedName("z")
    public final Double z;
    private final float[] floats;


    public Dot(@NotNull Double x, @NotNull Double y, @NotNull Double z) {
        if (x == null || y == null || z == null) {
            NullPointerException exception = new NullPointerException("Dimensions might be not null.");
            log.error(exception.getMessage(), exception);
            throw exception;
        }
        this.x = x;
        this.y = y;
        this.z = z;
        this.floats = new float[]{x.floatValue(), y.floatValue(), z.floatValue()};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dot)) return false;

        Dot dot = (Dot) o;

        if (!x.equals(dot.x)) return false;
        return y.equals(dot.y) && z.equals(dot.z);

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

    public double[] getDot() {
        return new double[]{x, y, z};
    }

    public float[] getDotAsFloat() {
        return floats;
    }
}
