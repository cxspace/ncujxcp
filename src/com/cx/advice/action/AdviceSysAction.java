package com.cx.advice.action;

import com.cx.advice.entity.Advice;
import com.cx.advice.service.AdviceService;
import com.cx.core.utils.DateTimeHelper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class AdviceSysAction {

    @Resource
    private AdviceService adviceService;

    private Advice advice;

    private List<Advice> adviceList = new ArrayList<>();

    public String listUI(){


        adviceList = adviceService.findObjects();

        return "listUI";
    }

    public String addUI(){

        return "addUI";
    }

    public String editUI(){

        if (advice!=null){

            if (advice.getId()!=null){

                advice = adviceService.findObjectById(advice.getId());
            }

        }


        return "editUI";
    }

    public String edit(){

        if (advice!=null){

            adviceService.update(advice);
        }

        return "list";

    }

    public String add(){

        if (advice != null){
            advice.setTime(DateTimeHelper.getCurrentDateTime());
            advice.setCount(0);
            adviceService.save(advice);
        }

        return "list";
    }

    public String delete(){

        if (advice != null){

            if (advice.getId()!=null){

                adviceService.delete(advice.getId());

            }

        }

        return "list";
    }


    public AdviceService getAdviceService() {
        return adviceService;
    }

    public void setAdviceService(AdviceService adviceService) {
        this.adviceService = adviceService;
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
