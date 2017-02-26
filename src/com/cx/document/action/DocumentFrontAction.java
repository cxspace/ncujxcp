package com.cx.document.action;

import com.cx.core.action.BaseAction;
import com.cx.core.page.PageResult;
import com.cx.core.utils.QueryHelper;
import com.cx.document.entity.Document;
import com.cx.document.service.DocumentService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class DocumentFrontAction extends BaseAction {

    @Resource
    private DocumentService documentService;

    private PageResult pageResult;

    private Document document;

    private List<Document> documentList = new ArrayList<>();


    public String documentList(){

        QueryHelper queryHelper = new QueryHelper(Document.class,"i");

        queryHelper.addOrderByProperty("i.time",QueryHelper.ORDER_BY_DESC);

        pageResult = documentService.getPageResult(queryHelper,getPageNo(),getPageSize());

        return "documentList";
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public PageResult getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageResult pageResult) {
        this.pageResult = pageResult;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }
}
