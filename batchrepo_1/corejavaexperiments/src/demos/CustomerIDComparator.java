package demos;

import java.util.Comparator;

public class CustomerIDComparator implements Comparator<Customer> {


    @Override
    public int compare(Customer c1, Customer c2) {
        return c1.getId()-c2.getId();
    }
}
