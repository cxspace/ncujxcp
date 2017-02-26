package com.cx.policy.action;

import com.cx.core.action.BaseAction;
import com.cx.core.utils.DateTimeHelper;
import com.cx.policy.entity.Policy;
import com.cx.policy.service.PolicyService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */
public class PolicySysAction extends BaseAction {

    @Resource
    private PolicyService policyService;

    private Policy policy;

    private List<Policy> policyList = new ArrayList<>();

    public String listUI(){

        policyList = policyService.findObjects();

        return "listUI";
    }

    public String addUI(){

        return "addUI";
    }

    public String add(){

        if (policy != null){

            policy.setTime(DateTimeHelper.getCurrentDateTime());
            policy.setCount(0);

            policyService.save(policy);
        }

        return "list";
    }

    public String delete(){

        if (policy != null){

            if (policy.getId()!=null){

                policyService.delete(policy.getId());

            }

        }

        return "list";
    }

    public PolicyService getPolicyService() {
        return policyService;
    }

    public void setPolicyService(PolicyService policyService) {
        this.policyService = policyService;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public List<Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<Policy> policyList) {
        this.policyList = policyList;
    }
}
