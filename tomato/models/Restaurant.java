package tomato.models;
import java.util.List;
import java.util.ArrayList;
public class Restuarent{
 
private int restaurantId;
    private String name;
    private String location;
    private List<MenuItem>menu=new ArrayList<MenuItem>();

public Restuarent(String name,String location){
    this.location=location;
    this.name=name;
}

 public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String loc) {
        this.location = loc;
    }
 
    public void addMenuItem(MenuItem item){
        menu.add(item);
    }
    public List<MenuItem>getMenu(){
        return menu;
    }
}