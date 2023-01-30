package demos;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeTest {

    public static void main(String args[]) {
        List<Customer> list = Arrays.asList(
                new Customer(55, "amar"),
                new Customer(35, "amit"),
                new Customer(75, "sohail"),
                new Customer(15, "abhishek"),
                new Customer(65, "arvinth"),
                new Customer(85, "manoj"),
                new Customer(45, "lakshmi"));
        BinaryTree<Customer> tree = new BinaryTree<>();
        tree.add(list);
        Customer findInput = new Customer(65, "arvinth");
        boolean exists = tree.findElement(findInput);
        System.out.println("element found=" + exists);
    }
}
