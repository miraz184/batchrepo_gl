package demos.interfacejdk8;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorDemo {
    public static void main(String args[]){
        ISquare square1=num->num*num;
        int result1=square1.square(5);

        System.out.println("result1="+result1);

        UnaryOperator<Integer>square2=num->num*num;
        int result2=square2.apply(5);
        System.out.println("result2="+result2);

        ISumCalculator calculator1=(num1, num2)->num1+num2;
        int result3=calculator1.sum(3,5);
        System.out.println("result3="+result3);

        BinaryOperator<Integer>calculator2=(num1, num2)->num1+num2;
        int result4=calculator2.apply(3,5);
        System.out.println("result4="+result4);
    }
}
