package com.cx.assessment.dao.impl;

import com.cx.assessment.dao.AssessmentDao;
import com.cx.assessment.entity.Assessment;
import com.cx.assessment.entity.AssessmentDocument;
import com.cx.core.dao.impl.BaseDaoImpl;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class AssessmentDaoImpl extends BaseDaoImpl<Assessment> implements AssessmentDao{

    @Override
    public void saveAssessmentDocument(AssessmentDocument assessmentDocument) {
        getHibernateTemplate().save(assessmentDocument);
    }

    @Override
    public List<AssessmentDocument> getAssessmentDocumentsByAssessmentId(String assessmentId) {


        Query q = getSession().createQuery("from AssessmentDocument where assessmentDocumentId.assessment_id = ?");

        q.setParameter(0,assessmentId);

        return q.list();
    }

    @Override
    public void deleteAssessmentDocumentByDocId(String doc_id) {

        SQLQuery query = getSession().createSQLQuery("DELETE FROM t_r_assessment_doc WHERE doc_id = '" +doc_id+ "'");

        query.executeUpdate();
    }

    @Override
    public List<Assessment> findIndexAssessment() {

        Query query = getSession().createQuery("from Assessment");

        query.setFirstResult(0);

        query.setMaxResults(6);

        return query.list();
    }
}
