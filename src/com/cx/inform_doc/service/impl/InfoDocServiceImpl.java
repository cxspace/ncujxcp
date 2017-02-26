package com.cx.inform_doc.service.impl;

import com.cx.core.service.impl.BaseServiceImpl;
import com.cx.inform_doc.dao.InfoDocDao;
import com.cx.inform_doc.entity.InfoDoc;
import com.cx.inform_doc.service.InfoDocService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liujie on 2017/2/25.
 */

@Service("infoDocService")
public class InfoDocServiceImpl extends BaseServiceImpl<InfoDoc> implements InfoDocService{

    private InfoDocDao infoDocDao;

    @Resource
    public void setInfoDocDao(InfoDocDao infoDocDao) {

        super.setBaseDao(infoDocDao);
        this.infoDocDao = infoDocDao;
    }
}
