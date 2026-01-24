package lld;
interface Shape{
    public double area();
    public double volume ();
}
class Square implements Shape{
    private double side;

    public Square(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double volume() {
        throw new UnsupportedOperationException("Volume not applicable for Square"); 
    }
}
class Rectangle implements Shape{
    private double length,breadth;

    public Rectangle(double length,double breadth) {
        this.length=length;
        this.breadth=breadth;
    }

    @Override
    public double area() {
        return length * breadth;
    }

    @Override
    public double volume() {
        throw new UnsupportedOperationException("Volume not applicable for Rectangle"); 
    }
}
class Cube implements Shape{
     private double side;

    public Cube(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}
public class ISP{
    public static void main(String args[]){
Shape sq=new Square(3);
Shape rec=new Rectangle(2,3);
Shape cub=new Cube(3);
sq.area();
sq.volume();
rec.area();
rec.volume();
cub.area();
cub.volume();

    }
}