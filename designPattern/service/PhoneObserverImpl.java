package all_projects.src.designPattern.service;

public class PhoneObserverImpl implements PriceTrackerObservers{


    PriceTrackerObservable priceTrackerObservable;
    PhoneObserverImpl(PriceTrackerObservable p){
        this.priceTrackerObservable=p;
    }


    @Override
    public void update() {
        System.out.println("sending phone value updated to " + priceTrackerObservable.getData());
    }
}
