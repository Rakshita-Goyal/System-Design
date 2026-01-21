package lld;
abstract class Car{
public abstract void start();
public abstract void stop();
public abstract void accelerate();
public abstract void shiftGear(int gear);
public abstract void brake();
}
class Engine{
private boolean isOn=false;
public void start(){
isOn=true;
System.out.println("startec the engine");
}
public void stop(){
isOn=false;
System.out.println("stopped the engine");
}
public boolean isRunning(){
    return isOn;
}
}
class SuperCar extends Car{
private String brand;
private String model;
private int currentGear;
private int currentSpeed;
private Engine engine ;
private AccelerationType accelerationType;
public SuperCar(String brand,String model,Engine engine,AccelerationType accelerationType ){
    this.brand=brand;
    this .model=model;
    this.engine=engine;
    this.currentGear=0;
    this.currentSpeed=0;
    this.accelerationType=accelerationType;
}
@Override
   public void start() {
        engine.start();
    }

    @Override
   public void stop() {
        engine.stop();
    }

    @Override
   public void shiftGear(int gear) {
        this.currentGear = gear;
        System.out.println("Gear shifted to " + gear);
    }

    @Override
  public  void brake() {
        currentSpeed-=20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println("Brake applied");
    }
    @Override
  public  void accelerate(){
       accelerationType.accelerate(this);
    }
    public void increaseSpeed(int speed){
        currentSpeed+=speed;
         System.out.println("Current speed: " + currentSpeed);
    }

}
 interface AccelerationType{
public void accelerate(SuperCar car);
}
class NormalAcceleration implements AccelerationType{
@Override
public void accelerate(SuperCar car){
    car.increaseSpeed(20);
}
}
 class SportsAcceleration implements AccelerationType{
@Override
public void accelerate(SuperCar car){
    car.increaseSpeed(30);
}
}
public class OcpCar{
    public static void main(String args[]){
        Engine engine=new Engine();
       
Car normalCar=new SuperCar("toyota","suzuki",engine,new NormalAcceleration());
Car sportsCar=new SuperCar("tesla","model1",engine,new SportsAcceleration());
normalCar.start();
normalCar.accelerate();
sportsCar.start();
sportsCar.accelerate();
    }
}