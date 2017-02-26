package com.cx.advice.action;

import com.cx.advice.entity.Advice;
import com.cx.advice.entity.AdviceDocument;
import com.cx.advice.service.AdviceService;
import com.cx.advice_doc.entity.AdviceDoc;
import com.cx.core.action.BaseAction;
import com.cx.core.page.PageResult;
import com.cx.core.utils.QueryHelper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class AdviceFrontAction extends BaseAction {

    @Resource
    private AdviceService adviceService;

    private PageResult pageResult;

    private Advice advice;

    private AdviceDoc adviceDoc;

    private List<AdviceDoc> adviceDocList = new ArrayList<>();

    private List<AdviceDocument> adviceDocumentList = new ArrayList<>();

    private List<Advice> adviceList = new ArrayList<>();


    public String adviceList(){

        QueryHelper queryHelper = new QueryHelper(Advice.class,"i");

        queryHelper.addOrderByProperty("i.time",QueryHelper.ORDER_BY_DESC);

        pageResult = adviceService.getPageResult(queryHelper,getPageNo(),getPageSize());

        return "adviceList";
    }


    public String advice_detail(){


        if(advice != null){

            if (advice.getId()!=null){

                advice = adviceService.findObjectById(advice.getId());

                long count = advice.getCount();

                count ++;

                advice.setCount(count);

                adviceService.update(advice);

//                doc
                adviceDocumentList = adviceService.getAdviceDocumentsByAdviceId(advice.getId());

                //查出所有附件

                for (int i = 0 ; i < adviceDocumentList.size() ; i++){
                    adviceDocList.add(adviceDocumentList.get(i).getAdviceDocumentId().getAdviceDoc());
                }

            }

        }

        return "advice_detail";
    }

    public AdviceDoc getAdviceDoc() {
        return adviceDoc;
    }

    public void setAdviceDoc(AdviceDoc adviceDoc) {
        this.adviceDoc = adviceDoc;
    }

    public List<AdviceDoc> getAdviceDocList() {
        return adviceDocList;
    }

    public void setAdviceDocList(List<AdviceDoc> adviceDocList) {
        this.adviceDocList = adviceDocList;
    }

    public List<AdviceDocument> getAdviceDocumentList() {
        return adviceDocumentList;
    }

    public void setAdviceDocumentList(List<AdviceDocument> adviceDocumentList) {
        this.adviceDocumentList = adviceDocumentList;
    }

    public AdviceService getAdviceService() {
        return adviceService;
    }

    public void setAdviceService(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    public PageResult getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageResult pageResult) {
        this.pageResult = pageResult;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public List<Advice> getAdviceList() {
        return adviceList;
    }

    public void setAdviceList(List<Advice> adviceList) {
        this.adviceList = adviceList;
    }
}
