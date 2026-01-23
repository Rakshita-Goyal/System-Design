package lld;

public class SingletonDesignPattern{
private static   SingletonDesignPattern instance =null;
private SingletonDesignPattern(){
    System.out.println("the constructur");
}
public static SingletonDesignPattern getInstance(){
    if(instance==null){
instance=new SingletonDesignPattern();
    }
    return instance;
}
    public static void main(String args[]){
        SingletonDesignPattern obj1=SingletonDesignPattern.getInstance();
        SingletonDesignPattern obj2= SingletonDesignPattern.getInstance();
        System.out.println(obj1==obj2);
    }
}