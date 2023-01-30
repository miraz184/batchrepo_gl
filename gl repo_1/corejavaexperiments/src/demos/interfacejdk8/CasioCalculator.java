package demos.interfacejdk8;

public class CasioCalculator implements ICalculator{


    @Override
    public int sub(int num1, int num2) {
        return num1-num2;
    }
}
