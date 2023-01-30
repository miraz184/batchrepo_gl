package demos.interfacejdk8;

public class Product {
    private int id;
    private String name;
    public Product(){
        System.out.println("inside ctr");
    }

    public Product(int id, String name){
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

    @Override
    public boolean equals(Object obj) {
        if(obj==this){
            return true;
        }
        if(obj==null||!obj.getClass().equals(Product.class)){
            return false;
        }
        Product that=(Product) obj;
        return that.id==id;
    }
}
