package demos.interfacejdk8;

import java.util.function.Function;

public class Example {

    public static void main(String args[]) {
        Example example=new Example();
        ICheck checker=example::check;
    }

    String  check(String msg)throws ClassNotFoundException{
        throw new ClassNotFoundException();
    }

}
