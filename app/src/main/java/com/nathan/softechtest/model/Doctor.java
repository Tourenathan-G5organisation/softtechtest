package com.nathan.softechtest.model;

import android.widget.ImageView;

public class Doctor {

    public String image;
    public String name;
    public String specialisation;

    public Doctor(String name, String specialisation, String image) {
        this.name = name;
        this.specialisation = specialisation;
        this.image = image;
    }
}
