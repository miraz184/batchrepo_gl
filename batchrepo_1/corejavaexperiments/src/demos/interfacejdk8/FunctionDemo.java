package demos.interfacejdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String args[]){
        ILength lengthFinder1=(input)->input.length();
        int result1=lengthFinder1.length("hello");
        System.out.println("result1="+result1);

        Function<String,Integer>lengthFinder2=(input)->input.length();
        int result2=lengthFinder2.apply("hello");
        System.out.println("result2="+result2);

        Function<Integer,Boolean>evenChecker=num->num%2==0;
        boolean result3=evenChecker.apply(10);
        System.out.println("result3="+result3);

        IStringConatenator concater1=(input, times)->{
          String result="";
          for (int i=0;i<times;i++){
              result=result+input;
          }
          return result;
        };
        String result4=concater1.multiply("hi",3);
        System.out.println("result4="+result4);
        BiFunction<String,Integer,String>concater2=(input, times)->{
            String result="";
            for (int i=0;i<times;i++){
                result=result+input;
            }
            return result;
        };
        String result5=concater2.apply("hi",3);
        System.out.println("result5="+result5);

    }
}
