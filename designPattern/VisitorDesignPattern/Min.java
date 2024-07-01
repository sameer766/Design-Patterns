package all_projects.src.designPattern.VisitorDesignPattern;

 interface RoomElement  {

    public void accept(RoomVisitor e);
}


public class Min{
    public static void main(String[] args) {
        RoomElement r=new SingleRoomElement();
        RoomElement r1=new DoubleRoomElement();
        RoomPricingVisitor pricingVisitor=new RoomPricingVisitor();
        r.accept(pricingVisitor);

        RoomMaintenanceVisitor maintenanceVisitor=new RoomMaintenanceVisitor();
        r1.accept(maintenanceVisitor);
    }
}


class SingleRoomElement implements RoomElement {
    int price=0;
    @Override
    public void accept(RoomVisitor e) {
        e.visit(this);
    }
}



class DoubleRoomElement implements RoomElement {
    int price=0;
    @Override
    public void accept(RoomVisitor e) {
        e.visit(this );
    }
}




interface RoomVisitor {
    public void visit(SingleRoomElement e);

    void visit(DoubleRoomElement e);

}

class RoomPricingVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoomElement e) {
        e.price = 100;
        System.out.println("pricing for single room" +e.price);
    }

    @Override
    public void visit(DoubleRoomElement e) {
        e.price = 200;
        System.out.println("pricing for double room" +e.price);
    }
}


class RoomMaintenanceVisitor implements RoomVisitor {
    @Override
    public void visit(SingleRoomElement e) {
        System.out.println("maintenance for single room");
    }

    @Override
    public void visit(DoubleRoomElement e) {
        System.out.println("maintenance for double room" +e.price);
    }
}


