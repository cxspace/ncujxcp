package com.cx.document.service;

import com.cx.core.service.BaseService;
import com.cx.document.entity.Document;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public interface DocumentService extends BaseService<Document> {

    public List<Document> findIndexDocument();


}
