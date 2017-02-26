package com.cx.news.entity;

/**
 * Created by liujie on 2017/2/26.
 */
public class News {

    private String id;

    private String title;

    private String time;

    private long count;

    private String content;

    private String img;

    private String reserve;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public News(String id, String title, String time, long count, String content, String img, String reserve) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.count = count;
        this.content = content;
        this.img = img;
        this.reserve = reserve;
    }

    public News() {
    }
}
