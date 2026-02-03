package lld;

import java.util.*;

interface TreeType{
    void draw(int x,int y);
}
class ConcreteTreeType implements TreeType{
    private String name;
    private String color;
    ConcreteTreeType(String name,String color){
        this.name=name;
        this.color=color;
    }
    public void draw(int x,int y){
         System.out.println("Drawing " + name + " tree of color " + color +
                           " at (" + x + "," + y + ")");
    }
}
class TreeFactory{
     private static Map<String, TreeType> treeMap = new HashMap<>();
     public static TreeType getTreeType(String name,String color){
  String key = name + "_" + color;

        if (!treeMap.containsKey(key)) {
            treeMap.put(key, new ConcreteTreeType(name, color));
        }
return treeMap.get(key);
     }
}
class Tree {
    int x, y;
    TreeType type; 

    Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    void draw() {
        type.draw(x, y);
    }
}
public class FlyWeightTree{
    public static void main(String args[]){
TreeType oakGreen = TreeFactory.getTreeType("Oak", "Green");
        TreeType oakGreen2 = TreeFactory.getTreeType("Oak", "Green");

        System.out.println(oakGreen == oakGreen2); // true (same object)

        Tree t1 = new Tree(10, 20, oakGreen);
        Tree t2 = new Tree(30, 40, oakGreen2);

        t1.draw();
        t2.draw();
    }
}