package demos;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetEx1 {

    public static void main(String args[]){
        Set<String> set=new TreeSet<>();
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
