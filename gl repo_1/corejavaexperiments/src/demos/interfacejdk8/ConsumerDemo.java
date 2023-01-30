package demos.interfacejdk8;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String args[]){
        IPrint printer1=msg-> System.out.println(msg);
        printer1.print("Hello");
        Consumer<String>printer2=(msg)-> System.out.println(msg);
        printer2.accept("Hi");

        IPrintCharacter printer3=(msg, index)->{
          char ch=msg.charAt(index);
            System.out.println("character="+ch);
        };
        printer3.print("bangaluru",4);

        BiConsumer<String,Integer>printer4=(msg, index)->{
            char ch=msg.charAt(index);
            System.out.println("character="+ch);
        };
        printer4.accept("bangaluru",4);


    }
}
