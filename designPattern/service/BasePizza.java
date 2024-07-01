package all_projects.src.designPattern.service;

public abstract class BasePizza {

    public int price;
    public abstract int getPrice();
}

class MPizz extends BasePizza{


    @Override
    public int getPrice() {
        return 100;
    }
}

class VPizz extends BasePizza{

    @Override
    public int getPrice() {
        return  200;
    }
}

abstract class Topping extends BasePizza{


}

class JTopping extends Topping{


    BasePizza pizza;
    JTopping(BasePizza bn) {
       this.pizza=bn;
    }


    @Override
    public int getPrice() {
        return pizza.getPrice() + 30;
    }
}



class J2Topping extends Topping{

    BasePizza pizza;
    public J2Topping(BasePizza bn) {
        this.pizza = bn;
    }

    @Override
    public int getPrice() {
        return  pizza.getPrice()  + 60;
    }
    public static void main(String[] args) {

        Topping topping = new J2Topping(new MPizz());
        System.out.println(topping.getPrice());
    }
}


