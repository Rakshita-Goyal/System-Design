//postcondition :has to follow the child function and not contradict the parent,can have extra 
package lld;
class Car{

protected int speed;

    public Car() {
        speed = 0;
    }

    public void accelerate() {
        System.out.println("Accelerating");
        speed += 20;
        System.out.println("speed is"+speed);
    }
    public void brake() {
        System.out.println("Applying brakes");
        speed -= 20;
         System.out.println("speed is"+speed);
    }
}
class SuperCar extends Car{
private int charge;
public SuperCar(){
    charge=0;
}
@Override
public void accelerate(){
    System.out.println("accerlate the supercar");
    speed+=20;
    charge-=10;
    System.out.println("the super speed "+speed+" and charge"+charge);
}
@Override
public void brake(){
    System.out.println("brake in supercar");
    speed -= 20;
        charge += 10;
        System.out.println("in the supercar"+"speed is"+speed+"and the chareg is "+charge);
}
}
public class PostConditions{
    public static void main(String args[]){
Car car=new Car();
Car sc=new SuperCar();
car.accelerate();
car.brake();
sc.accelerate();
sc.brake();

    }
}