package com.bs.poetry.service.impl;

import com.bs.poetry.dao.PoetDao;
import com.bs.poetry.dao.PoetryDao;
import com.bs.poetry.entity.Poet;
import com.bs.poetry.entity.Poetry;
import com.bs.poetry.service.PoetryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ben on 2017/4/16.
 */
@Service
public class PoetryServiceImpl implements PoetryService {
    @Resource
    private PoetryDao poetryDao;
    @Resource
    private PoetDao poetDao;


    @Override
    public List<Poetry> searchByPoetNamePaging(String name, int currentPage, int pageSize) {
        Poet poet = poetDao.searchByPoetName(name);
        if (poet != null){
            return poetryDao.searchByPoet(poet,currentPage,pageSize);
        } else {
            return null;
        }
    }

    @Override
    public int getTotalByPoetName(String name) {
        Poet poet = poetDao.searchByPoetName(name);
        if (poet != null){
            return poetryDao.getTotalByPoet(poet);
        } else {
            return 0;
        }

    }

    @Override
    public List<Poetry> searchByTitlePaging(String title, int currentPage, int pageSize) {
        return poetryDao.searchByTitle(title,currentPage,pageSize);
    }

    @Override
    public int getTotalByTitle(String title) {
        return poetryDao.getTotalByTitle(title);
    }

    @Override
    public List<Poetry> searchByContentPaging(String content, int currentPage, int pageSize) {
        return poetryDao.searchByContent(content,currentPage,pageSize);
    }

    @Override
    public int getTotalByContent(String content) {
        return poetryDao.getTotalByContent(content);
    }

    @Override
    public Poetry getByPoetryId(int id) {
        return poetryDao.getByPoetryId(id);
    }

    public PoetryDao getPoetryDao() {
        return poetryDao;
    }

    public void setPoetryDao(PoetryDao poetryDao) {
        this.poetryDao = poetryDao;
    }

    public PoetDao getPoetDao() {
        return poetDao;
    }

    public void setPoetDao(PoetDao poetDao) {
        this.poetDao = poetDao;
    }
}
