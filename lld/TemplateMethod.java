//It defines the skeleton of an algorithm in a base class and lets subclasses change some steps without changing the overall structure.

package lld;
abstract class Beverage{
     public final void makeBeverage() {
boilWater();
addMainIngredients();
pourInCup();
addExtras();
     }
     void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

abstract void addMainIngredients();
abstract void addExtras();
}
class Tea extends Beverage {

    void addMainIngredients() {
        System.out.println("Adding tea leaves");
    }

    void addExtras() {
        System.out.println("Adding lemon");
    }
}
class Coffee extends Beverage {

    void addMainIngredients() {
        System.out.println("Adding coffee powder");
    }

    void addExtras() {
        System.out.println("Adding milk and sugar");
    }
}

public class TemplateMethod{
    public static void main(String args[]){
 Beverage tea = new Tea();
        tea.makeBeverage();
        Beverage coffee = new Coffee();
        coffee.makeBeverage();
    }
}