package demos.interfacejdk8;

public class Calculator {

    public int sum(int num1, int num2){
        return num1+num2;
    }

    public int sub(int num1, int num2){
        return num1-num2;
    }

    public static boolean isEven(int number){
        return number %2==0;
    }

}
