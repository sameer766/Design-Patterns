package all_projects.src.designPattern.UndoRedoFunctionality;

public class Bulb {

    private  boolean isOn;


    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }


    public void turnOnBulb() {
        System.out.println("turning on bulb");
        setOn(true);
    }

    public void turnOffBulb() {
        System.out.println("turning off bulb");
        setOn(false);
    }
}
