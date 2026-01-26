//for multiple buttons
package lld;

//what each button can do 
interface Command{
     void execute();
    void undo();
}
//receivers
class Light {
    public void on()  {
        System.out.println("Light is ON");
    }
    public void off() {
        System.out.println("Light is OFF");
    }
}

class Fan {
    public void on()  {
        System.out.println("Fan is ON");
    }
    public void off() {
        System.out.println("Fan is OFF");
    }
}
//concrete commands
class LightCommand implements Command {
    private Light light;

    public LightCommand(Light l) {
        this.light = l;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
class FanCommand implements Command {
    private Fan fan;

    public FanCommand(Fan f) {
        this.fan = f;
    }

    public void execute() {
        fan.on();
    }

    public void undo() {
        fan.off();
    }
}
//remote/invoker
class RemoteController {
 private static final int numButtons = 2;
private Command[] buttons;//commands (buttons )
    private boolean[] buttonPressed;
public RemoteController(){
 buttons = new Command[numButtons];
        buttonPressed = new boolean[numButtons];

for (int i = 0; i < numButtons; i++) {
            buttons[i] = null;
            buttonPressed[i] = false;  // false = off, true = on
        }

}
public void setCommand(Command cmd,int idx){
 if (idx >= 0 && idx < numButtons) {
            buttons[idx] = cmd;
            buttonPressed[idx] = false;
        }
}
public void pressButton(int idx ){
 if (idx >= 0 && idx < numButtons && buttons[idx] != null) {
            if (!buttonPressed[idx]) {
                buttons[idx].execute();
            } else {
                buttons[idx].undo();
            }
            buttonPressed[idx] = !buttonPressed[idx];
        } else {
            System.out.println("No command assigned at button " + idx);
        }
    
}}

public class CommandDesignPattern {
    public static void main(String args[]){

 Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();

        RemoteController remote = new RemoteController();

 remote.setCommand(new LightCommand(livingRoomLight),0);
        remote.setCommand(new FanCommand(ceilingFan),1);

        // remote.pressButton(0);  // ON
        // remote.pressButton(0);  // OFF

        // remote.pressButton(1);  // ON
        // remote.pressButton(1);  // OFF

for(int i=0;i<2;i++){
    remote.pressButton(i);
    remote.pressButton(i);
}
//remote.pressButton(2);

    }
}