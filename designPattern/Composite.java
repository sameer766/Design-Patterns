package designPattern;

import java.util.ArrayList;
import java.util.List;


interface Component {

  void showPrice();
}

class Leaf implements Component {
  public Leaf(int price, String name) {
    this.price = price;
    this.name = name;
  }

  public int price;
  public String name;


  @Override
  public void showPrice() {
    System.out.println(name + "  " + price);
  }
}

class Composites implements Component {


  public Composites(String name) {
    this.name = name;
  }

  public String name;

  List<Component> components = new ArrayList<>();

  public void addComponent(Component c) {
    components.add(c);
  }


  @Override
  public void showPrice() {
    System.out.println(name);
    for (Component c : components) {
      c.showPrice();
    }
  }


  public static void main(String[] args) {
    Component hd = new Leaf(10, "HDD");
    Component mouse = new Leaf(20, "mOUSE");
    Composites ph = new Composites("Motherboard");
    Composites cabinet = new Composites("Computer");
    ph.addComponent(mouse);
    ph.addComponent(hd);
    cabinet.addComponent(ph);
    cabinet.showPrice();
  }
}
