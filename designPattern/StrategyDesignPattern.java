package designPattern;

public class StrategyDesignPattern {


    public static void main(String[] args) {
        Vehicle vehicle = new NormalVehicle();
        vehicle.drive();
        Vehicle vehicl2 = new FerrariVehicle();
        vehicl2.drive();

    }
}

class NormalVehicle extends Vehicle {

    NormalVehicle() {
        super(new NormalDriving());
    }
}

class FerrariVehicle extends Vehicle {
    FerrariVehicle() {
        super(new SpecialDriving());
    }

}

class Vehicle {
    private DrivingStrategy drivingStrategy;
    Vehicle(DrivingStrategy strategy){
        this.drivingStrategy = strategy;
    }

    public void drive(){
        drivingStrategy.drive();
    }
}

interface DrivingStrategy{
    public void drive();
}

class NormalDriving implements DrivingStrategy{

    @Override
    public void drive() {
        System.out.println("Normal Driving");
    }
}

class SpecialDriving implements DrivingStrategy{

    @Override
    public void drive() {
        System.out.println("Special Driving");
    }
}





