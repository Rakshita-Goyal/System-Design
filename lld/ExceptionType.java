package lld;
import java.lang.RuntimeException;
import java.lang.ClassNotFoundException;
import java.lang.ArithmeticException ;
/* 
└── java.lang.Exception                        // Conditions your application might want to catch
    ├── java.io.IOException                    // Checked I/O failures
    │   ├── java.io.FileNotFoundException
    │   ├── java.io.EOFException
    │   └── java.net.MalformedURLException
    ├── java.lang.ClassNotFoundException       // Checked reflect/… failures
    ├── java.lang.InterruptedException         // Checked thread interruption
    ├── java.sql.SQLException                  // Checked SQL/database errors
    ├── java.text.ParseException               // Checked parsing errors
    └── java.lang.RuntimeException             // Unchecked; subclasses may be thrown anywhere
        ├── java.lang.ArithmeticException      // e.g. divide by zero
        ├── java.lang.NullPointerException
        ├── java.lang.ArrayIndexOutOfBoundsException
        ├── java.lang.StringIndexOutOfBoundsException
        ├── java.lang.IllegalArgumentException
        │    └── java.lang.NumberFormatException
        ├── java.lang.IllegalStateException
        ├── java.lang.UnsupportedOperationException
        └── java.lang.IndexOutOfBoundsException // parent of the two “…OutOfBounds” above
*/

class Parent{
public void getValue() throws RuntimeException{
    throw new RuntimeException("Parent error");
}
}
class Child extends Parent{
public void getValue() throws ArithmeticException{
    throw new ArithmeticException("child error");
}
}
class Client{
  private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

public void takeValue(){
    try{
        p.getValue();
    }
    catch(RuntimeException e){
 System.out.println("RuntimeException occurred: " + e.getMessage());
    }
}
}
public class ExceptionType{
public static void main(String args[]){
    Parent parent = new Parent();
        Child child   = new Child();
Parent ch=new Child();
        Client client = new Client(parent);
        Client client2 = new Client(child);
        Client client3=new Client(ch);
        client.takeValue();  
client2.takeValue();
client3.takeValue();
}
}
