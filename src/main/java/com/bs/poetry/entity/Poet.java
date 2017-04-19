package com.bs.poetry.entity;

import java.util.List;

/**
 * Created by ben on 2017/4/15.
 */
public class Poet {
    private int id;
    private String name;
    private List<Poetry> poetries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Poetry> getPoetries() {
        return poetries;
    }

    public void setPoetries(List<Poetry> poetries) {
        this.poetries = poetries;
    }
}
