package lld;
interface twodimension{
    public double area();
}
interface threedimension{
    public double area();
    public double volume();
}
class Square implements twodimension{
    private double side;

    public Square(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return side * side;
    }
}
class Rectangle implements twodimension{
    private double length, width;

    public Rectangle(double l, double w) {
        this.length = l;
        this.width  = w;
    }

    @Override
    public double area() {
        return length * width;
    }
}
class Cube implements threedimension{
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

public class ISPfollowed{
    public static void main(String args[]){
        twodimension sq=new Square(2);
        twodimension rec=new Rectangle(2,3);
        threedimension cub=new Cube(3);

System.out.println(sq.area());
System.out.println(rec.area());
System.out.println(cub.volume());

    }
}