package all_projects.src.designPattern.BridgeDesignPattern;

 interface BreatheImplmentor {
    public void breathe();
}

public class Main{
    public static void main(String[] args) {
        LivingThings livingThings= new Fish(new LandBreatheImpl());
        livingThings.breathe();
    }
}
abstract class  LivingThings {
    BreatheImplmentor breatheImplmentor;
    LivingThings(BreatheImplmentor breatheImplmentor){
        this.breatheImplmentor=breatheImplmentor;
    }

    public void breathe(){
        System.out.println("default");
    }

}

class Dog extends LivingThings{
    Dog(BreatheImplmentor breatheImplmentor) {
        super(breatheImplmentor);
    }

    @Override
    public void breathe() {
        System.out.println("EHDSHFHV");
    }
}

class Fish extends LivingThings{
    Fish(BreatheImplmentor breatheImplmentor) {
        super(breatheImplmentor);
    }

    @Override
    public void breathe() {
        System.out.println("cbhdbbcb");
    }
}

class LandBreatheImpl implements BreatheImplmentor{

    @Override
    public void breathe() {
        System.out.println("land");
    }
}

class AirBreatheImpl implements BreatheImplmentor{

    @Override
    public void breathe() {

    }
}

