package com.cx.document.service.impl;

import com.cx.core.service.impl.BaseServiceImpl;
import com.cx.document.dao.DocumentDao;
import com.cx.document.entity.Document;
import com.cx.document.service.DocumentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */

@Service("documentService")
public class DocumentServiceImpl extends BaseServiceImpl<Document> implements DocumentService {

    private DocumentDao documentDao;

    @Resource

    public void setDocumentDao(DocumentDao documentDao) {

        super.setBaseDao(documentDao);
        this.documentDao = documentDao;
    }

    @Override
    public List<Document> findIndexDocument() {
        return documentDao.findIndexDocument();
    }
}
