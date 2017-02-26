package com.cx.inform_doc.action;

import com.cx.core.action.BaseAction;
import com.cx.core.utils.DateTimeHelper;
import com.cx.inform.entity.Info;
import com.cx.inform.entity.InfoDocument;
import com.cx.inform.service.InfoService;
import com.cx.inform_doc.entity.InfoDoc;
import com.cx.inform_doc.service.InfoDocService;
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
 * Created by liujie on 2017/2/25.
 */
public class InformDocSysAction extends BaseAction{

    @Resource
    private InfoService infoService;

    @Resource
    private InfoDocService infoDocService;

    private InfoDocument infoDocument;

    private Info info;

    private InfoDoc infoDoc;

    private File document;

    private String documentContentType;

    private String documentFileName;

    List<InfoDoc> infoDocList = new ArrayList<>();

    List<Info> infoList = new ArrayList<>();

    public String listUI(){


        if (info!=null){

            if (info.getId()!=null) {

                 ActionContext.getContext().getSession().put("infoId", info.getId());

                 List<InfoDocument> list = infoService.getInfoDocumentsByInfoId(info.getId());

                 for (int i=0 ; i < list.size() ; i++){

                     infoDocList.add(list.get(i).getInfoDocumentId().getInfoDoc());

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

                if (infoDoc!=null){


                    String infoId = (String)ActionContext.getContext().getSession().get("infoId");

                    infoDoc.setCount(0);
                    infoDoc.setTime(DateTimeHelper.getCurrentDateTime());
                    infoDoc.setLink("upload/doc/"+filename);

                    infoDocService.save(infoDoc);
                    infoService.saveInfoDocument(infoId,infoDoc.getId());

                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        return "list_back";
    }

    public String listBack(){

        List<InfoDocument> list = infoService.getInfoDocumentsByInfoId((String)ActionContext.getContext().getSession().get("infoId"));

        for (int i = 0 ; i< list.size() ; i++){
            infoDocList.add(list.get(i).getInfoDocumentId().getInfoDoc());
        }

        return "listUI";
    }

    public String delete(){

        if (infoDoc!=null){

            System.out.println("=============================================================================");

            System.out.println(infoDoc.getId());

            infoService.deleteInfoDocumentByDocId(infoDoc.getId());

            infoDocService.delete(infoDoc.getId());


        }
        return "list_back";
    }

    public String info_list(){

        infoList = infoService.findObjects();

        return "infoListUI";
    }



    public InfoService getInfoService() {
        return infoService;
    }

    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    public InfoDocService getInfoDocService() {
        return infoDocService;
    }

    public void setInfoDocService(InfoDocService infoDocService) {
        this.infoDocService = infoDocService;
    }

    public InfoDocument getInfoDocument() {
        return infoDocument;
    }

    public void setInfoDocument(InfoDocument infoDocument) {
        this.infoDocument = infoDocument;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Info> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<Info> infoList) {
        this.infoList = infoList;
    }

    public InfoDoc getInfoDoc() {
        return infoDoc;
    }

    public void setInfoDoc(InfoDoc infoDoc) {
        this.infoDoc = infoDoc;
    }

    public List<InfoDoc> getInfoDocList() {
        return infoDocList;
    }

    public void setInfoDocList(List<InfoDoc> infoDocList) {
        this.infoDocList = infoDocList;
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
}
