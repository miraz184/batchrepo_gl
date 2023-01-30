package demos;

import java.util.ArrayList;
import java.util.List;

/**
 * add(e)
 * remove(e)
 * size()
 * addAll(colelction)
 * get(index)
 * remove(index)
 * indexOf(*)
 */
public class ListExp1 {

    public static void main(String args[]){
        List<String>list1=new ArrayList<>();
        list1.add("apple");
        list1.add("mango");

        List <String>list2=new ArrayList<>();
        list2.add("grapes");
        list2.add("banana");

        list1.addAll(list2);
        System.out.println(list1);

        String elementIndex2=list1.get(2);
        System.out.println("element at index 2="+elementIndex2);

        list1.remove(0);

        boolean exists=list1.contains("apple");
        System.out.println("apple exists="+exists);
        int indexElement=list1.indexOf("apple");
        System.out.println("index of apple in list="+indexElement);
        List<String>foundElements=new ArrayList<>();
        int index=0;
        for (String element:list1){
             if(index%2==0 ){
                foundElements.add(element);
            }
            index++;

        }
        list1.removeAll(foundElements);

    }

}
