package demos.identityEquality;

public class IdentityEqualityTest {
    public  static void main(String args[]){

        Customer c1=new Customer(1,"sohail");
        Customer c2=new Customer(1,"sohail");
        boolean same=c1==c2;
        System.out.println("are two objects c1 and c2 are holding same="+same);
        boolean equal=c1.equals(c2);
        System.out.println("are two objects c1 and c2 are holding equal content="+equal);
    }
}
