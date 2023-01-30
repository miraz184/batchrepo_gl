package demos.optionaldemo;

import demos.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo1 {


    public static void main(String args[]) {
        OptionalDemo1 demo = new OptionalDemo1();
        Map<Integer, Customer> map = new HashMap<>();
        map.put(1, new Customer(1, "gopala"));
        map.put(2, new Customer(2, "rushikesh"));
        Optional<Customer>optional1=demo.getById(map,1);
        demo.displayCustomer(optional1);
        Optional<Customer>optional2=demo.getById(map,50);
        demo.displayCustomer(optional2);

    }

    void displayCustomer(Optional<Customer>optional){
        if(optional.isPresent()){
            Customer result=optional.get();
            System.out.println("customer info-"+result.getId()+" "+result.getName());
        }

    }



    int add(int num1, int num2) {
        return num1 + num2;
    }

    Optional<Customer> getById(Map<Integer, Customer> map, int id) {
        Customer value = map.get(id);
        if (value == null) {
            Optional<Customer> optional = Optional.empty();
            return optional;
        }
        Optional<Customer> optional = Optional.of(value);
        return optional;
    }


}
