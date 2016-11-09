package com.example.paulaanndroid.myfirstapp;

/**
 * Created by Paula Ann on 10/14/2016.
 */

public class StarID {
    private String name;
    private int id;
    private float ra;
    private float de;
    private float mag;

    public void setName(String inName) {
        name = inName;
    }

    public void setID(int inID) {
        id = inID;
    }

    public void setRa(float inRa) {
        ra = inRa;
    }

    public void setDe(float inDe) {
        de = inDe;
    }

    public void setMag(float inMag) {
        mag = inMag;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
