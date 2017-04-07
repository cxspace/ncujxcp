package com.cx.dynamic.action;

import com.cx.core.utils.DateTimeHelper;
import com.cx.dynamic.entity.Dynamic;
import com.cx.dynamic.service.DynamicService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2017/2/26.
 */
public class DynamicSysAction {

    @Resource
    private DynamicService dynamicService;

    private Dynamic dynamic;

    private List<Dynamic> dynamicList = new ArrayList<>();

    public String listUI(){


        dynamicList = dynamicService.findObjects();

        return "listUI";
    }

    public String addUI(){

        return "addUI";
    }

    public String editUI(){

        if (dynamic != null){

            if (dynamic.getId()!=null);

            dynamic = dynamicService.findObjectById(dynamic.getId());

        }

        return "editUI";
    }

    public String edit(){

        if (dynamic!=null){
            dynamicService.update(dynamic);
        }

        return "list";
    }

    public String add(){

        if (dynamic != null){
            dynamic.setTime(DateTimeHelper.getCurrentDateTime());
            dynamic.setCount(0);
            dynamicService.save(dynamic);
        }

        return "list";
    }

    public String delete(){

        if (dynamic != null){

            if (dynamic.getId()!=null){

                dynamicService.delete(dynamic.getId());

            }

        }

        return "list";
    }

    public DynamicService getDynamicService() {
        return dynamicService;
    }

    public void setDynamicService(DynamicService dynamicService) {
        this.dynamicService = dynamicService;
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
