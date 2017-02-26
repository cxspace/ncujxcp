package com.cx.assessment.action;

import com.cx.assessment.entity.Assessment;
import com.cx.assessment.entity.AssessmentDocument;
import com.cx.assessment.service.AssessmentService;
import com.cx.assessment_doc.entity.AssessmentDoc;
import com.cx.core.action.BaseAction;
import com.cx.core.page.PageResult;
import com.cx.core.utils.QueryHelper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class AssessmentFrontAction extends BaseAction {

    @Resource
    private AssessmentService assessmentService;

    private PageResult pageResult;

    private Assessment assessment;

    private List<AssessmentDoc> assessmentDocList = new ArrayList<>();

    private List<Assessment> assessmentList = new ArrayList<>();

    private List<AssessmentDocument> assessmentDocumentList = new ArrayList<>();

    public String assessmentList(){

        QueryHelper queryHelper = new QueryHelper(Assessment.class,"i");

        queryHelper.addOrderByProperty("i.time",QueryHelper.ORDER_BY_DESC);

        pageResult = assessmentService.getPageResult(queryHelper,getPageNo(),getPageSize());

        return "assessmentList";
    }


    public String assessment_detail(){


        if(assessment != null){

            if (assessment.getId()!=null){

                assessment = assessmentService.findObjectById(assessment.getId());

                long count = assessment.getCount();

                count ++;

                assessment.setCount(count);

                assessmentService.update(assessment);

                //                doc
                assessmentDocumentList = assessmentService.getAssessmentDocumentsByAssessmentId(assessment.getId());

                //查出所有附件

                for (int i = 0 ; i < assessmentDocumentList.size() ; i++){
                    assessmentDocList.add(assessmentDocumentList.get(i).getAssessmentDocumentId().getAssessmentDoc());
                }

            }

        }

        return "assessment_detail";
    }

    public List<AssessmentDoc> getAssessmentDocList() {
        return assessmentDocList;
    }

    public void setAssessmentDocList(List<AssessmentDoc> assessmentDocList) {
        this.assessmentDocList = assessmentDocList;
    }

    public List<AssessmentDocument> getAssessmentDocumentList() {
        return assessmentDocumentList;
    }

    public void setAssessmentDocumentList(List<AssessmentDocument> assessmentDocumentList) {
        this.assessmentDocumentList = assessmentDocumentList;
    }

    public AssessmentService getAssessmentService() {
        return assessmentService;
    }

    public void setAssessmentService(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    public PageResult getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageResult pageResult) {
        this.pageResult = pageResult;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public List<Assessment> getAssessmentList() {
        return assessmentList;
    }

    public void setAssessmentList(List<Assessment> assessmentList) {
        this.assessmentList = assessmentList;
    }
}
