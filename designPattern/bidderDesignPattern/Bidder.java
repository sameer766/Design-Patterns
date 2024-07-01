package all_projects.src.designPattern.bidderDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Bidder implements Collegue {


    AuctionMediator auctionMediator;

    Bidder(AuctionMediator auctionMediator, String name){
        this.auctionMediator=auctionMediator;
        this.name=name;
    }
    private String name;


    public void addBid(int amount){
        auctionMediator.addBid(this, amount);
    }

    public void receiveBidInfo(Collegue collegue, int amount){
        System.out.println(collegue.getName()+" places a bid of amount " + amount );
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}



interface Collegue {
    public void addBid(int amount);
    public void receiveBidInfo(Collegue collegue, int amount);
    public String getName();



}

interface AuctionMediator{
    public void addBidder(Bidder bidder);

    void addBid(Collegue bid, int amount);
}

class AuctionMediatorImpl implements AuctionMediator{


    List<Collegue> collegueList=new ArrayList<>();


    @Override
    public void addBidder(Bidder bidder) {
        collegueList.add(bidder);
    }

    @Override
    public void addBid(Collegue bid, int amount) {
        for(Collegue collegue:collegueList){
            if(collegue != bid){
                collegue.receiveBidInfo(collegue, amount);
            }
        }
    }


    public static void main(String[] args) {


        AuctionMediator auctionMediator=new AuctionMediatorImpl();
        Bidder collegue=new Bidder(auctionMediator, "name");
        Bidder collegue2=new Bidder(auctionMediator, "name2");
        auctionMediator.addBidder(collegue);
        auctionMediator.addBidder(collegue2);
        collegue.addBid(209);
    }
}