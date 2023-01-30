package demos.inheritance;

public class SimpleCalculator {

    private int simpleCalculatorMemory;

    public int addNumbers(int num1, int num2){
        int result= num1+num2;
        this.simpleCalculatorMemory=result;
        return result;
    }

    public String getLastOperationDetails(){
        String result= ""+simpleCalculatorMemory;
        return result;
    }


}
