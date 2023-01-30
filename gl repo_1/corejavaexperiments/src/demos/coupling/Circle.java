package demos.coupling;

public class Circle implements IShape{
    private int radius;

    public Circle(int radius){
        this.radius=radius;
    }

    @Override
    public int area() {
        return  (int) (3.14*radius*radius);
    }
}
