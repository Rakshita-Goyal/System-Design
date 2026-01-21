//when called child it should have argument as same of broader argument is acceptable
package lld;
class Parent{
public void print( Object msg){
    System.out.println("parent: "+msg);
}
}
class Child extends Parent{
    @Override
public void print(String msg){
    System.out.println("child: "+msg);
}
}
class Client{
private Parent parent;
public Client(Parent parent){
    this.parent=parent;
}
public void write(){
    parent.print("hello");
}
}
public class MethodArgumentRule{
    public static void main(String args[]){
Parent parent=new Parent();
Parent child=new Child();
Child chi=new Child();
Client cl=new Client(parent);
cl.write();
Client cl2=new Client(child);
cl2.write();
Client cl3=new Client(chi);
cl3.write();
    }
}