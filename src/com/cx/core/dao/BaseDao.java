package com.cx.core.dao;

import com.cx.core.page.PageResult;
import com.cx.core.utils.QueryHelper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cxspace on 16-11-10.
 */
public interface BaseDao <T>{

//    basedao抽取

    public void save(T entity);

    public void update(T entity);

    public void delete(Serializable id);

    public T findObjectById(Serializable id);

    public List<T> findObjects();

    //分页查询实体列表
    public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);

}
