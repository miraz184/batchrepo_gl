package demos.streamapidemos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamApiDemo3 {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Stream<Integer> stream1 = list.stream();
        Stream<Integer> stream2 = stream1.limit(3);
        Consumer<Integer>consumer=System.out::println;
        stream2.forEach(consumer);
        System.out.println("***with single staement");
        //one statement
        list.stream()
                .limit(3)
                .forEach(System.out::println);

    }
}
