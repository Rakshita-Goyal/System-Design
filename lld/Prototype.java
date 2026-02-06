//Prototype Pattern = create new objects by cloning existing objects
package lld;

interface Cloneable {
   Cloneable clone();
}

class NPC implements Cloneable {
 public String name;
   public int health;
   public int attack;
   public int defense;

    public NPC(String name, int health, int attack, int defense) {
      
       this.name = name; 
       this.health = health; 
       this.attack = attack; 
       this.defense = defense;
       System.out.println("Setting up template NPC '" + name + "'");
   }

 public NPC(NPC other) {
       name = other.name;
       health = other.health;
       attack = other.attack;
       defense = other.defense;
       System.out.println("Cloning NPC '" + name + "'");
   }

 public Cloneable clone() {
       return new NPC(this);
   }

  public void setName(String n) { 
       name = n;
   }
   public void setHealth(int h) { 
       health = h;
   }
   public void setAttack(int a) {
        attack = a; 
   }
   public void setDefense(int d){ 
       defense = d;
   }

 public void describe() {
       System.out.println("NPC " + name + " [HP=" + health + " ATK=" + attack 
            + " DEF=" + defense + "]");
   }


}

public class Prototype {
   public static void main(String[] args) {

 NPC alien = new NPC("Alien", 30, 5, 2);
       

        NPC alienCopied1 = (NPC)alien.clone();

          alienCopied1.describe();
       
       NPC alienCopied2 = (NPC)alien.clone();
       alienCopied2.setName("Powerful Alien");
       alienCopied2.setHealth(50);
       alienCopied2.describe();
       
   }
}