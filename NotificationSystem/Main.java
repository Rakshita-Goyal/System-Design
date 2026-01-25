package NotificationSystem;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
interface Notification{
String getContent();
}
class SimpleNotification implements Notification{
    private String text;
    SimpleNotification(String text){
        this.text=text;
    }
    @Override
  public  String getContent(){
        return text;
    }
}
//decorator
abstract class Decorator implements Notification {
      protected Notification notification;
 public Decorator(Notification n) {
        this.notification = n;
    }
}
class TimestampDecorator extends Decorator {
    public TimestampDecorator(Notification n) {
        super(n);
    }

    public String getContent() {
        return "[2025-04-13 14:22:00] " + notification.getContent();
    }
}
class SignatureDecorator extends Decorator {
    private String signature;

    public SignatureDecorator(Notification n, String sig) {
        super(n);
        this.signature = sig;
    }

    public String getContent() {
        return notification.getContent() + "\n-- " + signature + "\n\n";
    }
}
interface Observer{
void update();
}
interface Observable{
     void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface NotificationStrategy{
void sendNotification(String content);
}
class EmailStrategy implements NotificationStrategy {
    private String emailId;

    public EmailStrategy(String emailId) {
        this.emailId = emailId;
    }

    public void sendNotification(String content) {
        System.out.println("Sending email Notification to: " + emailId + "\n" + content);
    }
}
class SMSStrategy implements NotificationStrategy {
    private String mobileNumber;

    public SMSStrategy(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void sendNotification(String content) {
        System.out.println("Sending SMS Notification to: " + mobileNumber + "\n" + content);
    }
}

class PopUpStrategy implements NotificationStrategy {
    public void sendNotification(String content) {
        System.out.println("Sending Popup Notification: \n" + content);
    }
}

class NotificationObservable implements Observable{
  private List<Observer> observers = new ArrayList<>();
    private Notification currentNotification;
public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

     public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void setNotification(Notification notification) {
        this.currentNotification = notification;
        notifyObservers();
    }

    public Notification getNotification() {
        return currentNotification;
    }
     public String getNotificationContent() {
        return currentNotification.getContent();
    }

}
class Logger implements Observer{
 private NotificationObservable notificationObservable;

    public Logger(NotificationObservable observable) {
        this.notificationObservable = observable;
    }
public void update() {
        System.out.println("Logging New Notification : \n" + notificationObservable.getNotificationContent());
    }

}
class NotificationEngine implements Observer{
 private NotificationObservable notificationObservable;
    private List<NotificationStrategy> notificationStrategies = new ArrayList<>();

    public NotificationEngine(NotificationObservable observable) {
        this.notificationObservable = observable;
    }

    public void addNotificationStrategy(NotificationStrategy ns) {
        this.notificationStrategies.add(ns);
    }

    public void update() {
        String notificationContent = notificationObservable.getNotificationContent();
        for (NotificationStrategy strategy : notificationStrategies) {
            strategy.sendNotification(notificationContent);
        }
    }
}
//for client to interact and manage motifications 
class NotificationService{
private NotificationObservable observable;
    private static NotificationService instance;
    private List<Notification> notifications = new ArrayList<>();

private NotificationService() {
        observable = new NotificationObservable();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }
 public void sendNotification(Notification notification) {
        notifications.add(notification);
        observable.setNotification(notification);
    }
 public NotificationObservable getObservable() {
        return observable;
    }

}
public class Main{
    public static void main(String args[]){
        //System.out.println("hello");
        NotificationService notificationService = NotificationService.getInstance();
  NotificationObservable notificationObservable = notificationService.getObservable();
  Logger logger = new Logger(notificationObservable);
        NotificationEngine notificationEngine = new NotificationEngine(notificationObservable);
 notificationEngine.addNotificationStrategy(new EmailStrategy("random.person@gmail.com"));
        notificationEngine.addNotificationStrategy(new SMSStrategy("+91 9876543210"));
        notificationEngine.addNotificationStrategy(new PopUpStrategy());

 notificationObservable.addObserver(logger);
        notificationObservable.addObserver(notificationEngine);

        Notification notification = new SimpleNotification("Your order has been shipped!");
        notification = new TimestampDecorator(notification);
        notification = new SignatureDecorator(notification, "Customer Care");

        notificationService.sendNotification(notification);

    }
}