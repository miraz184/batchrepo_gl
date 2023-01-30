package demos;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String args[]) {
        TreeMapEx demo = new TreeMapEx();
        SortedMap<Integer, Customer> map = new TreeMap<>(new KeyCustomerIdComparator());
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
            System.out.print("key=" + key + ",");
            demo.display(value);
        }
        System.out.println("iterating using entries");
        Set<Map.Entry<Integer, Customer>> entries = map.entrySet();
        for (Map.Entry<Integer, Customer> entry : entries) {
            System.out.print("key=" + entry.getKey() + ",");
            demo.display(entry.getValue());
        }

        int firstKey = map.firstKey();
        System.out.println("dirst key=" + firstKey);
        int lastKey = map.lastKey();
        System.out.println("last key=" + lastKey);
        System.out.println("subap from key 2 to 4");
        Map<Integer, Customer> submap = map.subMap(2, 4);
        for (int key : submap.keySet()) {
            Customer value = map.get(key);
            System.out.print("key=" + key + ",");
            demo.display(value);
        }

    }


    void display(Customer customer) {
        System.out.println(customer.getId() + "-" + customer.getName());

    }
}
