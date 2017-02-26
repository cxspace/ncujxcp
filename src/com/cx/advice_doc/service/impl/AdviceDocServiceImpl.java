package com.cx.advice_doc.service.impl;

import com.cx.advice_doc.dao.AdviceDocDao;
import com.cx.advice_doc.entity.AdviceDoc;
import com.cx.advice_doc.service.AdviceDocService;
import com.cx.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liujie on 2017/2/26.
 */


@Service("adviceDocService")
public class AdviceDocServiceImpl extends BaseServiceImpl<AdviceDoc> implements AdviceDocService {

    private AdviceDocDao adviceDocDao;

    @Resource
    public void setAdviceDocDao(AdviceDocDao adviceDocDao) {

        super.setBaseDao(adviceDocDao);
        this.adviceDocDao = adviceDocDao;

    }
}
