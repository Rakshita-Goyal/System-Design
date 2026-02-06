package lld;


class NPC {
   public String name;
   public int health;
   public int attack;
   public int defense;

   public NPC(String name, int health, int attack, int defense) {

       this.name = name;
       this.health = health;
       this.attack = attack;
       this.defense = defense;
       System.out.println("Creating NPC '" + name + "' [HP:" + health + ", ATK:" 
            + attack + ", DEF:" + defense + "]");
   }
   
   public void describe() {
       System.out.println("  NPC: " + name + " | HP=" + health + " ATK=" + attack
            + " DEF=" + defense);
   }
}
public class PrototypeWithout {
   public static void main(String[] args) {

NPC alien = new NPC("Alien", 30, 5, 2);
       alien.describe();
       NPC alien2 = new NPC("Powerful Alien", 30, 5, 5);
       alien2.describe();
       
   }
}