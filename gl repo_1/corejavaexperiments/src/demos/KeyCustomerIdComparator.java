package demos;

import java.util.Comparator;
import java.util.Map;

public class KeyCustomerIdComparator implements Comparator<Integer> {


    @Override
    public int compare(Integer e1, Integer e2) {
        return e1-e2;
    }
}
