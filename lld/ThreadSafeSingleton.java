package lld;

public class ThreadSafeSingleton {
    // private static ThreadSafeSingleton instance = null;

    // private ThreadSafeSingleton() {
    //     System.out.println("Singleton Constructor Called!");
    // }

    // public static ThreadSafeSingleton getInstance() {

    //     synchronized (ThreadSafeSingleton.class) { 
    //         if (instance == null) {
    //             instance = new ThreadSafeSingleton();
    //         }
    //         return instance;
    //     }
    // }

  private static ThreadSafeSingleton instance = null;

    private ThreadSafeSingleton() {
        System.out.println("Singleton Constructor Called!");
    }
public static ThreadSafeSingleton getInstance(){
    if(instance==null){
 synchronized (ThreadSafeSingleton.class) { 
if(instance==null){
instance=new ThreadSafeSingleton();
}

 }
    }
return null;
}
    public static void main(String[] args) {
        ThreadSafeSingleton s1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton s2 = ThreadSafeSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}
