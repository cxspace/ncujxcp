package com.cx.advice_doc.action;

import com.cx.advice.entity.Advice;
import com.cx.advice.entity.AdviceDocument;
import com.cx.advice.service.AdviceService;
import com.cx.advice_doc.entity.AdviceDoc;
import com.cx.advice_doc.service.AdviceDocService;
import com.cx.core.action.BaseAction;
import com.cx.core.utils.DateTimeHelper;
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
public class AdviceDocAction extends BaseAction {

    @Resource
    private AdviceService adviceService;

    @Resource
    private AdviceDocService adviceDocService;

    private AdviceDocument adviceDocument;

    private Advice advice;

    private AdviceDoc adviceDoc;

    private File document;

    private String documentContentType;

    private String documentFileName;

    List<AdviceDoc> adviceDocList = new ArrayList<>();

    List<Advice> adviceList = new ArrayList<>();

    public String listUI(){


        if (advice!=null){

            if (advice.getId()!=null) {

                ActionContext.getContext().getSession().put("adviceId", advice.getId());

                List<AdviceDocument> list = adviceService.getAdviceDocumentsByAdviceId(advice.getId());

                for (int i=0 ; i < list.size() ; i++){

                    adviceDocList.add(list.get(i).getAdviceDocumentId().getAdviceDoc());

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

                if (adviceDoc!=null){


                    String adviceId = (String)ActionContext.getContext().getSession().get("adviceId");

                    adviceDoc.setCount(0);
                    adviceDoc.setTime(DateTimeHelper.getCurrentDateTime());
                    adviceDoc.setLink("upload/doc/"+filename);

                    adviceDocService.save(adviceDoc);
                    adviceService.saveAdviceDocument(adviceId,adviceDoc.getId());

                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        return "list_back";
    }

    public String listBack(){

        List<AdviceDocument> list = adviceService.getAdviceDocumentsByAdviceId((String)ActionContext.getContext().getSession().get("adviceId"));

        for (int i = 0 ; i< list.size() ; i++){
            adviceDocList.add(list.get(i).getAdviceDocumentId().getAdviceDoc());
        }

        return "listUI";
    }

    public String delete(){

        if (adviceDoc!=null){

            adviceService.deleteAdviceDocumentByDocId(adviceDoc.getId());

            adviceDocService.delete(adviceDoc.getId());

        }
        return "list_back";
    }

    public String advice_list(){

        adviceList = adviceService.findObjects();

        return "adviceListUI";
    }

    public AdviceService getAdviceService() {
        return adviceService;
    }

    public void setAdviceService(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    public AdviceDocService getAdviceDocService() {
        return adviceDocService;
    }

    public void setAdviceDocService(AdviceDocService adviceDocService) {
        this.adviceDocService = adviceDocService;
    }

    public AdviceDocument getAdviceDocument() {
        return adviceDocument;
    }

    public void setAdviceDocument(AdviceDocument adviceDocument) {
        this.adviceDocument = adviceDocument;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public AdviceDoc getAdviceDoc() {
        return adviceDoc;
    }

    public void setAdviceDoc(AdviceDoc adviceDoc) {
        this.adviceDoc = adviceDoc;
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

    public List<AdviceDoc> getAdviceDocList() {
        return adviceDocList;
    }

    public void setAdviceDocList(List<AdviceDoc> adviceDocList) {
        this.adviceDocList = adviceDocList;
    }

    public List<Advice> getAdviceList() {
        return adviceList;
    }

    public void setAdviceList(List<Advice> adviceList) {
        this.adviceList = adviceList;
    }
}
