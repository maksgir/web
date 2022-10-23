package com.maksgir.beans;

import javax.inject.Named;

@Named
public class ExampleBean {
    private String name = "Maks";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
