package demos.interfacejdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class CollectionsLambda {
    public static void main(String args[]){
        List<String> list=new ArrayList<>();
        list.add("hi");
        list.add("hello");
        list.add("good");
        Consumer<String>consumer1=(input)-> System.out.println("element="+input);
        System.out.println("**print all elements");
        list.forEach(consumer1);
        System.out.println("** print all elements");
        Consumer<String>consumer2=System.out::println;
        list.forEach(consumer2);
        Comparator<String>comparator1=String::compareTo;
        list.sort(comparator1);
        System.out.println("acending="+list);
        System.out.println("descending");
        Comparator<String>comparator2=(input1,input2)->{
           int compare= input2.compareTo(input1);
           return compare;
        };
        list.sort(comparator2);
        System.out.println("sorted list="+list);
    }
}
