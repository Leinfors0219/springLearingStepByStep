package com.yc.bean;

import com.yc.springframework.stereotype.MyComponent;
import com.yc.springframework.stereotype.MyPostConstruct;
import com.yc.springframework.stereotype.MyPreDestroy;

@MyComponent
public class HelloWorld {
    @MyPostConstruct
    public void setup() {
        System.out.println("myPostConstruct");
    }

    @MyPreDestroy
    public  void  destory(){
        System.out.println("MyPreDesotry");
    }

    public HelloWorld() {
        System.out.println("HelloWorld");
    }

    public void execute(){
        System.out.println("execute");
    }

}
