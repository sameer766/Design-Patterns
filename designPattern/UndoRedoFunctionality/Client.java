package all_projects.src.designPattern.UndoRedoFunctionality;

public class Client {

    public static void main(String[] args) {

        AirConditioner airConditioner=new AirConditioner();
        RemoteControl remoteControl=new RemoteControl( new TurnOffAcCommand(airConditioner));

        Bulb bulb=new Bulb();
        RemoteControl remoteControl2=new RemoteControl( new TurnOffBulb(bulb));
        remoteControl.pressButton();;
        remoteControl2.pressButton();;
        remoteControl.undoPress();
        remoteControl.undoPress();
    }
}
