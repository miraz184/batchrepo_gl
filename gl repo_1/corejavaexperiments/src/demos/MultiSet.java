package demos;

import java.util.*;

public class MultiSet<K, V> {
    private Map<K, Set<V>> internalMap ;

    public MultiSet(){
        internalMap=new HashMap<>();
    }

    public MultiSet(Comparator<K>comparator){
        internalMap=new TreeMap<>(comparator);
    }

    public void add(K key, V value) {
        boolean exists = internalMap.containsKey(key);
        if (exists) {
            Set<V> values = internalMap.get(key);
            values.add(value);
            return;
        }
        Set<V> values = newSet();
        values.add(value);
        internalMap.put(key, values);

    }

    public void removeValue(K key, V value) {
        boolean exists = internalMap.containsKey(key);
        if (!exists) {
            return;
        }
        Set<V> values = internalMap.get(key);
        values.remove(value);
        if (values.isEmpty()) {
            internalMap.remove(key);
        }
    }

    public Set<K> keySet() {
        return internalMap.keySet();
    }

    public void removeKey(K key) {
        internalMap.remove(key);
    }


    public Set<V> get(K key) {
        return internalMap.get(key);
    }

   protected Set<V> newSet() {
        return new HashSet<>();
    }


}
