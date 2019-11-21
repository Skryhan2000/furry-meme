package com.loneliness.entity;

import java.io.Serializable;

public class Transmission implements Serializable {

    private int[] bounds;

    public int[] getBounds() {
        return bounds;
    }

    public void setBounds(int[] bounds) {
        this.bounds = bounds;
    }
}
