package demos;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheDemo {
    public static void main(String args[]){
        LRUCacheDemo demo = new LRUCacheDemo();
        LinkedHashMap<Integer,Customer>map=new CustomCache<>(3);
        map.put(1, new Customer(1, "abhishek"));
        map.put(4, new Customer(4, "pankaj"));
        map.put(3, new Customer(3, "manoj"));
        map.get(1);
        map.get(4);
        map.put(2, new Customer(2, "ambati"));
        System.out.println(map.keySet());

    }

    static class CustomCache<K,V> extends LinkedHashMap<K,V>{
        private final int maxSize;
        public CustomCache(int maxSize){
            super(maxSize,.75f,true);
            this.maxSize=maxSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
           return size()>maxSize;
        }
    }

    void display(Customer customer) {
        System.out.println(customer.getId() + "-" + customer.getName());

    }
}
