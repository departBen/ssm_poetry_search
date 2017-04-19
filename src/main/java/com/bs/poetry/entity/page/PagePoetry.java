package com.bs.poetry.entity.page;

import com.bs.poetry.entity.Poetry;

/**
 * 带分页信息
 */
public class PagePoetry extends Poetry {
    private int start;
    private int pageSize;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
