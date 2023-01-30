package demos.identityEquality;

/**
 * Customer c1=new Customer(1,"abc")
 * c1.setId(10)
 *
 *
 */
public class Customer {
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

    /**
     *
     * Customer c1=new Customer(1,"abc")
     *  String c2="1,abc;
     *  c1.equals(c2)
     *
     */
    @Override
    public boolean equals(Object arg) {
        if(this==arg){
            return true;
        }
        if(arg==null || (arg.getClass()!=getClass())){
            return false;
        }
        Customer that=(Customer) arg;
        return id==that.id;
    }

}
