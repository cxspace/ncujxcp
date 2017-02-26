package com.cx.policy.entity;


import java.io.Serializable;

/**
 * Created by liujie on 2017/2/24.
 */
public class PolicyDocument implements Serializable{

    private PolicyDocumentId policyDocumentId;

    public PolicyDocumentId getPolicyDocumentId() {
        return policyDocumentId;
    }

    public void setPolicyDocumentId(PolicyDocumentId policyDocumentId) {
        this.policyDocumentId = policyDocumentId;
    }

    public PolicyDocument(PolicyDocumentId policyDocumentId) {
        this.policyDocumentId = policyDocumentId;
    }

    public PolicyDocument() {
    }
}
