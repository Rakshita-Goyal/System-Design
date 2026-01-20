package lld;
class Car{
    private String model;
    private String brand;
     private boolean isEngineOn;
    private int currentSpeed;
    private int currentGear;

    public Car(String brand,String model){
  this.brand = brand;
        this.model = model;
        this.isEngineOn = false;
        this.currentSpeed = 0;
        this.currentGear = 0;
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
   public void accelerate(){
      if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed );

   }
   public void accelerate(int speed){
 if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += speed;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed );
   }
}
public class staticPolymorphism{
    public static void main(String args[]){
Car car=new Car("Toyota","Suzuki");
car.startEngine();
car.accelerate();
car.accelerate(20);
car.stopEngine();
    }
}