package com.cx.policy.entity;

import com.cx.inform_doc.entity.InfoDoc;
import com.cx.policy_doc.entity.PolicyDoc;

import java.io.Serializable;

/**
 * Created by liujie on 2017/2/24.
 */
public class PolicyDocumentId implements Serializable{

    private String policy_id;

    private PolicyDoc policyDoc;

    public String getPolicy_id() {
        return policy_id;
    }

    public void setPolicy_id(String policy_id) {
        this.policy_id = policy_id;
    }

    public PolicyDoc getPolicyDoc() {
        return policyDoc;
    }

    public void setPolicyDoc(PolicyDoc policyDoc) {
        this.policyDoc = policyDoc;
    }

    public PolicyDocumentId(String policy_id, PolicyDoc policyDoc) {
        this.policy_id = policy_id;
        this.policyDoc = policyDoc;
    }

    public PolicyDocumentId() {
    }
}
