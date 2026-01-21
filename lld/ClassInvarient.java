package lld;
import java.lang.IllegalArgumentException;
class Account{
protected double balance;

    public Account(double b) {
        if (b < 0) throw new IllegalArgumentException("Balance can't be negative");
        this.balance = b;
    }
     public void withdraw(double amount) {
        if (balance - amount < 0) throw new RuntimeException("Insufficient funds");
        balance -= amount;
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}
class CheatAccount extends Account{
public CheatAccount(double b){
    super(b);
}
  public void withdraw(double amount) {
        
        balance -= amount;
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}
public class ClassInvarient{
    public static void main(String args[]){
       Account account = new Account(108880);
        account.withdraw(100);
        Account acc=new CheatAccount(10900);
        acc.withdraw(100);
    }
}