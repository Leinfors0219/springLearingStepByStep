package com.huawei.bean;

import com.Appconfig;
import com.mimi.bean.Person;
import com.mimi.bean.PersonBmiTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Appconfig.class})
public class ContainerTest2 {
    @Autowired
    private Container container;
    @Autowired
    private Random r;
    @Autowired
    private PersonBmiTool pbt;

    @Test
    public void save() {
        Person p1=new Person("张三",1.70,80);
        Person p2=new Person("李四",1.70,60);
        Person p3=new Person("王五",1.60,90);
        Person p4=new Person("赵六",1.86,100);
        Person p5=new Person("田七",1.72,120);
        Person p6=new Person("王八",1.67,190);

        container.save(p1);
        container.save(p2);
        container.save(p3);
        container.save(p4);
        container.save(p5);
        container.save(p6);

        for(int i=0;i<1000;i++){
            Person p7=new Person("王八"+i,1+Math.random(),r.nextInt(80)+30);
            container.save(p7);
        }

        Person max= (Person) container.getMax();
        Person min= (Person) container.getMin();

        System.out.println("最大值"+max.getName());
        System.out.println("最小值"+min.getName());

        System.out.println("平均bmi"+container.getAvg());

        Object[] objs=container.getObjs();
        for(Object o:objs){
            Person pp= (Person) o;
            System.out.println(pp.getName()+"\t"+pp.getHeight()+"\t"+pp.getWeight()+"\t"+pbt.measure(pp));
        }
    }
}