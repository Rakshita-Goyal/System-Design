package lld;
class SportsCar{
    private String model;
    private String  brand;
     private boolean isEngineOn = false;
    private int currentSpeed = 0;
    private int currentGear = 0;
    private String tyreCompany;

public SportsCar(String model,String brand){
this.model=model;
this.brand=brand;
}
public int getSpeed(){
    return currentSpeed;
}
public int getGear(){
    return currentGear;
}
public void setTyreCompany(String company){
this.tyreCompany=company;
}
public String getTyreCompany(){
return tyreCompany;
}
public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine starts with a roar!");
    }

    public void shiftGear(int gear) {
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off! Cannot accelerate.");
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

    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }
}
public class encapsulation{
public static void main(String args[]){
    SportsCar car=new SportsCar("ford","mustang");
car.startEngine();
 car.shiftGear(1);
      car.accelerate();
       car.shiftGear(2);
 car.accelerate();
       car.brake();
      car.stopEngine();
      System.out.println("Current Speed of My Sports Car is " +car.getSpeed());
}
}