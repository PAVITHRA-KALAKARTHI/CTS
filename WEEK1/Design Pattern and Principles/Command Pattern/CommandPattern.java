public class CommandPattern {
    public static void main(String[] args) {
        // Receiver object
        Light light = new Light();
        
        // Creating command objects
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        
        // Invoker object
        RemoteControl remote = new RemoteControl();
        
        // Execute ON command
        remote.setCommand(lightOn);
        remote.pressButton();
        
        // Execute OFF command
        remote.setCommand(lightOff);
        remote.pressButton();
        
        System.out.println("Command Pattern Implemented Successfully");
    }
}
// Command Interface
interface Command {
    void execute();
}
// Receiver Class
class Light {
    public void turnOn() {
        System.out.println("Light is turned ON");
    }
    public void turnOff() {
        System.out.println("Light is turned OFF" );
    }
}

// Concrete Command - ON
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOn();
    }
}
// Concrete Command - OFF
class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOff();
    }
}
// Invoker Class
class RemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        command.execute();
    }
}
