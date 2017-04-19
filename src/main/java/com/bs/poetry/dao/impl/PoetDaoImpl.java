package com.bs.poetry.dao.impl;

import com.bs.poetry.dao.PoetDao;
import com.bs.poetry.entity.Poet;
import com.bs.poetry.entity.Poetry;
import com.bs.poetry.entity.page.PagePoet;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by ben on 2017/4/15.
 */
public class PoetDaoImpl  implements PoetDao {

    private SqlSessionFactory sqlSessionFactory;

    @Override
    public Poet searchByPoetName(String name) {

        SqlSession session = sqlSessionFactory.openSession();
        Poet poet = null;
        try {
            Poet p = new Poet();
            p.setName(name);
            poet = session.selectOne("selectPoet",p);
            session.commit();
        } catch (Exception e){
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return poet;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
