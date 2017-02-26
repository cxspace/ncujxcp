package com.cx.inform.dao.impl;

import com.cx.core.dao.impl.BaseDaoImpl;
import com.cx.inform.dao.InfoDao;
import com.cx.inform.entity.Info;
import com.cx.inform.entity.InfoDocument;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */
public class InfoDaoImpl extends BaseDaoImpl<Info> implements InfoDao {

    @Override
    public void saveInfoDocument(InfoDocument infoDocument) {
        getHibernateTemplate().save(infoDocument);
    }

    @Override
    public List<InfoDocument> getInfoDocumentsByInfoId(String infoId) {

        Query q = getSession().createQuery("from InfoDocument where infoDocumentId.info_id = ?");

        q.setParameter(0,infoId);

        return q.list();
    }

    @Override
    public void deleteInfoDocumentByDocId(String doc_id) {

        SQLQuery query = getSession().createSQLQuery("DELETE FROM t_r_info_doc WHERE doc_id = '" +doc_id+ "'");

        query.executeUpdate();
    }

    @Override
    public List<Info> findIndexInfo() {

        Query query = getSession().createQuery("from Info");

        query.setFirstResult(0);

        query.setMaxResults(8);

        return query.list();
    }
}
