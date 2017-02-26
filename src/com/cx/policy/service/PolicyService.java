package com.cx.policy.service;

import com.cx.core.service.BaseService;
import com.cx.policy.entity.Policy;
import com.cx.policy.entity.PolicyDocument;

import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */
public interface PolicyService extends BaseService<Policy> {

    public void savePolicyDocument(String policyId , String policyDocId);

    public List<PolicyDocument> getPolicyDocumentsByPolicyId(String policyId);

    public void deletePolicyDocumentByDocId(String doc_id);

}
