package com.cx.assessment_doc.service.impl;

import com.cx.assessment_doc.dao.AssessmentDocDao;
import com.cx.assessment_doc.entity.AssessmentDoc;
import com.cx.assessment_doc.service.AssessmentDocService;
import com.cx.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liujie on 2017/2/26.
 */

@Service("assessmentDocService")

public class AssessmentDocServiceImpl extends BaseServiceImpl<AssessmentDoc> implements AssessmentDocService {

    private AssessmentDocDao assessmentDocDao;

    @Resource
    public void setAssessmentDocDao(AssessmentDocDao assessmentDocDao) {

        super.setBaseDao(assessmentDocDao);
        this.assessmentDocDao = assessmentDocDao;

    }
}
