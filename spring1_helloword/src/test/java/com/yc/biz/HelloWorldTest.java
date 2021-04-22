package com.yc.biz;

import com.yc.Appconfig;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldTest extends TestCase {
    private ApplicationContext ac;//spring 容器


    @Override
    @Before
    public void setUp(){
        //AnnotationConfigApplicationContext基于注解的配置容器
        ac=new AnnotationConfigApplicationContext(Appconfig.class);
        //读取AppConfig.class-》basePackages="com.yc"-》得到要扫描的路径
        //要检查这些包上是否有Component注解，如有，则实例化
        //存到一个map<String,Object>
    }

    @Test
    public void testHello() {
        HelloWorld hw=(HelloWorld) ac.getBean("helloWorld");
        hw.hello();

        HelloWorld hw2=(HelloWorld) ac.getBean("helloWorld");
        hw2.hello();
    }
}