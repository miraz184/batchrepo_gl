package demos;

public class Customer implements Comparable<Customer>{
    private int id;
    private String name;
    public Customer(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // obj1.equals(obj2)

    @Override
    public boolean equals(Object arg) {
        if(this==arg){
            return true;
        }
        if(arg==null || !arg.getClass().equals(Customer.class)){
            return false;
        }
        Customer that=(Customer) arg;
        return id==that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Customer arg) {
        return this.id-arg.id;
    }

    @Override
    public String toString() {
        return id+"-"+name;
    }
}
