package com.yc.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController  //@Controller控制层注解， @Restful 以rest规范（请求方式：get，post，put，delte）
public class Springboot1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot1Application.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",defaultValue = "world")String name){
        return String.format("hello %s",name);
    }

}
