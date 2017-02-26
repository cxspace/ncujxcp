package com.cx.advice.dao;

import com.cx.advice.entity.Advice;
import com.cx.advice.entity.AdviceDocument;
import com.cx.core.dao.BaseDao;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public interface AdviceDao extends BaseDao<Advice> {

    public void saveAdviceDocument(AdviceDocument adviceDocument);

    public List<AdviceDocument> getAdviceDocumentsByAdviceId(String adviceId);

    public void deleteAdviceDocumentByDocId(String doc_id);

    public List<Advice> findIndexAdvice();

}
