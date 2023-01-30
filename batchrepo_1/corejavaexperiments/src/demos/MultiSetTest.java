package demos;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class MultiSetTest {

    public static void main(String args[]){
        MultiSet<Integer,String>store=new MultiSet<>();

        store.add(2,"mohan");
        store.add(2, "anant");
        store.add(1,"aditya");
        store.add(1,"pankaj");

        Set<String> standard1Students=store.get(1);
        Set<String>standard2Students=store.get(2);
        System.out.println("stanadard1 students="+standard1Students);
        System.out.println("standard2 students="+standard2Students);

        store.removeValue(2,"mohan");
        System.out.println("keys after removing mohan="+store.keySet());
        store.removeValue(2,"anant");
        System.out.println("keys after removing anant="+store.keySet());

    }
}
