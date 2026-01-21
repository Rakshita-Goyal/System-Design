package lld;
import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    // Calculates total price in cart.
    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
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
interface saveToDatabase{
    public void save(ShoppingCart cart);
}
class saveToSql implements saveToDatabase{
    @Override
    public void save(ShoppingCart cart){
        System.out.println("save to sql");
    }
}
class saveToFile implements saveToDatabase{
    @Override
    public void save (ShoppingCart cart){
        System.out.println("save to file");
    }
}
public class OPCfollowed{
    public static void main(String args[]){
  ShoppingCart cart=new ShoppingCart();
        PrintInvoice invoice=new PrintInvoice(cart);
       
        cart.addProduct(new Product("lenovo",1234));
        cart.addProduct(new Product("mac",2345));
        invoice.print();
       saveToDatabase db=new saveToSql();
       db.save(cart);
       saveToDatabase db2=new saveToFile();
       db2.save(cart);
    }
}