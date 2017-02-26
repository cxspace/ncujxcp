package com.cx.assessment.service.impl;

import com.cx.assessment.dao.AssessmentDao;
import com.cx.assessment.entity.Assessment;
import com.cx.assessment.entity.AssessmentDocument;
import com.cx.assessment.entity.AssessmentDocumentId;
import com.cx.assessment.service.AssessmentService;
import com.cx.assessment_doc.entity.AssessmentDoc;
import com.cx.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */

@Service("assessmentService")
public class AssessmentServiceImpl extends BaseServiceImpl<Assessment> implements AssessmentService{

    private AssessmentDao assessmentDao;

    @Resource

    public void setAssessmentDao(AssessmentDao assessmentDao) {
        super.setBaseDao(assessmentDao);
        this.assessmentDao = assessmentDao;
    }

    @Override
    public void saveAssessmentDocument(String assessmentId, String assessmentDocId) {
        assessmentDao.saveAssessmentDocument(new AssessmentDocument(new AssessmentDocumentId(assessmentId,new AssessmentDoc(assessmentDocId))));
    }

    @Override
    public List<AssessmentDocument> getAssessmentDocumentsByAssessmentId(String assessment_id) {
        return assessmentDao.getAssessmentDocumentsByAssessmentId(assessment_id);
    }

    @Override
    public void deleteAssessmentDocumentByDocId(String doc_id) {
        assessmentDao.deleteAssessmentDocumentByDocId(doc_id);
    }

}
