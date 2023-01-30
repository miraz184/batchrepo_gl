package com.gltraining;

public class Calculator {

    private Adder adder;

    public Calculator(Adder adder){
        this.adder=adder;
    }

    public int add(int num1, int num2){
        System.out.println("inside Calculator add unit");
        int result=adder.sum(num1, num2);
        return result;
    }

    public int addBy10(int num){
        System.out.println("inside  Calculator addBy10");
       int result=add(num,10);
       return result;
    }


}
