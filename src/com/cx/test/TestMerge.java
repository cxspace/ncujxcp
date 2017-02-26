package com.cx.test;

import com.cx.test.entity.Person;
import com.cx.test.service.TestService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by cxspace on 16-11-10.
 */
public class TestMerge {


    private ClassPathXmlApplicationContext context;

    @org.junit.Before

    public void loadCtx(){

        context = new ClassPathXmlApplicationContext("bean-base.xml");

        TestService ts = (TestService)context.getBean("testService");

        ts.say();

    }




    public void testHibernate(){

        SessionFactory sf = (SessionFactory)context.getBean("sessionFactory");

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(new Person("人员1"));

        tx.commit();

        session.close();

    }

    //测试service和dao层



    @Test
    public void testServiceAndDao(){

        TestService testService = (TestService)context.getBean("testService");

        testService.save(new Person("人员2"));

    }


//    测试readOnly 在service中如果增删改就报异常



    public void testTxReadOnly(){

        TestService testService = (TestService)context.getBean("testService");

        System.out.println(testService.findPerson("ff808181584c33c001584c33c2aa0000").getName());

    }

//    测试事务回滚

    public void testTxRollBack(){

        TestService ts = (TestService)context.getBean("testService");

        ts.save(new Person("人员3"));

    }

}
