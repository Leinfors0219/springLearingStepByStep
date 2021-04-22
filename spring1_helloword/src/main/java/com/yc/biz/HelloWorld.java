package com.yc.biz;

import org.springframework.stereotype.Component;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-09 21:21
 */

@Component//只要加了这个注解，则这个类可以被spring容器托管
public class HelloWorld {//创建这个类的对象
    public HelloWorld() {
        System.out.println("无参构造方法");
    }
    public void hello(){
        System.out.println("hello world");
    }
}
