package com.cx.policy_doc.action;

import com.cx.core.action.BaseAction;
import com.cx.core.utils.DateTimeHelper;
import com.cx.policy.entity.Policy;
import com.cx.policy.entity.PolicyDocument;
import com.cx.policy.service.PolicyService;
import com.cx.policy_doc.entity.PolicyDoc;
import com.cx.policy_doc.service.PolicyDocService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by liujie on 2017/2/25.
 */
public class PolicyDocSysAction extends BaseAction{

    @Resource
    private PolicyService policyService;

    @Resource
    private PolicyDocService policyDocService;

    private PolicyDocument policyDocument;

    private Policy policy;

    private PolicyDoc policyDoc;

    private File document;

    private String documentContentType;

    private String documentFileName;

    private  List<PolicyDoc> policyDocList = new ArrayList<>();

    private  List<Policy> policyList = new ArrayList<>();

    public String listUI(){


        if (policy!=null){

            if (policy.getId()!=null) {

                ActionContext.getContext().getSession().put("policyId", policy.getId());

                List<PolicyDocument> list = policyService.getPolicyDocumentsByPolicyId(policy.getId());

                for (int i = 0 ; i < list.size() ; i++){

                    policyDocList.add(list.get(i).getPolicyDocumentId().getPolicyDoc());

                }

            }


        }

        return "listUI";
    }

    public String addUI(){

        return "addUI";
    }


    public String add(){

        if (document != null){

            System.out.println("in1");

            String filePath = ServletActionContext.getServletContext().getRealPath("upload/doc");

            String filename = UUID.randomUUID().toString().replaceAll("-","")+documentFileName.substring(documentFileName.lastIndexOf("."));

            try {

                FileUtils.copyFile(document,new File(filePath,filename));

                if (policyDoc!=null){



                    String policyId = (String)ActionContext.getContext().getSession().get("policyId");

                    policyDoc.setCount(0);
                    policyDoc.setTime(DateTimeHelper.getCurrentDateTime());
                    policyDoc.setLink("upload/doc/"+filename);

                    policyDocService.save(policyDoc);
                    policyService.savePolicyDocument(policyId,policyDoc.getId());

                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        return "list_back";
    }

    public String listBack(){

        List<PolicyDocument> list = policyService.getPolicyDocumentsByPolicyId((String)ActionContext.getContext().getSession().get("policyId"));

        for (int i = 0 ; i< list.size() ; i++){
            policyDocList.add(list.get(i).getPolicyDocumentId().getPolicyDoc());
        }

        return "listUI";
    }

    public String delete(){

        if (policyDoc!=null){

            policyService.deletePolicyDocumentByDocId(policyDoc.getId());

            policyDocService.delete(policyDoc.getId());

        }
        return "list_back";
    }

    public String policy_list(){

        policyList = policyService.findObjects();

        return "policyListUI";
    }

    public PolicyService getPolicyService() {
        return policyService;
    }

    public void setPolicyService(PolicyService policyService) {
        this.policyService = policyService;
    }

    public PolicyDocService getPolicyDocService() {
        return policyDocService;
    }

    public void setPolicyDocService(PolicyDocService policyDocService) {
        this.policyDocService = policyDocService;
    }

    public PolicyDocument getPolicyDocument() {
        return policyDocument;
    }

    public void setPolicyDocument(PolicyDocument policyDocument) {
        this.policyDocument = policyDocument;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public PolicyDoc getPolicyDoc() {
        return policyDoc;
    }

    public void setPolicyDoc(PolicyDoc policyDoc) {
        this.policyDoc = policyDoc;
    }

    public File getDocument() {
        return document;
    }

    public void setDocument(File document) {
        this.document = document;
    }

    public String getDocumentContentType() {
        return documentContentType;
    }

    public void setDocumentContentType(String documentContentType) {
        this.documentContentType = documentContentType;
    }

    public String getDocumentFileName() {
        return documentFileName;
    }

    public void setDocumentFileName(String documentFileName) {
        this.documentFileName = documentFileName;
    }

    public List<PolicyDoc> getPolicyDocList() {
        return policyDocList;
    }

    public void setPolicyDocList(List<PolicyDoc> policyDocList) {
        this.policyDocList = policyDocList;
    }

    public List<Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<Policy> policyList) {
        this.policyList = policyList;
    }
}
