package com.cx.document.dao;

import com.cx.core.dao.BaseDao;
import com.cx.document.entity.Document;

import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public interface DocumentDao extends BaseDao<Document> {

    public List<Document> findIndexDocument();


}
