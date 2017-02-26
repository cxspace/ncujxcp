package com.cx.inform.action;

import com.cx.core.action.BaseAction;
import com.cx.core.utils.DateTimeHelper;
import com.cx.inform.entity.Info;
import com.cx.inform.service.InfoService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2017/2/25.
 */
public class InformSysAction extends BaseAction {

    @Resource
    private InfoService infoService;

    private Info info;

    private List<Info> infoList = new ArrayList<>();

    public String listUI(){


        infoList = infoService.findObjects();

        return "listUI";
    }

    public String addUI(){

        return "addUI";
    }

    public String add(){

        if (info != null){
            info.setTime(DateTimeHelper.getCurrentDateTime());
            info.setCount(0);
            infoService.save(info);
        }

        return "list";
    }

    public String delete(){

        if (info != null){

            if (info.getId()!=null){

                infoService.delete(info.getId());

            }

        }

        return "list";
    }

    public InfoService getInfoService() {
        return infoService;
    }

    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
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
