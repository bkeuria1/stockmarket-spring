package com.project.springboot.entities;

import java.io.Serializable;

public class PriceData implements Serializable {
    String name;
    float value;

    public PriceData(){}

    public PriceData(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
