package com.cx.policy.action;

import com.cx.core.action.BaseAction;
import com.cx.core.page.PageResult;
import com.cx.core.utils.QueryHelper;
import com.cx.policy.entity.Policy;
import com.cx.policy.entity.PolicyDocument;
import com.cx.policy.service.PolicyService;
import com.cx.policy_doc.entity.PolicyDoc;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class PolicyFrontAction extends BaseAction {

    @Resource
    private PolicyService policyService;

    private PageResult pageResult;

    private Policy policy;

    private List<Policy> policyList = new ArrayList<>();

    private List<PolicyDoc> policyDocList = new ArrayList<>();

    private List<PolicyDocument> policyDocumentList = new ArrayList<>();

    public String policyList(){

        QueryHelper queryHelper = new QueryHelper(Policy.class,"i");

        queryHelper.addOrderByProperty("i.time",QueryHelper.ORDER_BY_DESC);

        pageResult = policyService.getPageResult(queryHelper,getPageNo(),getPageSize());

        return "policyList";
    }


    public String policy_detail(){


        if(policy != null){

            if (policy.getId()!=null){

                policy = policyService.findObjectById(policy.getId());

                long count = policy.getCount();

                count ++;

                policy.setCount(count);

                policyService.update(policy);

                policyDocumentList = policyService.getPolicyDocumentsByPolicyId(policy.getId());

                //查出所有附件

                for (int i = 0 ; i < policyDocumentList.size() ; i++){
                    policyDocList.add(policyDocumentList.get(i).getPolicyDocumentId().getPolicyDoc());
                }

            }

        }

        return "policy_detail";
    }

    public List<PolicyDoc> getPolicyDocList() {
        return policyDocList;
    }

    public void setPolicyDocList(List<PolicyDoc> policyDocList) {
        this.policyDocList = policyDocList;
    }

    public List<PolicyDocument> getPolicyDocumentList() {
        return policyDocumentList;
    }

    public void setPolicyDocumentList(List<PolicyDocument> policyDocumentList) {
        this.policyDocumentList = policyDocumentList;
    }

    public PolicyService getPolicyService() {
        return policyService;
    }

    public void setPolicyService(PolicyService policyService) {
        this.policyService = policyService;
    }

    public PageResult getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageResult pageResult) {
        this.pageResult = pageResult;
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
