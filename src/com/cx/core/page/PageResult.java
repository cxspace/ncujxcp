package com.cx.core.page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxspace on 16-11-17.
 */
public class PageResult {

    //总记录数
    private long totalCount;

    //当前页号
    private int pageNo;

    //总页数
    private int totalPageCount;

    //页大小
    private int pageSize;

    private List items;

    //计算出总页数

    public PageResult(int pageSize, int pageNo, List items, long totalCount) {

        this.items = items == null?new ArrayList():items;
        this.totalCount = totalCount;
        this.pageSize = pageSize;

        if (totalCount!=0){
            //计算总页数
            int tem = (int) totalCount / pageSize;

            this.totalPageCount = (totalCount%pageSize==0)?tem:(tem+1);

            this.pageNo = pageNo;
        }else {
            pageNo = 0;
        }

    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

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

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }
}
