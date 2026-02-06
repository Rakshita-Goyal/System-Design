package lld;

interface ShapeVisitor{
    public void visit(Circle circle);
    public void visit(Rectangle rectangle);
}
interface Shape{
 void accept(ShapeVisitor visitor);
}
class Circle implements Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    double length;
    double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
class AreaVisitor implements ShapeVisitor {

    public void visit(Circle circle) {
        double area = Math.PI * circle.radius * circle.radius;
        System.out.println("Area of Circle: " + area);
    }

    public void visit(Rectangle rectangle) {
        double area = rectangle.length * rectangle.breadth;
        System.out.println("Area of Rectangle: " + area);
    }
}

public class VisitorShape{
    public static void main(String args[]){

  Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        ShapeVisitor areaVisitor = new AreaVisitor();

 circle.accept(areaVisitor);
        rectangle.accept(areaVisitor);

    }
}