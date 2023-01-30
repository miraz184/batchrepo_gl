package com.gltraining.aopdemo;


import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int add(int num1, int num2){
        System.out.println("inside add");
        int result= num1+num2;
        return result;
    }


    public int sub(int num1, int num2){
        System.out.println("inside sub");
        int result= num1-num2;
        return result;
    }

    public boolean isEven(int num){
        if(num<0){
        throw new InvalidArgumentException("input less than zero");
        }
        return num%2==0;
    }

}
