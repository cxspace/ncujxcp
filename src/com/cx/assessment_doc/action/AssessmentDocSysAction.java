package com.cx.assessment_doc.action;

import com.cx.assessment.entity.Assessment;
import com.cx.assessment.entity.AssessmentDocument;
import com.cx.assessment.service.AssessmentService;
import com.cx.assessment_doc.entity.AssessmentDoc;
import com.cx.assessment_doc.service.AssessmentDocService;
import com.cx.core.utils.DateTimeHelper;
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
 * Created by liujie on 2017/2/26.
 */
public class AssessmentDocSysAction {

    @Resource
    private AssessmentService assessmentService;

    @Resource
    private AssessmentDocService assessmentDocService;

    private AssessmentDocument assessmentDocument;

    private Assessment assessment;

    private AssessmentDoc assessmentDoc;

    private File document;

    private String documentContentType;

    private String documentFileName;

    List<AssessmentDoc> assessmentDocList = new ArrayList<>();

    List<Assessment> assessmentList = new ArrayList<>();

    public String listUI(){


        if (assessment!=null){

            if (assessment.getId()!=null) {

                ActionContext.getContext().getSession().put("assessmentId", assessment.getId());

                List<AssessmentDocument> list = assessmentService.getAssessmentDocumentsByAssessmentId(assessment.getId());

                for (int i=0 ; i < list.size() ; i++){

                    assessmentDocList.add(list.get(i).getAssessmentDocumentId().getAssessmentDoc());

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

            String filePath = ServletActionContext.getServletContext().getRealPath("upload/doc");

            String filename = UUID.randomUUID().toString().replaceAll("-","")+documentFileName.substring(documentFileName.lastIndexOf("."));

            try {

                FileUtils.copyFile(document,new File(filePath,filename));

                if (assessmentDoc!=null){


                    String assessmentId = (String)ActionContext.getContext().getSession().get("assessmentId");

                    assessmentDoc.setCount(0);
                    assessmentDoc.setTime(DateTimeHelper.getCurrentDateTime());
                    assessmentDoc.setLink("upload/doc/"+filename);

                    assessmentDocService.save(assessmentDoc);
                    assessmentService.saveAssessmentDocument(assessmentId,assessmentDoc.getId());

                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        return "list_back";
    }

    public String listBack(){

        List<AssessmentDocument> list = assessmentService.getAssessmentDocumentsByAssessmentId((String)ActionContext.getContext().getSession().get("assessmentId"));

        for (int i = 0 ; i< list.size() ; i++){
            assessmentDocList.add(list.get(i).getAssessmentDocumentId().getAssessmentDoc());
        }

        return "listUI";
    }

    public String delete(){

        if (assessmentDoc!=null){

            assessmentService.deleteAssessmentDocumentByDocId(assessmentDoc.getId());

            assessmentDocService.delete(assessmentDoc.getId());

        }
        return "list_back";
    }

    public String assessment_list(){

        assessmentList = assessmentService.findObjects();

        return "assessmentListUI";
    }

    public AssessmentService getAssessmentService() {
        return assessmentService;
    }

    public void setAssessmentService(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    public AssessmentDocService getAssessmentDocService() {
        return assessmentDocService;
    }

    public void setAssessmentDocService(AssessmentDocService assessmentDocService) {
        this.assessmentDocService = assessmentDocService;
    }

    public AssessmentDocument getAssessmentDocument() {
        return assessmentDocument;
    }

    public void setAssessmentDocument(AssessmentDocument assessmentDocument) {
        this.assessmentDocument = assessmentDocument;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public AssessmentDoc getAssessmentDoc() {
        return assessmentDoc;
    }

    public void setAssessmentDoc(AssessmentDoc assessmentDoc) {
        this.assessmentDoc = assessmentDoc;
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

    public List<AssessmentDoc> getAssessmentDocList() {
        return assessmentDocList;
    }

    public void setAssessmentDocList(List<AssessmentDoc> assessmentDocList) {
        this.assessmentDocList = assessmentDocList;
    }

    public List<Assessment> getAssessmentList() {
        return assessmentList;
    }

    public void setAssessmentList(List<Assessment> assessmentList) {
        this.assessmentList = assessmentList;
    }
}
