package lld;
abstract class Car{
  protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isEngineOn = false;
        this.currentSpeed = 0;
    }
    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine started.");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }
public abstract void accelerate();
public abstract void accelerate(int speed);
public abstract void brake ();

} 
class ManualCar extends Car{
private int currentGear;
public ManualCar(String brand,String model){
    super(brand,model);
    this.currentGear=0;
}
public void shiftGear(int gear){
    this.currentGear=gear;
    System.out.println(brand+" "+model+"gear"+ currentGear);
}

 @Override
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }
    @Override
    public void accelerate(int speed) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += speed;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }
 @Override
    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }
}
class ElectricCar extends Car{
private int battery;
public ElectricCar(String brand,String model){
    super(brand,model);
    this.battery=50;
}
   public void chargeBattery() {
        battery= 100;
        System.out.println(brand + " " + model + " : Battery fully charged!");
    }
 @Override
    public void accelerate(){
      if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        if (battery<= 0) {
            System.out.println(brand + " " + model + " : Battery dead! Cannot accelerate.");
            return;
        }
        battery-=10;
        currentSpeed+=20;
System.out.println(brand+" "+model+"accelerate the electric"+currentSpeed);
    }
     @Override
    public void accelerate(int speed){
      if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        if (battery<= 0) {
            System.out.println(brand + " " + model + " : Battery dead! Cannot accelerate.");
            return;
        }
        battery-=10;
        currentSpeed+=speed;
System.out.println(brand+" "+model+"accelerate the electric"+currentSpeed);
    }
     @Override
public void brake(){
     currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed);
}
}
public class StaticDynamicPolymorphism{
    public static void main(String args[]){
 Car myManualCar = new ManualCar("Ford", "Mustang");
        myManualCar.startEngine();
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.brake();
        myManualCar.stopEngine();

        Car myElectricCar = new ElectricCar("Tesla", "Model S");
        myElectricCar.startEngine();
        myElectricCar.accelerate();
        myElectricCar.accelerate();
        myElectricCar.brake();
        myElectricCar.stopEngine();
    }
}