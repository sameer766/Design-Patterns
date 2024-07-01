package designPattern;

class Vechilee {
  private final String engine;
  private final int wheel;

  private final int airbags;

  public String getEngine() {
    return engine;
  }

  public int getWheel() {
    return wheel;
  }

  public int getAirbags() {
    return airbags;
  }

  public Vechilee(VechileBuilder vechileBuilder) {
    this.engine = vechileBuilder.engine;
    this.airbags = vechileBuilder.airbags;
    this.wheel = vechileBuilder.wheel;
  }

  public static class VechileBuilder {
    private String engine;
    private int airbags;
    private int wheel;

    public VechileBuilder(String engine, int wheel) {
      this.engine = engine;
      this.wheel = wheel;
    }

    public VechileBuilder setAirbags(int airbags) {
      this.airbags = airbags;
      return this;
    }

    public Vechilee build() {
      return new Vechilee(this);
    }
  }
}

public class Builders {
  public static void main(String[] args) {

    Vechilee bike=new Vechilee.VechileBuilder("220cc",1).build();
    Vechilee bcdhbc = new Vechilee.VechileBuilder("bcdhbc", 4).setAirbags(4).setAirbags(3).build();

    System.out.println(bcdhbc);
    Vechilee car=
            new Vechilee.VechileBuilder("2200cc",2).setAirbags(1).build();
    System.out.println(car.getAirbags());
    System.out.println(bike.getEngine());
  }

}
