package com.example.huanxintest.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/21.
 */
public class person  implements Serializable{

    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
