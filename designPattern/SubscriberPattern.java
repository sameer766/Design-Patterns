package designPattern;

import java.util.ArrayList;
import java.util.List;

public class SubscriberPattern {
  public static void main(String[] args) {
    Channel channel=new Channel();
    Subscriber subscriber=new Subscriber("ram");
    Subscriber subscriber2=new Subscriber("shyam");
    channel.subscribe(subscriber);
    channel.subscribe(subscriber2);
    channel.unsubscribe(subscriber);
//    subscriber.subscribeChannel(channel);
//    subscriber2.subscribeChannel(channel);
    channel.upload("hi upload");
  }

}


class Subscriber {
  private String name;
  private Channel channel;

  Subscriber(String name) {
    this.name = name;
  }

  public void update() {
    System.out.println("hi, "+name+" Video uploaded");
  }

  public void subscribeChannel(Channel channel) {
    this.channel = channel;
  }
}

class Channel {
  private String channelName;
  private final List<Subscriber> subscriberList = new ArrayList<>();

  public void subscribe(Subscriber subscriber) {
    subscriberList.add(subscriber);
  }

  public void unsubscribe(Subscriber subscriber) {
    subscriberList.remove(subscriber);
  }

  public void notifySubscriber() {
    for (Subscriber subscriber : subscriberList) {
      subscriber.update();
    }

  }

  public void upload(String title) {
    this.channelName = title;
    notifySubscriber();
  }


}
