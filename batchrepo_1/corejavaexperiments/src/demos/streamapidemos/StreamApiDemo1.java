package demos.streamapidemos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * convert from list of string of fruits to list of integer where every integer is length of string
 * + the list should be ony containing length of fruits names starting with a or o
 * <p>
 * Lis<String>-> List<Integer>
 * [5, 6]
 */
public class StreamApiDemo1 {
    public static void main(String args[]) {
        StreamApiDemo1 demo=new StreamApiDemo1();
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("mango");
        list.add("orange");
        list.add("banana");
        List<Integer>result1=demo.notStreamApi(list);
        System.out.println("without stream api="+result1);
        List<Integer>result2=demo.withStreamApi(list);
        System.out.println("with stream api="+result2);
        System.out.println("original list="+list);

    }
    List<Integer> withStreamApi(Collection<String> fruits) {
        Predicate<String>predicate=fruit->{
            fruit=fruit.toLowerCase();
            boolean check= (fruit.startsWith("a") || fruit.startsWith("o"));
            return check;
        };
      /*
        Stream<String> stream1=fruits.stream();
        Stream<String>stream2=stream1.filter(predicate);
        Function<String,Integer>function=fruit->fruit.length();
        Stream<Integer>stream3 =stream2.map(function);
        List<Integer>desired=stream3.collect(Collectors.toList());
        return desired;
        */

        List<Integer>desired= fruits.stream()
                .filter(predicate)
                .map(fruit->fruit.length())
                .collect(Collectors.toList());
                return desired;
    }

    List<Integer> notStreamApi(Collection<String> fruits) {
        List<Integer> desired = new ArrayList<>();
        for (String fruit : fruits) {
            fruit = fruit.toLowerCase();
            if (fruit.startsWith("a") || fruit.startsWith("o")) {
                desired.add(fruit.length());
            }
        }
        return desired;
    }


}
