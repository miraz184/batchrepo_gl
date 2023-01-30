package demos;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetEx {

    public static void main(String args[]){
        Set<String> set=new LinkedHashSet<>();
        set.add("apple");
        set.add("orange");
        set.add("mango");
        set.add("banana");
        set.add("apple");
        System.out.println(set);
        for (String e:set){
            System.out.println("element="+e);
        }
    }

}
