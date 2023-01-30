package demos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
   set.add(new Customer(2,"ambati"));
        set.add(new Customer(1,"abhishek"));
        set.add(new Customer(3, "manoj"));
        set.add(new Customer(4, "pankaj"));
 */
public class HashMapEx {

    public static void main(String args[]){
        HashMapEx demo=new HashMapEx();
        Map<Integer, Customer>map=new HashMap<>();
        map.put(1,new Customer(1,"abhishek"));
        map.put(3,new Customer(3, "manoj"));
        map.put(4,new Customer(4, "pankaj"));

        int size=map.size();
        System.out.println("size="+size);
        Customer fetchedFromKey3=map.get(3);
        System.out.print("fetched from key 3");
        demo.display(fetchedFromKey3);
        boolean key4Exists=map.containsKey(4);
        System.out.println("key 4 exists="+key4Exists);
        Set<Integer> keys=map.keySet();
         for (int key:keys){
             Customer value=map.get(key);
             System.out.print("key="+key);
             demo.display(value);
         }
        System.out.println("iterating using entries");
       Set<Map.Entry<Integer,Customer>>entries=  map.entrySet();
       for (Map.Entry<Integer,Customer>entry:entries){
           System.out.print("key="+entry.getKey());
           demo.display(entry.getValue());
       }
    }


    void display(Customer customer){
        System.out.println(customer.getId()+"-"+customer.getName());

    }
}
