package all_projects.src.designPattern;

public class Vechicle {

    DrivingStrategy drivingStrategy;

    Vechicle(DrivingStrategy drivingStrategy){
        this.drivingStrategy=drivingStrategy;
    }

    public void drive(){
        drivingStrategy.drive();
    }
}

class Maruti extends Vechicle {

    @Override
    public void drive() {
        new Vechicle(new FastDriving()).drive();
    }
}


class Maruti extends Vechicle {

    Maruti(){
        super(new FastDriving());
    }
    @Override
    public void drive() {
        new Vechicle(new FastDriving()).drive();
    }
}


class Ferrari extends Vechicle {

    @Override
    public void drive() {
        new Vechicle(new FastDriving()).drive();
    }
}




public interface DrivingStrategy{
     void drive();
}

public class FastDriving implements  DrivingStrategy{

    @Override
    public void drive() {
        System.out.println("cdhbhcbdhbc");
    }
}

public class FastEngine implements  DrivingStrategy{

    @Override
    public void drive() {
        System.out.println("cdhbhcbdhbc");
    }
}