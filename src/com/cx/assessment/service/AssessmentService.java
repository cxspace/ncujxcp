package com.cx.assessment.service;

import com.cx.assessment.entity.Assessment;
import com.cx.assessment.entity.AssessmentDocument;
import com.cx.core.service.BaseService;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public interface AssessmentService extends BaseService<Assessment> {

    public void saveAssessmentDocument(String assessmentId , String assessmentDocId);

    public List<AssessmentDocument> getAssessmentDocumentsByAssessmentId(String assessment_id);

    public void deleteAssessmentDocumentByDocId(String doc_id);

}
