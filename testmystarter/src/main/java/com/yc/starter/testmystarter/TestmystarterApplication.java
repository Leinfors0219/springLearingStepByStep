package com.yc.starter.testmystarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.starter.hellostarter.servies.Helloservies

@SpringBootApplication
@RestController
public class TestmystarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestmystarterApplication.class, args);

        @Autowired
        private Helloservies helloservies;

        @GetMapping("/hello")
        public String sayHello(){
            return helloservies.say();
        }
    }

}
