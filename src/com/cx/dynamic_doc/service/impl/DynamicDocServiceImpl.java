package com.cx.dynamic_doc.service.impl;

import com.cx.core.service.impl.BaseServiceImpl;
import com.cx.dynamic_doc.dao.DynamicDocDao;
import com.cx.dynamic_doc.entity.DynamicDoc;
import com.cx.dynamic_doc.service.DynamicDocService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liujie on 2017/2/26.
 */

@Service("dynamicDocService")
public class DynamicDocServiceImpl extends BaseServiceImpl<DynamicDoc> implements DynamicDocService{


    private DynamicDocDao dynamicDocDao;

    @Resource
    public void setDynamicDocDao(DynamicDocDao dynamicDocDao) {

        super.setBaseDao(dynamicDocDao);
        this.dynamicDocDao = dynamicDocDao;
    }
}
