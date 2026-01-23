//youtube : channel which subscribe ,unsubscribe,notify the users (means upload the videos)
//subsriber is present (will get notified)
//users are the subscribers

package lld;
import java.util.ArrayList;
import java.util.List;

abstract class Subscriber{
public abstract void notify(String video);
}
class Users extends Subscriber{
 private String name;

    public Users(String name) {
        this.name = name;
    }

@Override
public void notify(String video){
     System.out.println(name + " notified: New video uploaded → " + video);
}

}
interface Channel{
 public void subscribe(Subscriber subscriber );
 public void unsubscribe(Subscriber subscriber);
 public void notificationToUsers();
}
class Youtube implements Channel{
private List<Subscriber> subscribers = new ArrayList<>();
private String video;
 @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

public void upload(String video){
    this.video=video;
    notificationToUsers();
}
    @Override
    public void notificationToUsers(){
        for(Subscriber S:subscribers){
            S.notify(video);
        }
    }
}
public class YoutubeObserver{
    public static void main (String args[]){
Youtube channel=new Youtube();
Subscriber user1=new Users("rakshita");
Subscriber user2=new Users("aditi");
channel.subscribe(user1);
channel.subscribe(user2);
channel.upload("hello");
    }
}