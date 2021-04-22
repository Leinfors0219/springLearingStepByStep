package com.yc.tx.bean;

/**
 * @program: testspring
 * @description:
 * @author: LQH
 * @create: 2021-04-17 14:36
 */
public enum OpTypes {
    deposite("deposite",1),withdraw("withdraw",2),transfer("transfer",3);

    private String name;
    private int index;

    private OpTypes(String name, int index) {
        this.name=name;
        this.index=index;
    }

    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }

    public String getName(){
        return this.name;
    }
}
