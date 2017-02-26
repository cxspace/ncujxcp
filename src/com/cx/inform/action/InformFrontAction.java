package com.cx.inform.action;

import com.cx.core.action.BaseAction;
import com.cx.core.page.PageResult;
import com.cx.core.utils.QueryHelper;
import com.cx.inform.entity.Info;
import com.cx.inform.entity.InfoDocument;
import com.cx.inform.service.InfoService;
import com.cx.inform_doc.entity.InfoDoc;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class InformFrontAction extends BaseAction {

    @Resource
    private InfoService infoService;

    private PageResult pageResult;

    private Info info;

    private InfoDoc infoDoc;

    private List<InfoDoc> infoDocList = new ArrayList<>();

    private List<InfoDocument> infoDocumentList = new ArrayList<>();

    private List<Info> infoList = new ArrayList<>();


    public String infoList(){

        QueryHelper queryHelper = new QueryHelper(Info.class,"i");

        queryHelper.addOrderByProperty("i.time",QueryHelper.ORDER_BY_DESC);

        pageResult = infoService.getPageResult(queryHelper,getPageNo(),getPageSize());

        return "infoList";
    }


    public String info_detail(){


        if(info != null){

            if (info.getId()!=null){

                info = infoService.findObjectById(info.getId());

                long count = info.getCount();

                count ++;

                info.setCount(count);

                infoService.update(info);

                infoDocumentList = infoService.getInfoDocumentsByInfoId(info.getId());

                //查出所有附件

                for (int i = 0 ; i < infoDocumentList.size() ; i++){
                    infoDocList.add(infoDocumentList.get(i).getInfoDocumentId().getInfoDoc());
                }

            }

        }

        return "info_detail";
    }



    public InfoDoc getInfoDoc() {
        return infoDoc;
    }

    public void setInfoDoc(InfoDoc infoDoc) {
        this.infoDoc = infoDoc;
    }


    public List<InfoDocument> getInfoDocumentList() {
        return infoDocumentList;
    }

    public void setInfoDocumentList(List<InfoDocument> infoDocumentList) {
        this.infoDocumentList = infoDocumentList;
    }

    public List<InfoDoc> getInfoDocList() {
        return infoDocList;
    }

    public void setInfoDocList(List<InfoDoc> infoDocList) {
        this.infoDocList = infoDocList;
    }

    public InfoService getInfoService() {
        return infoService;
    }

    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    public PageResult getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageResult pageResult) {
        this.pageResult = pageResult;
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
}
