
package com.cx.core.dao.impl;

import com.cx.core.dao.BaseDao;
import com.cx.core.page.PageResult;
import com.cx.core.utils.QueryHelper;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by cxspace on 16-11-11.
 */
public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

    Class<T> clazz;

    public BaseDaoImpl(){

        //反射拿到对象的类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();

        clazz = (Class<T>)pt.getActualTypeArguments()[0];

    }

    @Override
    public void delete(Serializable id) {

        getHibernateTemplate().delete(findObjectById(id));

    }

    @Override
    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }

    @Override
    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public T findObjectById(Serializable id) {
        return getHibernateTemplate().get(clazz,id);
    }

    @Override
    public List<T> findObjects() {

        Query query = getSession().createQuery("FROM "+clazz.getSimpleName());

        return query.list();
    }

    @Override
    public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {

        Query query = getSession().createQuery(queryHelper.getQueryListHql());

        List<Object> parameters = queryHelper.getParameters();

        //设置查询参数条件
        if (parameters != null){

            for (int i = 0 ; i < parameters.size() ; i++){
                query.setParameter(i,parameters.get(i));
            }
        }

        //防止分页数小于1
        if (pageNo<1) pageNo = 1;

        query.setFirstResult((pageNo-1)*pageSize);//设置查询起始索引
        query.setMaxResults(pageSize); //设置每页条数


        List items = query.list();

        //拿到总记录数
        Query queryCount = getSession().createQuery(queryHelper.getQueryCountHql());


        if (parameters!=null){

            for (int i = 0 ; i < parameters.size() ; i++){
                queryCount.setParameter(i,parameters.get(i));
            }

        }

        long totalCount = (Long) queryCount.uniqueResult();

        return new PageResult(pageSize,pageNo,items,totalCount);
    }
}
