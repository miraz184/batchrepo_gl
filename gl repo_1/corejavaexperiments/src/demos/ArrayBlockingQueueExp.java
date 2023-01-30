package demos;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExp {
    public static void main(String args[]) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        boolean added = queue.offer(4);
        System.out.println("added=" + added);
    }
}
