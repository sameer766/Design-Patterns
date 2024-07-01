package designPattern;

public class FactoryDesignPattern {
  public static Vechile getObject(String vechile, int wheel) {
    if ("Car".equals(vechile)) {
      return new Car(wheel);
    }
    if ("Cycle".equals(vechile)) {
      return new Cycle(wheel);
    }
    return null;
  }

  public static void main(String[] args) {
    Car vechile = (Car) getObject("Car", 4);
    Vechile vechile1=getObject("Cycle",2);
    System.out.println(vechile.getWheel());
    System.out.println(vechile.getColour());
    System.out.println(vechile1.getWheel());
  }

}

abstract class Vechile {
  public int wheel;
  public abstract  int getWheel();
}

class Car extends Vechile {
  private final int wheel;

  Car(int wheel) {
    this.wheel = wheel;
  }

  public String getColour()
  {
    return "Red";
  }

  @Override
  public int getWheel() {
    return wheel;
  }
}

class Cycle extends Vechile {
  private final int wheel;

  Cycle(int wheel) {
    this.wheel = wheel;
  }

  @Override
  public int getWheel() {
    return wheel;
  }


}


