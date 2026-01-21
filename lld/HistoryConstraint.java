
package lld;
import java.util.List;
import java.util.ArrayList;
import java.lang.RuntimeException;
//deposit withdraw fixed 
abstract class Account{
    public abstract void deposit(double amount);
public abstract void withdraw(double amount);
}
class SavingAccount extends Account {
private double balance;
public SavingAccount(double balance ){
    this.balance=balance;
}
@Override
public void deposit(double amount){
 balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
}
@Override
public void withdraw(double amount ){
 if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
}
}
class CurrentAccount extends Account{
private double balance;
public CurrentAccount(double balance ){
    this.balance=balance;
}
@Override
public void deposit(double amount){
 balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
}
@Override
public void withdraw(double amount ){
 if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
}
}
class FixedAccount extends Account{
private double balance;
public FixedAccount(double balance ){
    this.balance=balance;
}
@Override
public void deposit(double amount){
 balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
}
@Override
public void withdraw(double amount ){
throw new RuntimeException("cant withdarw it ") ;
}

}
class BankClient{
    private List<Account>accounts;
    public BankClient(List<Account>accounts){
        this.accounts=accounts;
    }
    public void transaction(){
        for(Account acc:accounts){
            acc.deposit(1000);
            try{
                System.out.println("deposited");
                acc.withdraw(500);
            }
            catch(RuntimeException e){
                System.out.println("error is "+e.getMessage());
            }
        }
    }
}
public class HistoryConstraint{
    public static void main(String args[]){
List<Account>accounts=new ArrayList<Account>();
accounts.add(new SavingAccount(1000));
accounts.add(new CurrentAccount(1000));
accounts.add(new FixedAccount(1000));

BankClient cl=new BankClient(accounts);
cl.transaction();
    } 
}