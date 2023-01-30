package demos.inheritance;

public class CalculatorTest {

    public static void main(String args[]){
        SimpleCalculator calculator=new ScientificCalculator();
        int result1=calculator.addNumbers(1,2);
        ScientificCalculator scientificCalculator=(ScientificCalculator)calculator;
        String result2=scientificCalculator.addStrings("good","bye");

    }
}
