package all_projects.src.designPattern.service;

import java.util.ArrayList;
import java.util.List;

public class PriceTrackerObservableImpl implements  PriceTrackerObservable{

    int price;
    List<PriceTrackerObservers> priceTrackerObserverLists =new ArrayList<>();
    @Override
    public void add(PriceTrackerObservers p) {
        priceTrackerObserverLists.add(p);
    }

    @Override
    public void remove(PriceTrackerObservers p) {
        priceTrackerObserverLists.remove(p);
    }

    @Override
    public void notifyObs() {
        for(PriceTrackerObservers p: priceTrackerObserverLists){
            p.update();
        }
    }

    @Override
    public int getData() {
        return price;
    }

    @Override
    public void setData(int data) {
        this.price=data;
        notifyObs();
    }
}
