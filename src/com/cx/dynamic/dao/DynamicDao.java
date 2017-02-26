package com.cx.dynamic.dao;

import com.cx.core.dao.BaseDao;
import com.cx.dynamic.entity.Dynamic;
import com.cx.dynamic.entity.DynamicDocument;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public interface DynamicDao extends BaseDao<Dynamic> {

    //保存通知公告附件关系
    public void saveDynamicDocument(DynamicDocument dynamicDocument);

    public List<DynamicDocument> getDynamicDocumentsByDynamicId(String dynamicId);

    public void deleteDynamicDocumentByDocId(String doc_id);

}
