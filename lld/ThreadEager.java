package lld;

public class ThreadEager{
    private static ThreadEager instance =new ThreadEager();
public static ThreadEager getInstance(){
return instance;
}
    public static void main(String args[]){
ThreadEager s1=ThreadEager.getInstance();
ThreadEager s2=ThreadEager.getInstance();
        System.out.println(s1 == s2);
    }
}