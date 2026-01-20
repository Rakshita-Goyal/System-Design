package lld;

abstract class Car{
public abstract void start();
public abstract void shiftGear(int gear);
public abstract void accelerate();
public abstract void brake();
public abstract void stop();
}
class Engine{
    //engine will do the start stop ison or not 
private boolean isOn=false;
void start(){
isOn=true;
System.out.println("Engine started");
}
void stop(){
 isOn = false;
        System.out.println("Engine stopped");
}
 boolean isRunning(){
return isOn;
}
}

class SuperCar extends Car{
private String brand;
 private String model;
    private int currentGear;
    private int currentSpeed;
private Engine engine;


public SuperCar(String brand,String model,Engine engine){
    this.brand=brand;
    this.model=model;
    this.currentGear=0;
    this.currentSpeed=0;
    this.engine=engine;
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
        currentSpeed+=20;
        System.out.println("accerlated");
    }
}
public class SrpCar{
    public static void main(String args[]){
        Engine engine=new Engine();
Car car=new SuperCar("Ford","Mustang",engine);
car.start();
car.shiftGear(5);
car.accelerate();
car.brake();
car.stop();

    }
}