package com.cx.advice.service.impl;

import com.cx.advice.dao.AdviceDao;
import com.cx.advice.entity.Advice;
import com.cx.advice.entity.AdviceDocument;
import com.cx.advice.entity.AdviceDocumentId;
import com.cx.advice.service.AdviceService;
import com.cx.advice_doc.entity.AdviceDoc;
import com.cx.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */

@Service("adviceService")
public class AdviceServiceImpl extends BaseServiceImpl<Advice> implements AdviceService{

    private AdviceDao adviceDao;

    @Resource
    public void setAdviceDao(AdviceDao adviceDao) {

        super.setBaseDao(adviceDao);
        this.adviceDao = adviceDao;

    }

    @Override
    public void saveAdviceDocument(String adviceId, String adviceDocId) {
        adviceDao.saveAdviceDocument(new AdviceDocument(new AdviceDocumentId(adviceId,new AdviceDoc(adviceDocId))));
    }

    @Override
    public List<AdviceDocument> getAdviceDocumentsByAdviceId(String adviceId) {
        return adviceDao.getAdviceDocumentsByAdviceId(adviceId);
    }

    @Override
    public void deleteAdviceDocumentByDocId(String doc_id) {
        adviceDao.deleteAdviceDocumentByDocId(doc_id);
    }
}
