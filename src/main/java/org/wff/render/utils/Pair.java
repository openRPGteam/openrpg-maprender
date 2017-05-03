package org.wff.render.utils;

import java.io.Serializable;

public class Pair implements Serializable {
    private long x;
    private long y;

    public Pair(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
