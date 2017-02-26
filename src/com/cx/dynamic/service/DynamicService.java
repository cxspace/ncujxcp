package com.cx.dynamic.service;

import com.cx.core.service.BaseService;
import com.cx.dynamic.entity.Dynamic;
import com.cx.dynamic.entity.DynamicDocument;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public interface DynamicService extends BaseService<Dynamic> {

    public void saveDynamicDocument(String dynamicId , String dynamicDocId);

    public List<DynamicDocument> getDynamicDocumentsByDynamicId(String dynamic_id);

    public void deleteDynamicDocumentByDocId(String doc_id);

    public List<Dynamic> findIndexDynamic();

}
