package lld;
class Car {
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

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }
}

class ManualCar extends Car{
    private int currentGear;
  public   ManualCar(String model,String brand){
    super(brand,model);
     this.currentGear=0;
  }
  public void shiftGear(int gear){
    this.currentGear=gear;
    System.out.println(brand+" "+model+" shift gear"+ currentGear);
  }
}

class ElectricCar extends Car{
    private int battery;
    public ElectricCar(String model,String brand){
    super(brand,model);
     this.battery=50;
    }
public void chargeBattery(){
   battery=100;
System.out.println(brand+" "+model+"chaged");
}
}

public class inheritance{
    public static void main(String args[]){
        ManualCar c1=new ManualCar("Suzuki","Toyota");

        c1.startEngine();
        c1.shiftGear(1); // Specific to Manual Car
       c1.accelerate();
        c1.brake();
       c1.stopEngine();

        ElectricCar c2=new ElectricCar("Tesla","Modela");
          c2.startEngine();
        c2.chargeBattery();
       c2.accelerate();
        c2.brake();
       c2.stopEngine();
    }
}