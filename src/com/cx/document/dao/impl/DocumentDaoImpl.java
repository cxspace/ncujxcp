package com.cx.document.dao.impl;

import com.cx.core.dao.impl.BaseDaoImpl;
import com.cx.document.dao.DocumentDao;
import com.cx.document.entity.Document;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class DocumentDaoImpl extends BaseDaoImpl<Document> implements DocumentDao {
    @Override
    public List<Document> findIndexDocument() {
        Query query = getSession().createQuery("from Document order by time desc");

        query.setFirstResult(0);

        query.setMaxResults(5);

        return query.list();
    }
}
