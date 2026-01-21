//there is supercar(With engine and gears)
//electric car just (without engine and gears)
//magnetic car just (with gears only)

package lld;
abstract class Car{
public abstract void accelerate();
public abstract void brake();
}
abstract class WithEngine extends Car{
public abstract void startEngine();
public abstract void stopEngine();
}
interface WithGear {
public abstract void shiftGear(int gear);
}
class SuperCar extends WithEngine implements WithGear{

 @Override
    public void startEngine() {
        System.out.println("Engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Engine stopped");
    }

    @Override
    public void shiftGear(int gear) {
        System.out.println("Gear shifted to " + gear);
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating");
    }

    @Override
    public void brake() {
        System.out.println("Brake applied");
    }
}
class ElectricCar extends Car{
   @Override
    public void accelerate() {
        System.out.println("Electric acceleration");
    }

    @Override
    public void brake() {
        System.out.println("Electric Brake applied");
    }
}
class GearCar extends Car implements WithGear{
  @Override
    public void shiftGear(int gear) {
        System.out.println("Gear shifted to " + gear);
    }

    @Override
    public void accelerate() {
        System.out.println(" gear Accelerating");
    }

    @Override
    public void brake() {
        System.out.println(" gear Brake applied");
    }
}
public class LspCar{
    public static void main(String args[]){
        Car c1=new SuperCar();
        Car c2=new ElectricCar();
        Car c3=new GearCar();
c1.accelerate();
c2.accelerate();
c3.accelerate();
    }
}