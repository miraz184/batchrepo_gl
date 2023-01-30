package demos.coupling;

public class Canvas {
    private IShape shape;

    public Canvas(){ }
    public  Canvas(IShape shape){
        this.shape=shape;
    }

    public void setShape(Square shape){
        this.shape=shape;
    }
    public void drawShape() {
        int area = shape.area();
        System.out.println("drawing shape of area=" + area +" shape is="+shape.getClass().getSimpleName());
    }

    public IShape getShape() {
        return shape;
    }
}
