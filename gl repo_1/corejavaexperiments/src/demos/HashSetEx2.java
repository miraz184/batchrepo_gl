package demos;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx2 {

    public static void main(String args[]){
        Set<Customer> set=new HashSet<>();
        set.add(new Customer(2,"ambati"));
        set.add(new Customer(1,"abhishek"));
        set.add(new Customer(3, "manoj"));
        set.add(new Customer(4, "pankaj"));
    }
}
