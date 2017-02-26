package com.cx.news.action;

import com.cx.core.action.BaseAction;
import com.cx.core.utils.DateTimeHelper;
import com.cx.news.entity.News;
import com.cx.news.service.NewsService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by liujie on 2017/2/26.
 */
public class NewsSysAction extends BaseAction {

    @Resource
    private NewsService newsService;

    private News news;

    private File doc;

    private String docContentType;

    private String docFileName;


    private List<News> newsList = new ArrayList<>();

    public String listUI(){


        newsList = newsService.findObjects();

        return "listUI";
    }

    public String addUI(){

        return "addUI";
    }

    public String add(){

        if (news != null){

            String filePath = ServletActionContext.getServletContext().getRealPath("upload/doc");

            String filename = UUID.randomUUID().toString().replaceAll("-","")+docFileName.substring(docFileName.lastIndexOf("."));

            try {

                FileUtils.copyFile(doc,new File(filePath,filename));

                if (news!=null){


                    news.setCount(0);
                    news.setTime(DateTimeHelper.getCurrentDateTime());
                    news.setImg("upload/doc/"+filename);

                    newsService.save(news);

                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        return "list";
    }

    public String delete(){

        if (news != null){

            if (news.getId()!=null){

                newsService.delete(news.getId());

            }

        }

        return "list";
    }

    public NewsService getNewsService() {
        return newsService;
    }

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public File getDoc() {
        return doc;
    }

    public void setDoc(File doc) {
        this.doc = doc;
    }

    public String getDocContentType() {
        return docContentType;
    }

    public void setDocContentType(String docContentType) {
        this.docContentType = docContentType;
    }

    public String getDocFileName() {
        return docFileName;
    }

    public void setDocFileName(String docFileName) {
        this.docFileName = docFileName;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
