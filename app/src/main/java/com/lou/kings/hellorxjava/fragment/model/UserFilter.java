package com.lou.kings.hellorxjava.fragment.model;

/**
 * Created by YiMuTian on 2017/1/9.
 */

public class UserFilter {
    private String name;
    private String address;

    public UserFilter(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
