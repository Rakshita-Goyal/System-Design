package lld;
import java.util.List;
import java.util.ArrayList;

abstract class DepositOnly{
    public abstract void deposit(double amount);
}
abstract class WithdrawAlso extends DepositOnly{
public abstract void withdraw(double amount);
}
class FixedAccount extends DepositOnly{
private double balance;
public FixedAccount(double balance ){
    this.balance=balance;
}
@Override
public void deposit(double amount){
    balance+=amount;
    System.out.println("deposit in deposit only");
}
}
class SavingAccount extends WithdrawAlso{
private double balance;
public SavingAccount(double balance){
    this.balance=balance;
}
@Override
public void deposit(double amount){
    balance+=amount;
    System.out.println("deposit in deposit only");
}
@Override
public void withdraw(double amount){
    if(balance>=amount){
        balance=balance-amount;
     System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
}
}
class CurrentAccount extends WithdrawAlso{
private double balance;
public CurrentAccount(double balance){
    this.balance=balance;
}
@Override
public void deposit(double amount){
    balance+=amount;
    System.out.println("deposit in deposit only");
}
@Override
public void withdraw(double amount){
    if(balance>=amount){
        balance=balance-amount;
     System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
}
}
class BankClient{
    private List<DepositOnly>depositAccounts;
   private  List<WithdrawAlso>withdrawAccounts;
   public BankClient(List<DepositOnly>depositAccounts,List<WithdrawAlso>withdrawAccounts){
    this.depositAccounts=depositAccounts;
    this.withdrawAccounts=withdrawAccounts;
   }
   public void transaction(){
    for(WithdrawAlso wd:withdrawAccounts){
wd.withdraw(500);
wd.deposit(5000);
    }
    for(DepositOnly dp:depositAccounts){
dp.deposit(5678);
    }
   }
}
public class LSPfollowed{
    public static void main(String args[]){

List<WithdrawAlso>wd=new ArrayList<WithdrawAlso>();
List<DepositOnly>dp=new ArrayList<DepositOnly>();
wd.add(new SavingAccount(1000));
wd.add(new CurrentAccount(1000));
dp.add(new FixedAccount(1000));

BankClient cl=new BankClient(dp,wd);
cl.transaction();

    }
}