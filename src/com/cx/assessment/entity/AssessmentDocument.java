package com.cx.assessment.entity;

import java.io.Serializable;

/**
 * Created by liujie on 2017/2/26.
 */
public class AssessmentDocument implements Serializable{

    private AssessmentDocumentId assessmentDocumentId;

    public AssessmentDocumentId getAssessmentDocumentId() {
        return assessmentDocumentId;
    }

    public void setAssessmentDocumentId(AssessmentDocumentId assessmentDocumentId) {
        this.assessmentDocumentId = assessmentDocumentId;
    }

    public AssessmentDocument(AssessmentDocumentId assessmentDocumentId) {
        this.assessmentDocumentId = assessmentDocumentId;
    }

    public AssessmentDocument() {
    }
}
