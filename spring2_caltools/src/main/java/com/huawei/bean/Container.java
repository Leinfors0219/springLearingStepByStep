package com.huawei.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-10 20:12
 */
@Component
public class Container {
    public static final int LENGTH=5;//定义常量

    private Object[] objs=new Object[LENGTH];
    private int count;//计数器，计量objs数组实际存的已测量对象的数目
    private Object max;//数组中最大值的对象
    private Object min;//数组中最小值的对象
    private double avg;//平均值
    private double sum;//总值

    private Measurable measurable;//用于测量的测量工具

    private double objvalue;

    public double getObjvalue() {
        return objvalue;
    }

    public Object[] getObjs() {
        Object[]newobjs=new Object[count];
        System.arraycopy(objs,0,newobjs,0,count);
        return newobjs;
    }

    @Autowired
    public void setMeasurable(Measurable measurable) {
        this.measurable = measurable;
        objs=new Object[LENGTH];
        count=0;
        max=null;
        min=null;
        avg=0;
    }

    public Object getMax() {
        return max;
    }

    public Object getMin() {
        return min;
    }

    public double getAvg() {
        return avg;
    }

    public void save(Object obj){
        if(obj==null){
            System.out.println("要测量的对象不能为空");
            return;
        }
        if(count>=objs.length){
            Object[] newobjects=new Object[objs.length*2];
            System.arraycopy(objs,0,newobjects,0,objs.length);
            objs=newobjects;
        }
        objs[count]=obj;
        objvalue=measurable.measure(obj);
        if(count==0){
            max=obj;
            min=obj;
        }else {
            double maxvalue=measurable.measure(max);
            double minvalue=measurable.measure(min);
            if(objvalue>maxvalue){
                max=obj;
            }
            if(objvalue<minvalue){
                min=obj;
            }
        }
        count++;
        sum+=objvalue;
        avg=sum/count;
    }
}
