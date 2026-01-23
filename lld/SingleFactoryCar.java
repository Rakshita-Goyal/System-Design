package lld;
interface Car{
    public void start();
}
class Sedan implements Car{
@Override
public void start(){
    System.out.println("sudan started");
}
}
class SUV implements Car{
@Override
public void start(){
    System.out.println("suv start");
}
}
class Factory{
    public static Car createCar(String type){
        if(type.equals("SEDAN")){
            return new Sedan();
        }
        else if (type.equals("SUV")){
            return new SUV();
        }

        return null;
    }
}

public class SingleFactoryCar{
    public static void main(String args[]){
        String type="SEDAN";
        Factory factory=new Factory();
        Car car=factory.createCar("SEDAN");
        car.start();
    }
}