package demos.coupling;

public class Square implements IShape{
    private int side;

    public Square(int side){
        this.side=side;
    }
    @Override
    public int area(){
        return side*side;
    }

}
