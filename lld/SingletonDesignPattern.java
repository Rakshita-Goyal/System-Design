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

//not thread safe beacuase if multithread program then two or more threads make different instances 
//we want same instance and only 1 insatnce 

//create a private constructor
//crate static instance (getinstance )
//return same instance evry time 

//real world :logging system,database connection ,configuration manager
