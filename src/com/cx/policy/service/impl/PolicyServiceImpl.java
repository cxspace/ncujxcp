package com.cx.policy.service.impl;

import com.cx.core.service.impl.BaseServiceImpl;
import com.cx.policy.dao.PolicyDao;
import com.cx.policy.entity.Policy;
import com.cx.policy.entity.PolicyDocument;
import com.cx.policy.entity.PolicyDocumentId;
import com.cx.policy.service.PolicyService;
import com.cx.policy_doc.entity.PolicyDoc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */

@Service("policyService")
public class PolicyServiceImpl extends BaseServiceImpl<Policy> implements PolicyService{


    private PolicyDao policyDao;

    @Resource
    public void setPolicyDao(PolicyDao policyDao) {

        super.setBaseDao(policyDao);
        this.policyDao = policyDao;
    }

    @Override
    public void savePolicyDocument(String policyId, String policyDocId) {
        policyDao.savePolicyDocument(new PolicyDocument(new PolicyDocumentId(policyId,new PolicyDoc(policyDocId))));
    }

    @Override
    public List<PolicyDocument> getPolicyDocumentsByPolicyId(String policyId) {
        return policyDao.getPolicyDocumentsByPolicyId(policyId);
    }

    @Override
    public void deletePolicyDocumentByDocId(String doc_id) {
        policyDao.deletePolicyDocumentByDocId(doc_id);
    }

    @Override
    public List<Policy> findIndexPolicy() {
        return policyDao.findIndexPolicy();
    }
}
