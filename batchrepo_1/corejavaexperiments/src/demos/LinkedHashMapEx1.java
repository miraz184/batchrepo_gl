package demos;

import java.util.*;

public class LinkedHashMapEx1 {
    public static void main(String args[]){
        LinkedHashMapEx1 demo = new LinkedHashMapEx1();
        Map<Integer, Customer> map = new LinkedHashMap<>();
        map.put(1, new Customer(1, "abhishek"));
        map.put(4, new Customer(4, "pankaj"));
        map.put(3, new Customer(3, "manoj"));
        map.put(2, new Customer(2, "ambati"));
        int size = map.size();
        System.out.println("size=" + size);
        Customer fetchedFromKey3 = map.get(3);
        System.out.print("fetched from key 3");
        demo.display(fetchedFromKey3);
        boolean key4Exists = map.containsKey(4);
        System.out.println("key 4 exists=" + key4Exists);
        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            Customer value = map.get(key);
            System.out.print("key=" + key+",");
            demo.display(value);
        }
    }



    void display(Customer customer) {
        System.out.println(customer.getId() + "-" + customer.getName());

    }
}
