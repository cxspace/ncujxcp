package com.cx.policy.dao.impl;

import com.cx.core.dao.impl.BaseDaoImpl;
import com.cx.policy.dao.PolicyDao;
import com.cx.policy.entity.Policy;
import com.cx.policy.entity.PolicyDocument;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */
public class PolicyDaoImpl extends BaseDaoImpl<Policy> implements PolicyDao {
    @Override
    public void savePolicyDocument(PolicyDocument policyDocument) {
        getHibernateTemplate().save(policyDocument);
    }

    @Override
    public List<PolicyDocument> getPolicyDocumentsByPolicyId(String policyId) {

        Query q = getSession().createQuery("from PolicyDocument where policyDocumentId.policy_id = ?");

        q.setParameter(0,policyId);

        return q.list();
    }

    @Override
    public void deletePolicyDocumentByDocId(String doc_id) {
        SQLQuery query = getSession().createSQLQuery("DELETE FROM t_r_policy_doc WHERE doc_id = '" +doc_id+ "'");
        query.executeUpdate();
    }
}
