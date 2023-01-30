package demos;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class QueueExp4 {
    public static void main(String args[]){
        Deque<Integer> queue=new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        int firstElement=queue.peekFirst();
        int lastElement=queue.peekLast();
        System.out.println("first element from peeking="+firstElement);
        System.out.println("last element from peeking="+lastElement);
        System.out.println(queue);
        int polledFirst=queue.pollFirst();
        int polledLast=queue.pollLast();
        System.out.println("first element from polling="+polledFirst);
        System.out.println("last element from polling="+polledLast);
        System.out.println(queue);
    }
}
