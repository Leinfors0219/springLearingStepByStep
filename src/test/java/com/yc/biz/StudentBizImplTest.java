package com.yc.biz;

import com.yc.Appconfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentBizImplTest{
    //容器
    ApplicationContext ac;
    private StudentBizImpl studentBiz;

    @Before
    public void setup(){
        ac=new AnnotationConfigApplicationContext(Appconfig.class);
        studentBiz= (StudentBizImpl) ac.getBean("studentBizImpl");
    }

    @Test
    public void testadd() {
        studentBiz.add("张三");
    }

    @Test
    public void testupdate() {
        studentBiz.update("张三");
    }
}