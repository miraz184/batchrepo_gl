package demos;

import java.util.ArrayList;
import java.util.List;

/**
 *  add 2, 0,
 */
public class ConcurrentModExceptionDemo {

    public static void main(String args[]){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);

        //for (int i=0;i<10;i++){
          for (int i:list){
            list.add(i);
            if(i%2==0){
                list.add(0);
            }
        }

        System.out.println("list="+list);

    }
}
