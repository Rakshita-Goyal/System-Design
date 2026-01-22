package lld;
interface Car{
    void startEngine();
    void accelerate();
    void brake();
    void stopEngine();
    void shiftGear(int gear);

}
class SportsCar implements Car{
    String brand;
    String model;
    int currentSpeed;
    int currentGear;
    boolean isEngineOn;
    public SportsCar(String model,String brand){
        this.brand=brand;
        this.model=model;
        this.currentGear=0;
        this.currentSpeed=0;
        this.isEngineOn=false;
    }
    @Override
    public void startEngine(){
  isEngineOn=true;
  System.out.println(brand+" "+model+"engine will start");
    }
    @Override
    public void accelerate(){
if(!isEngineOn){
    System.out.println(brand+" "+model+"engine is off");
    return ;
}
currentSpeed+=20;
System.out.println(brand+" "+model+"accerlate to "+currentSpeed);
    }
    @Override
    public void brake(){
   currentSpeed-=20;
   if(currentSpeed<0)currentSpeed=0;
   System.out.println(brand +" "+model+"breaking at"+currentSpeed);
    }
    @Override
    public void shiftGear(int gear){
if(!isEngineOn){
System.out.println(brand + " " + model + "engine off");
            return;
}
this.currentGear=gear;
System.out.println(brand + " " + model + "shifted to gear " + currentGear);
    }
    @Override
    public void stopEngine(){
isEngineOn=false;
currentGear=0;
currentSpeed=0;
System.out.println(brand+" "+model+"engine off");
    }

}
public class abstraction{
    public static void main(String args[]){
 Car car=new SportsCar("ford","mustang");
 car.startEngine();
 car.shiftGear(1);
 car.accelerate();
 car.shiftGear(5);
 car.brake();
 car.stopEngine();
    }

}