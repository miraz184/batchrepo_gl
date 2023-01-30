package demos.passbydemos;

public class PassByDemo1 {

    public static void main(String args[]){
        int i=10;
        PassByDemo1 demo=new PassByDemo1();
        demo.increment(i);
        System.out.println("inside main,i="+i);
    }

    void increment(int copyI){
        copyI++;
        System.out.println("inside increment i="+copyI);
    }
}
