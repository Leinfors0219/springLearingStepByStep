package com.mimi.bean;

import com.huawei.bean.Measurable;
import org.springframework.stereotype.Component;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-10 20:27
 */
@Component
public class PersonBmiTool implements Measurable {

    @Override
    public double measure(Object obj) {
        if(obj==null){
            return 0;
        }
        if(!(obj instanceof Person)){
            return 0;
        }
        Person p=(Person)obj;
        double bmi=p.getWeight()/(p.getHeight()*p.getHeight());
        return bmi;
    }
}
