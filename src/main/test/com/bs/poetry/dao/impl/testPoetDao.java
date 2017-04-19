package com.bs.poetry.dao.impl;

import com.bs.poetry.dao.PoetDao;
import com.bs.poetry.dao.PoetryDao;
import com.bs.poetry.entity.Poet;
import com.bs.poetry.entity.Poetry;
import com.bs.poetry.service.PoetryService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ben on 2017/4/15.
 */
public class testPoetDao {

    @Test
    public void poetDaoTest(){
        ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
        PoetDao poetDao = context.getBean("poetDao",PoetDao.class);
        Poet poet = poetDao.searchByPoetName("李白");
        List<Poetry> poetries = poet.getPoetries();
        System.out.println(poetries.size());
        for (Poetry poetry : poetries){
            System.out.println(poetry.getTitle());
        }
    }

    @Test
    public void poetryDaoTest(){
        ApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
        PoetryDao poetryDao = context.getBean("poetryDao",PoetryDaoImpl.class);
        PoetDao poetDao = context.getBean("poetDao",PoetDaoImpl.class);

//        List<Poetry> poetries = poetryDao.searchByTitle("歌",1,9);
//        List<Poetry> poetries = poetryDao.searchByContent("马",1,5);
        Poet poet = poetDao.searchByPoetName("李白");
        List<Poetry> poetries = poetryDao.searchByPoet(poet,2,10);

        for (Poetry poetry :poetries){
            System.out.println(poetry.getTitle());
            System.out.println(poetry.getPoet().getName());
        }
    }

    @Test
    public void poetryServiceTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PoetryService poetryService = context.getBean("poetryServiceImpl",PoetryService.class);
//        List<Poetry>poetries =  poetryService.searchByContentPaging("月",1,10);
//        List<Poetry>poetries =  poetryService.searchByPoetNamePaging("李白",6,10);
//        List<Poetry>poetries =  poetryService.searchByTitlePaging("歌",1,5);
//        for (Poetry poetry :poetries){
//            System.out.println(poetry.getTitle());
//            System.out.println(poetry.getPoet().getName());
//        }
//        System.out.println("李白有多少首诗：" + poetryService.getTotalByPoetName("李白"));
        Poetry poetry = poetryService.getByPoetryId(5);
        System.out.println(poetry.getTitle());
    }
}

