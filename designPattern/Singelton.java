package designPattern;

public class Singelton {

  private static Singelton singelton;

  private Singelton() {

  }

  public static synchronized Singelton getInstance() {
    if (singelton == null) {
      synchronized (Singelton.class)
      {
        singelton = new Singelton();
      }
    }
    return singelton;
  }


  public static void main(String[] args) {
    Singelton singelton = Singelton.getInstance();
    System.out.println(singelton);
    Singelton singelton1 = Singelton.getInstance();
    System.out.println(singelton1);
  }
}
