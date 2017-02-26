package com.cx.advice.dao.impl;

import com.cx.advice.dao.AdviceDao;
import com.cx.advice.entity.Advice;
import com.cx.advice.entity.AdviceDocument;
import com.cx.core.dao.impl.BaseDaoImpl;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class AdviceDaoImpl extends BaseDaoImpl<Advice> implements AdviceDao{

    @Override
    public void saveAdviceDocument(AdviceDocument adviceDocument) {
        getHibernateTemplate().save(adviceDocument);
    }

    @Override
    public List<AdviceDocument> getAdviceDocumentsByAdviceId(String adviceId) {

        Query q = getSession().createQuery("from AdviceDocument where adviceDocumentId.advice_id = ?");

        q.setParameter(0,adviceId);

        return q.list();
    }

    @Override
    public void deleteAdviceDocumentByDocId(String doc_id) {

        SQLQuery query = getSession().createSQLQuery("DELETE FROM t_r_advice_doc WHERE doc_id = '" +doc_id+ "'");

        query.executeUpdate();
    }
}
