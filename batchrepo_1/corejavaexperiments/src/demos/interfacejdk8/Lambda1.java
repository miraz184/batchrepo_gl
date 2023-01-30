package demos.interfacejdk8;

public class Lambda1 {
    public static void main(String args[]){
        IAdder adder1=new IAdder() {
            @Override
            public int add(int num1, int num2) {
                return num1+num2;
            }
        };
        int result1=adder1.add(1,2);

        IAdder adder2=(num1, num2)->num1+num2;
        int result2=adder2.add(2,3);

        IAdder adder3=(num1, num2)->{
            System.out.println("inside add implementation");
            return num1+num2;
        };
        int result3=adder3.add(3,4);

        System.out.println("result1="+result1);
        System.out.println("result2="+result2);
        System.out.println("result3="+result3);


    }
}
