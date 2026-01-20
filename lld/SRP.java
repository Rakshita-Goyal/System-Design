package lld;
import java.util.ArrayList;
import java.util.List;
class Product{
    public String name;
    public double price;
    public Product(String name,double price){
this.price=price;
this.name=name;
    }
}
class ShoppingCart{
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
    public void saveToDatabase(){
 System.out.println("Saving shopping cart to database...");
    }
    public void printInvoice(){
System.out.println("shopping cart invoice");
for(Product p:products){
System.out.println(p.name+"has price of "+p.price);
}
System.out.println("the total cost is :"+calculateTotal());
    }
}
public class SRP{
    public static void main(String args[]){
ShoppingCart cart=new ShoppingCart();
cart.addProduct(new Product("lenono",7890));
cart.addProduct(new Product("mac",12341));
cart.getProducts();
cart.saveToDatabase();
cart.printInvoice();
    }
}