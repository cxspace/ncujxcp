package com.cx.dynamic.service.impl;

import com.cx.core.service.impl.BaseServiceImpl;
import com.cx.dynamic.dao.DynamicDao;
import com.cx.dynamic.entity.Dynamic;
import com.cx.dynamic.entity.DynamicDocument;
import com.cx.dynamic.entity.DynamicDocumentId;
import com.cx.dynamic.service.DynamicService;
import com.cx.dynamic_doc.entity.DynamicDoc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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


    @Override
    public void saveDynamicDocument(String dynamicId, String dynamicDocId) {
        dynamicDao.saveDynamicDocument(new DynamicDocument(new DynamicDocumentId(dynamicId,new DynamicDoc(dynamicDocId))));
    }

    @Override
    public List<DynamicDocument> getDynamicDocumentsByDynamicId(String dynamic_id) {
        return dynamicDao.getDynamicDocumentsByDynamicId(dynamic_id);
    }

    @Override
    public void deleteDynamicDocumentByDocId(String doc_id) {
        dynamicDao.deleteDynamicDocumentByDocId(doc_id);
    }
}
