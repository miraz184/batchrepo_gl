package demos.streamapidemos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiDemo2 {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("hi");
        list.add("hello");
        list.add("hi");
        list.add("hello");
         //distinct operation
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.distinct();
        List<String> result1 = stream2.collect(Collectors.toList());
        System.out.println("result1=" + result1);

        List<String> result2 = list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("result2=" + result2);


    }
}
