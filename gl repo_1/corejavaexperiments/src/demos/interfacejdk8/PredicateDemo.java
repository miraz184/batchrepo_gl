package demos.interfacejdk8;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String args[]){
        IEven checker1=num->num%2==0;
        boolean result1=checker1.isEven(10);
        System.out.println("result1="+result1);

        Predicate<Integer>checker2=num->num%2==0;
        boolean result2=checker2.test(10);
        System.out.println("result2="+result2);

        ISumEven sumChecker1=(num1, num2)->(num1+num2)%2==0;
        boolean result3=sumChecker1.sum(3,5);
        System.out.println("result3="+result3);

        BiPredicate<Integer,Integer>sumChecker2=(num1, num2)->(num1+num2)%2==0;
        boolean result4=sumChecker2.test(3,5);
        System.out.println("result4="+result4);

        ILengthChecker lengthChecker1=(input, expectedLength)->input.length()==expectedLength;
        boolean result5=lengthChecker1.check("hello",5);
        System.out.println("result5="+result5);
        BiPredicate<String,Integer>lengthChecker2=(input, expectedLength)->input.length()==expectedLength;
        boolean result6=lengthChecker2.test("mumbai",4);
        System.out.println("result6="+result6);
    }

}
