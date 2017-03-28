package com.cx.dynamic.dao.impl;

import com.cx.core.dao.impl.BaseDaoImpl;
import com.cx.dynamic.dao.DynamicDao;
import com.cx.dynamic.entity.Dynamic;
import com.cx.dynamic.entity.DynamicDocument;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class DynamicDaoImpl extends BaseDaoImpl<Dynamic> implements DynamicDao {


    @Override
    public void saveDynamicDocument(DynamicDocument dynamicDocument) {
        getHibernateTemplate().save(dynamicDocument);
    }

    @Override
    public List<DynamicDocument> getDynamicDocumentsByDynamicId(String dynamicId) {

        Query q = getSession().createQuery("from DynamicDocument where dynamicDocumentId.dynamic_id = ?");

        q.setParameter(0,dynamicId);

        return q.list();
    }

    @Override
    public void deleteDynamicDocumentByDocId(String doc_id) {

        SQLQuery query = getSession().createSQLQuery("DELETE FROM t_r_dynamic_doc WHERE doc_id = '" +doc_id+ "'");

        query.executeUpdate();
    }

    @Override
    public List<Dynamic> findIndexDynamic() {

        Query query = getSession().createQuery("from Dynamic order by time desc");

        query.setFirstResult(0);

        query.setMaxResults(7);

        return query.list();
    }
}
