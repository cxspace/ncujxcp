package com.cx.news.service.impl;

import com.cx.core.service.impl.BaseServiceImpl;
import com.cx.news.dao.NewsDao;
import com.cx.news.entity.News;
import com.cx.news.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liujie on 2017/2/26.
 */

@Service("newsService")

public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {

    private NewsDao newsDao;

    @Resource
    public void setNewsDao(NewsDao newsDao) {

        super.setBaseDao(newsDao);
        this.newsDao = newsDao;
    }
}
