//minimal code changes
//we enter in loop of more and more inheritance 
//to avoid it 
//Srategy design pattern: 
//defines family of algos, put them in seprate classes so they can change at run time 
//change inheritance to "has-a" relationship  
//theclient and strategy ,strategy has interfaces and concrete classes
package lld;
interface Talkable{
public void talk();
}
interface Walkable{
public void walk();
}
interface Flyable{
public void fly();
}
interface Projectable{
    public void project();
}
class ProjectAi implements Projectable{
    public void project(){
        System.out.println("projection via ai");
    }
}
class ProjectGui implements Projectable{
    public void project(){
        System.out.println("project via gui");
    }
}
class CanWalk implements Walkable{
@Override
public void walk() {
        System.out.println("Walking normally...");
    }

}
class NoWalk implements Walkable{
@Override
public void walk() {
        System.out.println("no walking...");
    }
}
class CanTalk implements Talkable{
    @Override
public void talk() {
        System.out.println("Talking normally...");
    }
}
class NoTalk implements Talkable{
 @Override
public void talk() {
        System.out.println("no talking ...");
    }
}
class CanFly implements Flyable{
 @Override
public void fly() {
        System.out.println("flying normally...");
    }
}
class NoFly implements Flyable{
 @Override
public void fly() {
        System.out.println("no flying ...");
    }
}
abstract class Robot{
    protected Walkable walkable;
    protected Talkable talkable;
    protected Flyable flyable;
    protected Projectable projectable;
    public Robot(Walkable walkable,Talkable talkable,Flyable flyable,Projectable projectable){
        this.walkable=walkable;
        this.talkable=talkable;
        this.flyable=flyable;
        this.projectable=projectable;
    }
    public void walk(){
        walkable.walk();
    }
public void talk(){
    talkable.talk();
}
public void fly(){
    flyable.fly();
}
public void project(){
    projectable.project();
}

}
class CompanionRobot extends Robot{
 public CompanionRobot(Walkable w, Talkable t, Flyable f,Projectable p) {
        super(w, t, f,p);
    }
}
class WorkerRobot extends Robot{
 public WorkerRobot(Walkable w, Talkable t, Flyable f,Projectable p) {
        super(w, t, f,p);
    }
}

public class DesignPattern{
    public static void main(String args[]){
        Walkable walkable=new CanWalk();
        Flyable flyable=new CanFly();
        Talkable talkable=new NoTalk();
        Projectable projectable=new ProjectAi();
Robot robo=new CompanionRobot(walkable,talkable,flyable,projectable);
robo.walk();
robo.talk();
robo.fly();
robo.project();
    }
}