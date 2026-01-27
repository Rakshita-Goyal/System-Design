package lld;

interface Car{
    String getDescription();
    double  getCost();
}
class BasicCar implements Car{
   @Override
    public String getDescription() {
        return "Basic Car";
    }

    @Override
    public double getCost() {
        return 500000;
    }
}
abstract class  Decorator implements Car{
    //decorator has a car 
     protected Car car;

    public Decorator(Car car) {
        this.car = car;
    }

}
class ACDecorator extends Decorator{

public ACDecorator(Car car){
    super(car);
}
 @Override
    public String getDescription() {
        return car.getDescription() + ", AC";
    }

    @Override
    public double getCost() {
        return car.getCost() + 50000;
    }
}
class SunroofDecorator extends Decorator{

  public SunroofDecorator(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", Sunroof";
    }

    @Override
    public double getCost() {
        return car.getCost() + 100000;
    }
}
public class DecoratorDesignCar{
    public static void main(String args[]){
Car car=new BasicCar();
System.out.println(car.getCost());
System.out.println(car.getDescription());
car=new SunroofDecorator(car);
System.out.println(car.getCost());
System.out.println(car.getDescription());

    }
}