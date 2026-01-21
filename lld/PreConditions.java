package lld;
class Parent{
public void setPassword(String password){
if(password.length()<8){
    throw new IllegalArgumentException("Password must be at least 8 characters long!");
}
 System.out.println("Password set successfully");
}
}
class Child extends Parent{
    @Override
public void setPassword(String password){
if(password.length()<6){
    throw new IllegalArgumentException("Password must be at least 6 characters long!");
}
 System.out.println("Password set successfully in child");

}
}

public class PreConditions{
    public static void main(String args[]){
        Parent parent=new Parent();
        Child child=new Child();
        Parent ch=new Child();
        parent.setPassword("parentis");
        child.setPassword("childis");
        ch.setPassword("chee");
    }
}