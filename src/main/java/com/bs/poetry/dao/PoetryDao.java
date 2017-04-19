package com.bs.poetry.dao;

import com.bs.poetry.entity.Poet;
import com.bs.poetry.entity.Poetry;

import java.util.List;

/**
 * Created by ben on 2017/4/16.
 */
public interface PoetryDao {
    /**
     * 根据诗歌名分页查询诗歌
     * @param title
     * @return
     */
    List<Poetry> searchByTitle(String title,int currentPage,int pageSize);

    /**
     * 获取根据标题查询的诗歌数
     * @param title
     * @return
     */
    int getTotalByTitle(String title);

    /**
     * 根据名句分页查询诗歌
     * @param content
     * @return
     */
    List<Poetry> searchByContent(String content,int currentPage,int pageSize);

    /**
     * 根据名句查询出的诗歌数
     * @param content
     * @return
     */
    int getTotalByContent(String content);

    /**
     * 根据诗人分页查询诗歌
     * @param poet
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Poetry> searchByPoet(Poet poet,int currentPage,int pageSize);

    /**
     * 根据诗人查询出的诗歌数
     * @param poet
     * @return
     */
    int getTotalByPoet(Poet poet);

    /**
     * 根据id获取诗歌
     * @param id
     * @return
     */
    Poetry getByPoetryId(int id);
}
