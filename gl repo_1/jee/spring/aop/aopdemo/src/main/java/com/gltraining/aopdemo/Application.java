package com.gltraining.aopdemo;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

    public static void main(String args[]){
        ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        Calculator calculator=context.getBean(Calculator.class);

        int result1=calculator.add(3,5);
        System.out.println("add result is "+result1);

        int result2=calculator.sub(10,4);
        System.out.println("sub result is "+result2);

        boolean result3=calculator.isEven(-10);
        System.out.println("inside result3="+result3);


    }

}
