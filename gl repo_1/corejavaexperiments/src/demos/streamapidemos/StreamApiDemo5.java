package demos.streamapidemos;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamApiDemo5 {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();

        list.add(20);
        list.add(40);
        list.add(30);
        list.add(50);
        list.add(10);

        Stream<Integer> stream1 = list.stream();
        Comparator<Integer>comparator= (a,b)->a-b;
        Optional<Integer> optional=stream1.min(comparator);
        if(optional.isPresent()){
            Integer value=optional.get();
            System.out.println("value="+value);
        }

    }
}
