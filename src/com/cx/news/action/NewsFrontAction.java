package com.cx.news.action;

import com.cx.core.action.BaseAction;
import com.cx.news.entity.News;
import com.cx.news.service.NewsService;

import javax.annotation.Resource;

/**
 * Created by liujie on 2017/2/26.
 */
public class NewsFrontAction extends BaseAction {


    @Resource
    private NewsService newsService;

    private News news;

    public String news_detail(){


        if (news!=null){

            if (news.getId()!=null){

                news = newsService.findObjectById(news.getId());

                long count = news.getCount();

                count ++;

                news.setCount(count);

                newsService.update(news);

            }

        }


        return "news_detail";
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
}
