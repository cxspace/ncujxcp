package com.cx.assessment.action;

import com.cx.assessment.entity.Assessment;
import com.cx.assessment.service.AssessmentService;
import com.cx.core.utils.DateTimeHelper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class AssessmentSysAction {


    @Resource
    private AssessmentService assessmentService;

    private Assessment assessment;

    private List<Assessment> assessmentList = new ArrayList<>();

    public String listUI(){

        assessmentList = assessmentService.findObjects();

        return "listUI";
    }

    public String editUI(){

        if (assessment!=null){

            if (assessment.getId()!=null){

                assessment = assessmentService.findObjectById(assessment.getId());

            }

        }

        return "editUI";
    }

    public String edit(){

        if (assessment!=null){

            assessmentService.update(assessment);

        }

        return "list";
    }

    public String addUI(){

        return "addUI";
    }

    public String add(){

        if (assessment != null){
            assessment.setTime(DateTimeHelper.getCurrentDateTime());
            assessment.setCount(0);
            assessmentService.save(assessment);
        }

        return "list";
    }

    public String delete(){

        if (assessment != null){

            if (assessment.getId()!=null){

                assessmentService.delete(assessment.getId());

            }

        }

        return "list";
    }

    public AssessmentService getAssessmentService() {
        return assessmentService;
    }

    public void setAssessmentService(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
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
