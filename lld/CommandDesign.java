// Command Pattern encapsulates a request as an object, so that you can:
// parameterize clients with different requests
// queue or log requests
// support undo/redo

// Command (interface) → declares execute()
// ConcreteCommand → implements command, calls receiver
// Receiver → actual object that does work
// Invoker → triggers command
// Client → creates and sets command

// Client → creates Command → gives to Invoker
// Invoker → calls execute()
// Command → calls Receiver
// Receiver → does actual work

//real life : any application with undo ,keyboard shortcut (like brigtness less or more )

//defination :encapsulate the request object ,letting you parameterize clients with different request ,queue,log request and support unduable operations 

package lld;
interface Command {
    void execute();
}

class TV {
    public void turnOn() {
        System.out.println("TV is ON");
    }

    public void turnOff() {
        System.out.println("TV is OFF");
    }
}
class TurnOnTVCommand implements Command {
 private TV tv;

    public TurnOnTVCommand(TV tv) {
        this.tv = tv;
    }

     public void execute() {
        tv.turnOn();
    }
}
class TurnOffTVCommand implements Command {
 private TV tv;

    public TurnOffTVCommand(TV tv) {
        this.tv = tv;
    }

     public void execute() {
        tv.turnOff();
    }
}
class RemoteControl {
private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

   public void pressButton() {
        command.execute();
    }
}
public class CommandDesign {
    public static void main(String args[]){
   TV tv = new TV();
 Command onCommand = new TurnOnTVCommand(tv);
        Command offCommand = new TurnOffTVCommand(tv);
        RemoteControl remote = new RemoteControl();
 remote.setCommand(onCommand);
        remote.pressButton(); 

        remote.setCommand(offCommand);
        remote.pressButton();
    }
}