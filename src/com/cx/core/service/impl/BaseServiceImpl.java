package com.cx.core.service.impl;

import com.cx.core.dao.BaseDao;
import com.cx.core.page.PageResult;
import com.cx.core.service.BaseService;
import com.cx.core.utils.QueryHelper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cxspace on 16-11-11.
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> baseDao;

    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void delete(Serializable id) {
        baseDao.delete(id);
    }

    @Override
    public void save(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    public T findObjectById(Serializable id) {
        return baseDao.findObjectById(id);
    }

    @Override
    public List<T> findObjects() {
        return baseDao.findObjects();
    }

    @Override
    public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
        return baseDao.getPageResult(queryHelper,pageNo,pageSize);
    }
}
