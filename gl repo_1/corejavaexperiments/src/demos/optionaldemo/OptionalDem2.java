package demos.optionaldemo;

import java.util.Optional;

public class OptionalDem2 {

    public static void main(String args[]){
        //Optional<String> optional1=Optional.of("hello");
        Optional<String> optional1=Optional.empty();
        if(optional1.isPresent()){
           String value =optional1.get();
            System.out.println("value is ="+value);
        }else{
            System.out.println("optional does not contain value");

        }
    }
}
