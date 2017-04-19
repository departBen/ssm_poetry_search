package com.bs.poetry.dao;

import com.bs.poetry.entity.Poet;

/**
 * Created by ben on 2017/4/15.
 */
public interface PoetDao {
    /**
     * 根据诗人名查询
     * @param name
     * @return
     */
    Poet searchByPoetName(String name);
}
