package demos;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetEx2 {
    public  static void main(String args[]){
        TreeSetEx2 demo=new TreeSetEx2();
        SortedSet<Customer> set=new TreeSet<>(new CustomerIDComparator());
        set.add(new Customer(2,"ambati"));
        set.add(new Customer(1,"abhishek"));
        set.add(new Customer(3, "manoj"));
        set.add(new Customer(4, "pankaj"));
        set.add(null);
        for (Customer iterated:set){
           demo.display(iterated);
        }
        System.out.println("** first element");
       Customer first= set.first();
        demo.display(first);
        System.out.println("** last element");
       Customer last=set.last();
       demo.display(last);
       SortedSet<Customer>subset=set.subSet(new Customer(2,"ambati"),new Customer(4,"pankaj"));
       for (Customer iterated:subset){
           demo.display(iterated);
       }
    }

    void display(Customer customer){
        System.out.println(customer.getId()+"-"+customer.getName());

    }

}
