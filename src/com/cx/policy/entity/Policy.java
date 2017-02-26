package com.cx.policy.entity;

import java.io.Serializable;

/**
 * Created by liujie on 2017/2/25.
 */
public class Policy implements Serializable{

    private String id;

    private String title;

    private String time;

    private long count;

    private String content;

    private String reserve;

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Policy() {

    }

    public Policy(String id, String title, String time, long count, String content, String reserve) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.count = count;
        this.content = content;
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", count=" + count +
                ", content='" + content + '\'' +
                ", reserve='" + reserve + '\'' +
                '}';
    }
}
