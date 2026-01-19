package lld;

abstract class Car {

    abstract void startEngine();
    abstract void shiftCar(int gear);
    abstract void brake();
    abstract void stopEngine();
}

class SportsCar extends Car {


   private String brand;
  private  String model;
   private boolean isEngine;
  private  int currentSpeed;
 private   int currentGear;

    SportsCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isEngine = false;
        this.currentSpeed = 0;
        this.currentGear = 0;
    }

public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isEngineOn() {
        return isEngine;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    // 🔹 Setters
    public void setCurrentGear(int gear) {
        if (gear >= 0 && gear <= 6) {
            this.currentGear = gear;
        }
    }

    public void setCurrentSpeed(int speed) {
        if (speed >= 0) {
            this.currentSpeed = speed;
        }
    }

    @Override
    void startEngine() {
        System.out.println("Engine started");
        isEngine = true;
    }

    @Override
    void shiftCar(int gear) {
        currentGear = gear;
        System.out.println("Gear shifted to " + gear);
    }

    @Override
    void brake() {
        System.out.println("Brake applied");
    }

    @Override
    void stopEngine() {
        System.out.println("Engine stopped");
        isEngine = false;
    }
}

public class code1 {
    public static void main(String[] args) {

        Car car = new SportsCar("Ford", "Mustang");
        car.startEngine();
        car.shiftCar(5);
     
    }
}
