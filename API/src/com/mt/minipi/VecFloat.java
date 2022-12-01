package com.mt.minipi;

import java.util.List;
import java.util.Scanner;

public class VecFloat {

    public static final VecFloat ZERO = new VecFloat(0, 0);
    public final float x, y;

    VecFloat(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create
     */
    public static VecFloat xy(float x, float y) {
        return new VecFloat(x, y);
    }

    /**
     * Add
     */
    public VecFloat add(VecFloat v) {
        return xy(x + v.x, y + v.y);
    }

    /**
     * Subtract
     */
    public VecFloat sub(VecFloat v) {
        return xy(x - v.x, y - v.y);
    }

    /**
     * Multiply with a float (scale)
     */
    public VecFloat mul(float s) {
        return xy(s * x, s * y);
    }

    /**
     * Negate (multiply with -1)
     */
    public VecFloat neg() {
        return mul(-1);
    }

    /**
     * Scalar product
     */
    public float dot(VecFloat v) {
        return x * v.x + y * v.y;
    }

    /**
     * Cross product
     */
    VecFloat cross(VecFloat v) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Get a vector in the same direction but with length 1
     */
    public VecFloat normalized() {
        return mul(1f / length());
    }

    /**
     * Length
     */
    public float length() {
        return (float) Math.sqrt(lengthSq());
    }

    /**
     * length * length
     */
    public float lengthSq() {
        return dot(this);
    }

    public static VecFloat decode(int[] encoded) {
    	if(encoded == null || encoded.length == 0) {
        	return ZERO;
        } else {
        	
        	if(encoded.length >= 2) {
        		return xy(encoded[0], encoded[1]);
        	}
        	return ZERO;
        }
    }

    @Override
    public final String toString() {
        return x + "," + y;
    }
}