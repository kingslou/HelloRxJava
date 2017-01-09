package com.lou.kings.hellorxjava.fragment.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by YiMuTian on 2017/1/9.
 */

public class User extends BaseObservable {
    private String name;
    private int    age;
    private boolean status;

    public User(){

    }

    public User(String name, int age, boolean status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    //注意 bindable不可少，不然BR里面找不到对应的id
    @Bindable
    public String getName() {
        return name;
    }
    @Bindable
    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public int getAge() {
        return age;
    }
    @Bindable
    public void setAge(int age) {
        this.age = age;
    }
    @Bindable
    public boolean isStatus() {
        return status;
    }
    @Bindable
    public void setStatus(boolean status) {
        this.status = status;
    }
}
