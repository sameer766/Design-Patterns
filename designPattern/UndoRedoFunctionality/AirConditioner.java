package all_projects.src.designPattern.UndoRedoFunctionality;

public class AirConditioner {

    private int temp;
    private  boolean isOn;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }


    public void turnOnAC() {
        System.out.println("turning on ac");
        setOn(true);
    }

    public void turnOffAC() {
        System.out.println("turning off ac");
        setOn(false);
    }
}
