package demos.coupling;

public class CanvasTest {
    public static void main(String args[]){
        Square square=new Square(5);
        Canvas canvas1=new Canvas(square);
        canvas1.drawShape();

        Circle circle=new Circle(10);
        Canvas canvas2=new Canvas(circle);
        canvas2.drawShape();

    }
}
