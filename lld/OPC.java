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
    public void saveToSql() {
        System.out.println("Saving shopping cart to sql");
    }
    public void saveToMongo(){
        System.out.println("saving to mongodb");
    }
    public void saveToFile(){
        System.out.println("saving to file");
    }
}
public class OPC{
    public static void main(String args[]){
        ShoppingCart cart=new ShoppingCart();
        PrintInvoice invoice=new PrintInvoice(cart);
        SaveToDatabase db=new SaveToDatabase(cart);
        cart.addProduct(new Product("lenovo",1234));
        cart.addProduct(new Product("mac",2345));
        invoice.print();
        db.saveToSql();
        db.saveToFile();
    }
}