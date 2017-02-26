package com.cx.test.action;

import com.cx.test.entity.Person;
import com.cx.test.service.TestService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

/**
 * Created by cxspace on 16-8-23.
 */
public class TestAction extends ActionSupport {

    @Resource
    TestService testService;

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    //默认执行的方法
    public String hello() throws Exception {

        testService.say();

        testService.save(new Person("人员4"));

        return SUCCESS;
    }
}

