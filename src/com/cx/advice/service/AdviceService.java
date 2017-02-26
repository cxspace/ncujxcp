package com.cx.advice.service;

import com.cx.advice.entity.Advice;
import com.cx.advice.entity.AdviceDocument;
import com.cx.core.service.BaseService;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public interface AdviceService extends BaseService<Advice> {

    public void saveAdviceDocument(String adviceId , String adviceDocId);

    public List<AdviceDocument> getAdviceDocumentsByAdviceId(String adviceId);

    public void deleteAdviceDocumentByDocId(String doc_id);

    public List<Advice> findIndexAdvice();

}
