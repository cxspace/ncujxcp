package com.cx.assessment.entity;

import com.cx.assessment_doc.entity.AssessmentDoc;

import java.io.Serializable;

/**
 * Created by liujie on 2017/2/26.
 */
public class AssessmentDocumentId implements Serializable {

    private String assessment_id;

    private AssessmentDoc assessmentDoc;

    public String getAssessment_id() {
        return assessment_id;
    }

    public void setAssessment_id(String assessment_id) {
        this.assessment_id = assessment_id;
    }

    public AssessmentDoc getAssessmentDoc() {
        return assessmentDoc;
    }

    public void setAssessmentDoc(AssessmentDoc assessmentDoc) {
        this.assessmentDoc = assessmentDoc;
    }

    public AssessmentDocumentId(String assessment_id, AssessmentDoc assessmentDoc) {
        this.assessment_id = assessment_id;
        this.assessmentDoc = assessmentDoc;
    }

    public AssessmentDocumentId() {
    }
}
