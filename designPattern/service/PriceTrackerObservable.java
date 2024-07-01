package all_projects.src.designPattern.service;

public interface PriceTrackerObservable {

    public void add(PriceTrackerObservers p);
    public void remove(PriceTrackerObservers p);
    public void notifyObs();
    public void setData(int price);

    public int getData();

//    List<PriceTrackerObservable>
//    private int price;
}
