package all_projects.src.designPattern.service;

public class EmailObserverImpl implements PriceTrackerObservers{
    PriceTrackerObservable priceTrackerObservable;
    EmailObserverImpl(PriceTrackerObservable p){
        this.priceTrackerObservable=p;
    }
    @Override
    public void update() {

        System.out.println("sending email value updated to " + priceTrackerObservable.getData());
    }
}
