package com.bcit.miguelmarasigan_midterm;

import java.io.Serializable;

public class Hippo implements Serializable {

    private final String name;
    private final int age;
    private final String food;
    private final int resId;

    public Hippo(String name, int age, String food, int resId) {
        this.name = name;
        this.age = age;
        this.food = food;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFood() {
        return food;
    }

    public int getResId() {
        return resId;
    }
}
