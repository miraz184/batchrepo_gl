package demos.interfacedemo;

import java.util.ArrayList;

public class Frontend {

    public static void main(String args[]){
        int num1=5;
        int num2=7;
        ICalculator calcy=new CasioCalculator();
        int result=calcy.add(num1,num2);
        System.out.println("result="+result);
    }
}
