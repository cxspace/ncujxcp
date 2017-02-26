package com.cx.policy_doc.service.impl;

import com.cx.core.service.impl.BaseServiceImpl;
import com.cx.policy_doc.dao.PolicyDocDao;
import com.cx.policy_doc.entity.PolicyDoc;
import com.cx.policy_doc.service.PolicyDocService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liujie on 2017/2/25.
 */


@Service("policyDocService")

public class PolicyDocServiceImpl extends BaseServiceImpl<PolicyDoc> implements PolicyDocService {

    private PolicyDocDao policyDocDao;

    @Resource

    public void setPolicyDocDao(PolicyDocDao policyDocDao) {

        super.setBaseDao(policyDocDao);
        this.policyDocDao = policyDocDao;
    }


}
