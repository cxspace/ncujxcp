package com.cx.dynamic.service.impl;

import com.cx.core.service.impl.BaseServiceImpl;
import com.cx.dynamic.dao.DynamicDao;
import com.cx.dynamic.entity.Dynamic;
import com.cx.dynamic.service.DynamicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liujie on 2017/2/26.
 */


@Service("dynamicService")
public class DynamicServiceImpl extends BaseServiceImpl<Dynamic> implements DynamicService {

    private DynamicDao dynamicDao;

    @Resource
    public void setDynamicDao(DynamicDao dynamicDao) {

        super.setBaseDao(dynamicDao);
        this.dynamicDao = dynamicDao;

    }
}
