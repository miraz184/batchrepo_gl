package demos;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx1 {

    public static void main(String args[]){
        Set<String> set=new HashSet<>();
        set.add("apple");
        set.add("orange");
        set.add("mango");
        set.add("banana");
        set.add("apple");
        set.add(null);
        System.out.println(set);
        for (String e:set){
            System.out.println("element="+e);
        }
    }

}
