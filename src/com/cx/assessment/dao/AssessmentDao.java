package com.cx.assessment.dao;

import com.cx.assessment.entity.Assessment;
import com.cx.assessment.entity.AssessmentDocument;
import com.cx.core.dao.BaseDao;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public interface AssessmentDao extends BaseDao<Assessment>{

    public void saveAssessmentDocument(AssessmentDocument assessmentDocument);

    public List<AssessmentDocument> getAssessmentDocumentsByAssessmentId(String assessmentId);

    public void deleteAssessmentDocumentByDocId(String doc_id);

}
