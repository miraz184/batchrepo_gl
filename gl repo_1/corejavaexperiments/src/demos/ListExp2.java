package demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListExp2 {
    public static void main(String args[]){
        List<Customer>list=new LinkedList<>();
        list.add(new Customer(2, "ritika"));
        list.add(new Customer(1, "sohail"));
        list.add(new Customer(4, "abhishek"));
        list.add(new Customer(3,"aravinth"));
       list.sort(new CustomerIDComparator());
    //    Collections.sort(list);
        for (Customer e:list){
            System.out.println(e.getId()+"-"+e.getName());
        }

    }

}
