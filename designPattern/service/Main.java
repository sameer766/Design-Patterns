package all_projects.src.designPattern.service;

public class Main {
    public static void main(String[] args) {



        PriceTrackerObservable priceTrackerObservable=new PriceTrackerObservableImpl();
       priceTrackerObservable.add(new EmailObserverImpl(priceTrackerObservable));
        priceTrackerObservable.add(new PhoneObserverImpl(priceTrackerObservable));
        priceTrackerObservable.setData(20);
    }
}
