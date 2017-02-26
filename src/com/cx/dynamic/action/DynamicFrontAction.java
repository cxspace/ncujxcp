package com.cx.dynamic.action;

import com.cx.core.action.BaseAction;
import com.cx.core.page.PageResult;
import com.cx.core.utils.QueryHelper;
import com.cx.dynamic.entity.Dynamic;
import com.cx.dynamic.entity.DynamicDocument;
import com.cx.dynamic.service.DynamicService;
import com.cx.dynamic_doc.entity.DynamicDoc;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class DynamicFrontAction extends BaseAction {

    @Resource
    private DynamicService dynamicService;

    private PageResult pageResult;

    private Dynamic dynamic;

    private List<Dynamic> dynamicList = new ArrayList<>();

    private List<DynamicDoc> dynamicDocList = new ArrayList<>();

    private List<DynamicDocument> dynamicDocumentList = new ArrayList<>();


    public String dynamicList(){

        QueryHelper queryHelper = new QueryHelper(Dynamic.class,"i");

        queryHelper.addOrderByProperty("i.time",QueryHelper.ORDER_BY_DESC);

        pageResult = dynamicService.getPageResult(queryHelper,getPageNo(),getPageSize());

        return "dynamicList";
    }


    public String dynamic_detail(){


        if(dynamic != null){

            if (dynamic.getId()!=null){

                dynamic = dynamicService.findObjectById(dynamic.getId());

                long count = dynamic.getCount();

                count ++;

                dynamic.setCount(count);

                dynamicService.update(dynamic);

                //                doc
                dynamicDocumentList = dynamicService.getDynamicDocumentsByDynamicId(dynamic.getId());

                //查出所有附件

                for (int i = 0 ; i < dynamicDocumentList.size() ; i++){
                    dynamicDocList.add(dynamicDocumentList.get(i).getDynamicDocumentId().getDynamicDoc());
                }

            }

        }

        return "dynamic_detail";
    }

    public List<DynamicDoc> getDynamicDocList() {
        return dynamicDocList;
    }

    public void setDynamicDocList(List<DynamicDoc> dynamicDocList) {
        this.dynamicDocList = dynamicDocList;
    }

    public List<DynamicDocument> getDynamicDocumentList() {
        return dynamicDocumentList;
    }

    public void setDynamicDocumentList(List<DynamicDocument> dynamicDocumentList) {
        this.dynamicDocumentList = dynamicDocumentList;
    }

    public DynamicService getDynamicService() {
        return dynamicService;
    }

    public void setDynamicService(DynamicService dynamicService) {
        this.dynamicService = dynamicService;
    }

    public PageResult getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageResult pageResult) {
        this.pageResult = pageResult;
    }

    public Dynamic getDynamic() {
        return dynamic;
    }

    public void setDynamic(Dynamic dynamic) {
        this.dynamic = dynamic;
    }

    public List<Dynamic> getDynamicList() {
        return dynamicList;
    }

    public void setDynamicList(List<Dynamic> dynamicList) {
        this.dynamicList = dynamicList;
    }
}
