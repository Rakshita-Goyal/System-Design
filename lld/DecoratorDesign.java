//at runtime change functionalitiesn, not via inheritance (bacuase it increases child classes)
//use of composition
//Decorator Pattern allows adding new behavior to an object dynamically without modifying its existing class.

package lld;
interface Character{
 String getAbilities();
}
class Mario implements Character{
@Override
public String getAbilities(){
    return "mario";
}
}
class Lugi implements Character{
@Override
public String getAbilities(){
    return "lugi";
}
}
abstract class Decorator implements Character{
protected Character character;
public Decorator(Character character){
    this.character=character;
}
}
class HeightUp extends Decorator{
public HeightUp(Character character){
    super(character);
}
@Override
public String getAbilities(){
    return character.getAbilities()+"heightup";
}
}
class GunPower extends Decorator{

public GunPower(Character character){
   super(character);
}
@Override
public String getAbilities(){
    return character.getAbilities()+"gun power";
}
}
public class DecoratorDesign {
    public static void main(String args[]){
Character character=new Mario();
character.getAbilities();
character=new HeightUp(character);//or 
character=new HeightUp(new GunPower(character));//we can have the loop of the calling (like ecursion )
System.out.println(character.getAbilities());
    }
}