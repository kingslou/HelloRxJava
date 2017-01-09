package com.lou.kings.hellorxjava.fragment.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by YiMuTian on 2017/1/9.
 */

public class User extends BaseObservable {
    private String Name;

    //注意 bindable不可少，不然BR里面找不到对应的id
    @Bindable
    public String getName() {
        return Name;
    }
    @Bindable
    public void setName(String name) {
        this.Name = name;
        notifyPropertyChanged(BR.name);
    }
}
