package com.mt.minipi;

import java.util.List;
import java.util.Scanner;

public class Vec {

    public final static Vec ZERO = new Vec(0, 0);
    public final int x, y;

    Vec(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create
     */
    public static Vec xy(int x, int y) {
        return new Vec(x, y);
    }

    /**
     * Add
     */
    public Vec add(Vec v) {
        return xy(x + v.x, y + v.y);
    }

    /**
     * Add
     */
    public Vec add(int x, int y) {
        return xy(this.x + x, this.y + y);
    }

    /**
     * Subtract
     */
    public Vec sub(Vec v) {
        return xy(x - v.x, y - v.y);
    }

    /**
     * Multiply with integer (scale)
     */
    public Vec mul(int s) {
        return xy(s * x, s * y);
    }

    /**
     * Negate (multiply with -1)
     */
    public Vec neg() {
        return xy(-x, -y);
    }

    /**
     * Scalar product
     */
    public int dot(Vec v) {
        return x * v.x + y * v.y;
    }

    @Override
    public int hashCode() {
        return x | (y << 20);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vec)) {
            return false;
        }
        return hashCode() == ((Vec) obj).hashCode();
    }

    @Override
    public final String toString() {
        return x + "," + y;
    }

    public static Vec decode(int[] encoded) {
        if(encoded == null || encoded.length == 0) {
        	return ZERO;
        } else {
        	if(encoded.length >= 2) {
        		return xy(encoded[0], encoded[1]);
        	}
        	return ZERO;
        }
    }

    /**
     * A vector with length=1
     */
    public static class Unit extends Vec {

        public final static Unit X = new Unit(1, 0);
        public final static Unit Y = new Unit(0, 1);
        

        Unit(int x, int y) {
            super(x, y);
        }

        @Override
        public Unit neg() {
            return new Unit(-x, -y);
        }
    }
}