package demos.overload;

public class SimpleCalculator {

    public int add(int num1, int num2){
        return num1+num2;
    }

    public int add(int num1, int num2, int num3){
        return num1+num2+num3;
    }

    public String add(String str1, String str2){
        return str1+str2;
    }

}
