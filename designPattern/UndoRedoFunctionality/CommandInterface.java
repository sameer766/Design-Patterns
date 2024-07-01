package all_projects.src.designPattern.UndoRedoFunctionality;

public interface CommandInterface {
  public void execute();

    public void undoExecute();
}

class TurnOnAcCommand implements CommandInterface{

    AirConditioner ac;
    public TurnOnAcCommand(AirConditioner airConditioner) {
        this.ac=airConditioner;
    }

    @Override
    public void execute() {
        ac.turnOnAC();
    }

    @Override
    public void undoExecute() {
        ac.turnOffAC();
    }
}

class TurnOffAcCommand implements CommandInterface{
    AirConditioner ac;

    public TurnOffAcCommand(AirConditioner airConditioner) {
        this.ac=airConditioner;
    }

    @Override
    public void execute() {
        ac.turnOffAC();
    }

    @Override
    public void undoExecute() {
        ac.turnOnAC();
    }
}

class TurnOffBulb implements CommandInterface{
    Bulb  bulb;

    public TurnOffBulb(Bulb bulb) {
        this.bulb=bulb;
    }

    @Override
    public void execute() {
        bulb.turnOffBulb();
    }

    @Override
    public void undoExecute() {
        bulb.turnOnBulb();
    }
}