package demos.interfacejdk8;

public class CalculatorMain1 {

    public static void main(String args[]){
        String className=ICalculator.className();
        ICalculator calculator=new CasioCalculator();
        int result=calculator.add(1,2);
        System.out.println("result="+result);
    }
}
