package com.eason.springmvc.domain;

/**
 * Created by feng yingsheng on 10/4/2017.
 */
public class SimpleMessage {

    long id;

    String name;

    public SimpleMessage(Long aLong, String s) {
        this.id = aLong;
        this.name = s;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
