package all_projects.src.designPattern;

public class NulPattern {

    public static void main(String[] args) {
        Vehcile vehcile = VehicleFactory.getVehicle(0);
        vehcile.capacity();
    }

}
class VehicleFactory{
    public static Vehcile getVehicle(int capacity){
        if(capacity > 0){
            return new Bus();
        }
        return new Null();
    }
}

interface Vehcile{
    public int capacity();
}

class Bus implements Vehcile{

    @Override
    public int capacity() {
        return 100;
    }
}

class Null implements Vehcile{

    @Override
    public int capacity() {
        return 0;
    }
}
