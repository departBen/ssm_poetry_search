package com.bs.poetry.dao.impl;

import com.bs.poetry.common.StringUtils;
import com.bs.poetry.dao.PoetryDao;
import com.bs.poetry.entity.Poet;
import com.bs.poetry.entity.Poetry;
import com.bs.poetry.entity.page.PagePoetry;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/4/16.
 */
public class PoetryDaoImpl implements PoetryDao {

    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Poetry> searchByTitle(String title,int currentPage,int pageSize) {

        SqlSession session = sqlSessionFactory.openSession();
        List<Poetry> poetries = new ArrayList<>();
        try {
            PagePoetry p = new PagePoetry();

            p.setTitle(StringUtils.likeString(title));
            int startRow = (currentPage - 1)*pageSize;//由当前页转其实行
            p.setStart(startRow);
            p.setPageSize(pageSize);

            poetries = session.selectList("selectPoetry",p);
            session.commit();
            if (poetries.size()>0){
                for (Poetry poetry : poetries){
                    if (poetry.getPoet() != null){
                        poetry.getPoet().getName();
                    }
                }
            }
        } catch (Exception e){
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return poetries;
    }

    @Override
    public int getTotalByTitle(String title) {
        SqlSession session = sqlSessionFactory.openSession();
        List<Poetry> poetries = new ArrayList<>();
        try {
            PagePoetry p = new PagePoetry();
            p.setTitle(StringUtils.likeString(title));

            poetries = session.selectList("selectPoetry",p);
            session.commit();
        } catch (Exception e){
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return poetries.size();
    }

    @Override
    public List<Poetry> searchByContent(String content,int currentPage,int pageSize) {
        SqlSession session = sqlSessionFactory.openSession();
        List<Poetry> poetries = new ArrayList<>();
        try {
            PagePoetry p = new PagePoetry();

            p.setContent(StringUtils.likeString(content));
            int startRow = (currentPage - 1)*pageSize;//由当前页转其实行
            p.setStart(startRow);
            p.setPageSize(pageSize);

            poetries = session.selectList("selectPoetry",p);
            session.commit();
            if (poetries.size()>0){
                for (Poetry poetry : poetries){
                    if (poetry.getPoet() != null){
                        poetry.getPoet().getName();
                    }
                }
            }

        } catch (Exception e){
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return poetries;
    }

    @Override
    public int getTotalByContent(String content) {
        SqlSession session = sqlSessionFactory.openSession();
        List<Poetry> poetries = new ArrayList<>();
        try {
            PagePoetry p = new PagePoetry();
            p.setContent(StringUtils.likeString(content));

            poetries = session.selectList("selectPoetry",p);
            session.commit();
        } catch (Exception e){
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return poetries.size();
    }

    @Override
    public List<Poetry> searchByPoet(Poet poet, int currentPage, int pageSize) {
        SqlSession session = sqlSessionFactory.openSession();
        List<Poetry> poetries = new ArrayList<>();
        try {
            PagePoetry p = new PagePoetry();
            p.setPoet(poet);
            int startRow = (currentPage - 1)*pageSize;//由当前页转其实行
            p.setStart(startRow);
            p.setPageSize(pageSize);

            poetries = session.selectList("selectPoetry",p);
            session.commit();
            if (poetries.size()>0){
                for (Poetry poetry : poetries){
                    if (poetry.getPoet() != null){
                        poetry.getPoet().getName();
                    }
                }
            }

        } catch (Exception e){
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return poetries;
    }

    @Override
    public int getTotalByPoet(Poet poet) {
        SqlSession session = sqlSessionFactory.openSession();
        List<Poetry> poetries = new ArrayList<>();
        try {
            PagePoetry p = new PagePoetry();
            p.setPoet(poet);
            poetries = session.selectList("selectPoetry",p);
            session.commit();
        } catch (Exception e){
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return poetries.size();
    }

    @Override
    public Poetry getByPoetryId(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        Poetry poetry = null;
        try {
            PagePoetry p = new PagePoetry();
            p.setId(id);
            poetry = session.selectOne("selectPoetry",p);
            session.commit();
            if (poetry.getPoet() != null){
                poetry.getPoet().getName();
            }

        } catch (Exception e){
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return poetry;
    }

//    -----------------------get set----------------------------------

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
