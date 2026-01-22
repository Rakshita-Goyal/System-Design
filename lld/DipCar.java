package lld;

interface Engine{
    public void start();
}
class PetrolEngine implements Engine{
    @Override
 public void start() {
        System.out.println("Petrol engine started");
    }
}
class ElectricEngine implements Engine{
    @Override
 public void start() {
        System.out.println("Electric engine started");
    }
}
class Car{
private Engine engine;
public Car(Engine engine){
    this.engine=engine;
}
 public void start() {
        engine.start();
    }
}
public class DipCar{
    public static void main(String args[]){
        Engine engine=new PetrolEngine();
Car car =new Car(engine);
car.start();

Engine engine1=new ElectricEngine();
Car c=new Car(engine1);
c.start();
    }
}