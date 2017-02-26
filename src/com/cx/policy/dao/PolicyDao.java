package com.cx.policy.dao;

import com.cx.core.dao.BaseDao;
import com.cx.policy.entity.Policy;
import com.cx.policy.entity.PolicyDocument;

import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */
public interface PolicyDao extends BaseDao<Policy> {
    //保存通知公告附件关系
    public void savePolicyDocument(PolicyDocument policyDocument);

    public List<PolicyDocument> getPolicyDocumentsByPolicyId(String policyId);

    public void deletePolicyDocumentByDocId(String doc_id);

    public List<Policy> findIndexPolicy();

}

