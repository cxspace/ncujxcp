package com.cx.dynamic_doc.action;

import com.cx.core.action.BaseAction;
import com.cx.core.utils.DateTimeHelper;
import com.cx.dynamic.entity.Dynamic;
import com.cx.dynamic.entity.DynamicDocument;
import com.cx.dynamic.service.DynamicService;
import com.cx.dynamic_doc.entity.DynamicDoc;
import com.cx.dynamic_doc.service.DynamicDocService;
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
public class DynamicDocSysAction extends BaseAction{

    @Resource
    private DynamicService dynamicService;

    @Resource
    private DynamicDocService dynamicDocService;

    private DynamicDocument dynamicDocument;

    private Dynamic dynamic;

    private DynamicDoc dynamicDoc;

    private File document;

    private String documentContentType;

    private String documentFileName;

    List<DynamicDoc> dynamicDocList = new ArrayList<>();

    List<Dynamic> dynamicList = new ArrayList<>();

    public String listUI(){


        if (dynamic!=null){

            if (dynamic.getId()!=null) {

                ActionContext.getContext().getSession().put("dynamicId", dynamic.getId());

                List<DynamicDocument> list = dynamicService.getDynamicDocumentsByDynamicId(dynamic.getId());

                for (int i=0 ; i < list.size() ; i++){

                    dynamicDocList.add(list.get(i).getDynamicDocumentId().getDynamicDoc());

                }

            }


        }

        return "listUI";
    }

    public String addUI(){

        return "addUI";
    }


    public String add(){

        if (document != null){

            String filePath = ServletActionContext.getServletContext().getRealPath("upload/doc");

            String filename = UUID.randomUUID().toString().replaceAll("-","")+documentFileName.substring(documentFileName.lastIndexOf("."));

            try {

                FileUtils.copyFile(document,new File(filePath,filename));

                if (dynamicDoc!=null){


                    String dynamicId = (String)ActionContext.getContext().getSession().get("dynamicId");

                    dynamicDoc.setCount(0);
                    dynamicDoc.setTime(DateTimeHelper.getCurrentDateTime());
                    dynamicDoc.setLink("upload/doc/"+filename);

                    dynamicDocService.save(dynamicDoc);
                    dynamicService.saveDynamicDocument(dynamicId,dynamicDoc.getId());

                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        return "list_back";
    }

    public String listBack(){

        List<DynamicDocument> list = dynamicService.getDynamicDocumentsByDynamicId((String)ActionContext.getContext().getSession().get("dynamicId"));

        for (int i = 0 ; i< list.size() ; i++){
            dynamicDocList.add(list.get(i).getDynamicDocumentId().getDynamicDoc());
        }

        return "listUI";
    }

    public String delete(){

        if (dynamicDoc!=null){

            dynamicService.deleteDynamicDocumentByDocId(dynamicDoc.getId());

            dynamicDocService.delete(dynamicDoc.getId());

        }
        return "list_back";
    }

    public String dynamic_list(){

        dynamicList = dynamicService.findObjects();

        return "dynamicListUI";
    }


    public DynamicService getDynamicService() {
        return dynamicService;
    }

    public void setDynamicService(DynamicService dynamicService) {
        this.dynamicService = dynamicService;
    }

    public DynamicDocService getDynamicDocService() {
        return dynamicDocService;
    }

    public void setDynamicDocService(DynamicDocService dynamicDocService) {
        this.dynamicDocService = dynamicDocService;
    }

    public DynamicDocument getDynamicDocument() {
        return dynamicDocument;
    }

    public void setDynamicDocument(DynamicDocument dynamicDocument) {
        this.dynamicDocument = dynamicDocument;
    }

    public Dynamic getDynamic() {
        return dynamic;
    }

    public void setDynamic(Dynamic dynamic) {
        this.dynamic = dynamic;
    }

    public DynamicDoc getDynamicDoc() {
        return dynamicDoc;
    }

    public void setDynamicDoc(DynamicDoc dynamicDoc) {
        this.dynamicDoc = dynamicDoc;
    }

    public File getDocument() {
        return document;
    }

    public void setDocument(File document) {
        this.document = document;
    }

    public String getDocumentContentType() {
        return documentContentType;
    }

    public void setDocumentContentType(String documentContentType) {
        this.documentContentType = documentContentType;
    }

    public String getDocumentFileName() {
        return documentFileName;
    }

    public void setDocumentFileName(String documentFileName) {
        this.documentFileName = documentFileName;
    }

    public List<DynamicDoc> getDynamicDocList() {
        return dynamicDocList;
    }

    public void setDynamicDocList(List<DynamicDoc> dynamicDocList) {
        this.dynamicDocList = dynamicDocList;
    }

    public List<Dynamic> getDynamicList() {
        return dynamicList;
    }

    public void setDynamicList(List<Dynamic> dynamicList) {
        this.dynamicList = dynamicList;
    }
}
