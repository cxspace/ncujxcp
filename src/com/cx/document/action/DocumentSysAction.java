package com.cx.document.action;

import com.cx.core.utils.DateTimeHelper;
import com.cx.document.entity.Document;
import com.cx.document.service.DocumentService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by liujie on 2017/2/26.
 */
public class DocumentSysAction {

    @Resource
    private DocumentService documentService;

    private Document document;

    private File doc;

    private String docContentType;

    private String docFileName;


    private List<Document> documentList = new ArrayList<>();

    public String listUI(){


        documentList = documentService.findObjects();

        return "listUI";
    }

    public String addUI(){

        return "addUI";
    }

    public String add(){

        if (document != null){

            String filePath = ServletActionContext.getServletContext().getRealPath("upload/doc");

            String filename = UUID.randomUUID().toString().replaceAll("-","")+docFileName.substring(docFileName.lastIndexOf("."));

            try {

                FileUtils.copyFile(doc,new File(filePath,filename));

                if (document!=null){


                    document.setCount(0);
                    document.setTime(DateTimeHelper.getCurrentDateTime());
                    document.setLink("upload/doc/"+filename);
                    documentService.save(document);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        return "list";
    }

    public String delete(){

        if (document != null){

            if (document.getId()!=null){

                documentService.delete(document.getId());

            }

        }

        return "list";
    }


    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
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

    public File getDoc() {
        return doc;
    }

    public void setDoc(File doc) {
        this.doc = doc;
    }

    public String getDocContentType() {
        return docContentType;
    }

    public void setDocContentType(String docContentType) {
        this.docContentType = docContentType;
    }

    public String getDocFileName() {
        return docFileName;
    }

    public void setDocFileName(String docFileName) {
        this.docFileName = docFileName;
    }
}
