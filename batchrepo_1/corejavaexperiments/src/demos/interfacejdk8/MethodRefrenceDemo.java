package demos.interfacejdk8;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodRefrenceDemo {

    public static void main(String args[]){
        Consumer<String>consumer1=msg->System.out.println(msg);
        consumer1.accept("hello");
        Consumer<String>consumer2=System.out::println;
        consumer2.accept("hello");

        Calculator calculator=new Calculator();
        BinaryOperator<Integer>adder=calculator::sum;
        BinaryOperator<Integer>subtractor=calculator::sub;

        int result1=adder.apply(3,4);
        int result2=subtractor.apply(5,1);
        System.out.println("result="+result1);
        System.out.println("result="+result2);

        Comparator<Integer>numberComparator1= (num1,num2)->num1-num2;
        int result3=numberComparator1.compare(7,5);
        System.out.println("result3="+result3);
        Comparator<Integer>numberComparator2=Integer::compare;
        int result4=numberComparator2.compare(7,5);
        System.out.println("result4="+result4);
        BinaryOperator<Integer>binaryOperator=Integer::compare;
        int result5=binaryOperator.apply(7,5);
        System.out.println("result5="+result5);
        Predicate<Integer>evenChecker=Calculator::isEven;
        boolean result6=evenChecker.test(10);
        System.out.println("result6="+result6);

        Product product3=new Product(1,"samsung");
        Predicate<Object>equalFunctionality=product3::equals;
        boolean result7=equalFunctionality.test(new Product(2,"moto"));
        System.out.println("result 7="+result7);

    }
}
