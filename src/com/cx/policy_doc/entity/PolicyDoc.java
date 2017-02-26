package com.cx.policy_doc.entity;

/**
 * Created by liujie on 2017/2/25.
 */
public class PolicyDoc {

    private String id;

    private String title;

    private String time;

    private long count;

    private String link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public PolicyDoc() {
    }


    public PolicyDoc(String id) {
        this.id = id;
    }

    public PolicyDoc(String id, String title, String time, long count, String link, String reserve) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.count = count;
        this.link = link;
        this.reserve = reserve;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", count='" + count + '\'' +
                ", link='" + link + '\'' +
                ", reserve='" + reserve + '\'' +
                '}';
    }

}
