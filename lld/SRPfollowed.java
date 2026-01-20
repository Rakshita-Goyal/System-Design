package lld;
import java.util.List;
import java.util.ArrayList;
class Product{
   public String name ;
   public double price ;
   Product(String name,double price){
    this.name=name;
    this.price=price;
   }
}
class ShoppingCart{
    //it will add ,get and total price of cart;
    private List<Product>products=new ArrayList<Product>();
    public void addProduct(Product p){
        products.add(p);
    }
    public List<Product>getProducts(){
        return products;
    }
    public double calculateTotal(){
     double total=0;
     for(Product p:products){
        total+=p.price;
     }
     return total;
    }

}

class PrintInvoice{
private ShoppingCart cart;
public PrintInvoice(ShoppingCart cart){
this.cart=cart;
}
public void print(){
    for(Product p:cart.getProducts()){
        System.out.println(p.name+"has price of "+p.price);
    }
    System.out.println("the price is "+ cart.calculateTotal());
}

}

class SaveToDatabase{
    private ShoppingCart cart;
    public SaveToDatabase(ShoppingCart cart){
        this.cart=cart;
    }
    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

public class SRPfollowed{
public static void main(String args[]){
ShoppingCart cart=new ShoppingCart();
cart.addProduct(new Product("lenovo",1234));
cart.addProduct(new Product("mac",2345));
PrintInvoice invoice=new PrintInvoice(cart);
invoice.print();
SaveToDatabase db=new SaveToDatabase(cart);
db.saveToDatabase();
}
}