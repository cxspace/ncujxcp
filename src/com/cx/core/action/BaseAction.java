package com.cx.core.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by cxspace on 16-11-17.
 */
public class BaseAction extends ActionSupport {



    //初始页号
    private int pageNo = 1;

    //每页记录数
    private int pageSize = 8;



    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
