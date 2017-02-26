package com.cx.core.service;

import com.cx.core.page.PageResult;
import com.cx.core.utils.QueryHelper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cxspace on 16-11-11.
 */
public interface BaseService <T>{

    public void save(T entity);

    public void update(T entity);

    public void delete(Serializable id);

    public T findObjectById(Serializable id);

    public List<T> findObjects();

    PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
}
