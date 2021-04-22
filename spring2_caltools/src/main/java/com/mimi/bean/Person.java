package com.mimi.bean;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-10 20:27
 */
public class Person {
    private String name;
    private double height;
    private double weight;

    public Person(){
        super();
    }

    public Person(String name, double height, double weight) {
        super();
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
