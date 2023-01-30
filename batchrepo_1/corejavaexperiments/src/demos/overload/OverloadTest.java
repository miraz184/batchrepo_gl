package demos.overload;

public class OverloadTest {
    public static void main(String args[]) {
        SimpleCalculator calcy = new SimpleCalculator();
        calcy.add(1, 2);
        calcy.add(1, 2, 3);
        calcy.add("new", "delhi");

    }
}
