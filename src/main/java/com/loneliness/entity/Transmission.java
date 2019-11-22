package com.loneliness.entity;

import java.io.Serializable;

public class Transmission implements Serializable {
    private String command;
    private int[] bounds;
    private Index index;
    private UserData userData;

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

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
