package com.bs.poetry.service;

import com.bs.poetry.entity.Poetry;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ben on 2017/4/16.
 */
public interface PoetryService {
    /**
     * 根据诗人名分页查询
     * @param name
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Poetry> searchByPoetNamePaging(String name,int currentPage,int pageSize);

    /**
     * 根据诗人名查询诗歌数
     * @param name
     * @return
     */
    int getTotalByPoetName(String name);

    /**
     * 根据标题分页查询
     * @param title
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Poetry> searchByTitlePaging(String title,int currentPage,int pageSize);

    /**
     * 根据诗歌名查询诗歌数
     * @param title
     * @return
     */
    int getTotalByTitle(String title);
    /**
     * 根据名句分页查询
     * @param content
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<Poetry> searchByContentPaging(String content,int currentPage,int pageSize);

    /**
     * 根据名句查询诗歌数
     * @param content
     * @return
     */
    int getTotalByContent(String content);

    /**
     * 根据id获取诗歌
     * @param id
     * @return
     */
    Poetry getByPoetryId(int id);
}
