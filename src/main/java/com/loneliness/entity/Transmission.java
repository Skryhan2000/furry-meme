package com.loneliness.entity;

import java.io.Serializable;

public class Transmission implements Serializable {

    private int[] bounds;
    private Index index;

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public int[] getBounds() {
        return bounds;
    }

    public void setBounds(int[] bounds) {
        this.bounds = bounds;
    }
}
