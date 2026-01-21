package lld;
class Animal{

}
class Dog extends Animal{

}
class Parent{
public Animal walk(){
    System.out.println("parent walk animal");
    return new Animal();
}
}
class Child extends Parent{
@Override
public Animal walk(){
    System.out.println("child is walking dog");
    return new Dog();
}
}
class Client{
    private Parent p;
      public Client(Parent p) {
        this.p = p;
    }

    public void takewalk() {
        p.walk();
    }
}
public class ReturnType{
    public static void main(String args[]){
Parent parent = new Parent();
        Child child   = new Child();

        Client client = new Client(child);
        Client client2 = new Client(parent);
        client.takewalk();
client2.takewalk();
    }
}