package com.cx.home.action;

import com.cx.advice.entity.Advice;
import com.cx.advice.service.AdviceService;
import com.cx.assessment.entity.Assessment;
import com.cx.assessment.service.AssessmentService;
import com.cx.document.entity.Document;
import com.cx.document.service.DocumentService;
import com.cx.dynamic.entity.Dynamic;
import com.cx.dynamic.service.DynamicService;
import com.cx.inform.entity.Info;
import com.cx.inform.service.InfoService;
import com.cx.news.entity.News;
import com.cx.news.service.NewsService;
import com.cx.policy.entity.Policy;
import com.cx.policy.service.PolicyService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cxspace on 16-11-10.
 */
public class HomeAction extends ActionSupport {

    @Resource
    private AdviceService adviceService;

    private List<Advice> adviceList = new ArrayList<>();

    @Resource
    private InfoService infoService;

    private List<Info> infoList = new ArrayList<>();

    @Resource
    private AssessmentService assessmentService;

    private List<Assessment> assessmentList = new ArrayList<>();

    @Resource
    private DynamicService dynamicService;

    private List<Dynamic> dynamicList = new ArrayList<>();

    @Resource
    private DocumentService documentService;

    private List<Document> documentList = new ArrayList<>();

    @Resource
    private PolicyService policyService;

    private List<Policy> policyList = new ArrayList<>();

    @Resource
    private NewsService newsService;

    private List<News> newsList;

    public String index() throws Exception {
        return "home";
    }

    public String front() {

        adviceList = adviceService.findIndexAdvice();


        infoList = infoService.findIndexInfo();

        for (int i = 0 ; i < infoList.size() ; i++){

            String time = infoList.get(i).getTime();

            time = time.substring(5,11);

            infoList.get(i).setTime(time);

        }

        assessmentList = assessmentService.findIndexAssessment();

        for (int i = 0 ; i < assessmentList.size() ; i++){

            String time = assessmentList.get(i).getTime();

            time = time.substring(5,11);


            assessmentList.get(i).setTime(time);

        }

        dynamicList = dynamicService.findIndexDynamic();

        for (int i = 0 ; i < dynamicList.size() ; i++){

            String time = dynamicList.get(i).getTime();

            time = time.substring(5,11);


            dynamicList.get(i).setTime(time);

        }

        documentList = documentService.findIndexDocument();

        policyList = policyService.findIndexPolicy();

        newsList = newsService.findObjects();



        return "front_index";
    }


    public AdviceService getAdviceService() {
        return adviceService;
    }

    public void setAdviceService(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    public List<Advice> getAdviceList() {
        return adviceList;
    }

    public void setAdviceList(List<Advice> adviceList) {
        this.adviceList = adviceList;
    }

    public InfoService getInfoService() {
        return infoService;
    }

    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;
    }

    public List<Info> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<Info> infoList) {
        this.infoList = infoList;
    }

    public AssessmentService getAssessmentService() {
        return assessmentService;
    }

    public void setAssessmentService(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    public List<Assessment> getAssessmentList() {
        return assessmentList;
    }

    public void setAssessmentList(List<Assessment> assessmentList) {
        this.assessmentList = assessmentList;
    }

    public DynamicService getDynamicService() {
        return dynamicService;
    }

    public void setDynamicService(DynamicService dynamicService) {
        this.dynamicService = dynamicService;
    }

    public List<Dynamic> getDynamicList() {
        return dynamicList;
    }

    public void setDynamicList(List<Dynamic> dynamicList) {
        this.dynamicList = dynamicList;
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public PolicyService getPolicyService() {
        return policyService;
    }

    public void setPolicyService(PolicyService policyService) {
        this.policyService = policyService;
    }

    public List<Policy> getPolicyList() {
        return policyList;
    }

    public void setPolicyList(List<Policy> policyList) {
        this.policyList = policyList;
    }

    public NewsService getNewsService() {
        return newsService;
    }

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
