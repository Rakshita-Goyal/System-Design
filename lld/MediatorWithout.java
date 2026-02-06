package lld;

import java.util.*;

class User {
    private String name;
    private List<User> peers;
    private List<String> mutedUsers;
    
 public User(String n) {
        name = n;
        peers = new ArrayList<>();
        mutedUsers = new ArrayList<>();
    }


    public void addPeer(User u) {
        peers.add(u);
    }

     public void mute(String userToMute) {
        mutedUsers.add(userToMute);
    }

    public void send(String msg) {
        System.out.println("[" + name + " broadcasts]: " + msg);
        for (User peer : peers) {
            
        
            if(!peer.isMuted(name)) {
                peer.receive(name, msg);
            }
        }
    }

public boolean isMuted(String userName) {
        for(String name : mutedUsers) {
            if(name.equals(userName)) {
                return true;
            }
        }
        return false;
    }


     public void sendTo(User target, String msg) {
        System.out.println("[" + name + "→" + target.name + "]: " + msg);
        if(!target.isMuted(name)) {
            target.receive(name, msg);
        }
    }
    
    public void receive(String from, String msg) {
        System.out.println("    " + name + " got from " + from + ": " + msg);
    }



}
public class MediatorWithout {
    public static void main(String[] args) {


        User user1 = new User("Rohan");
        User user2 = new User("Neha");
        User user3 = new User("Mohan");

        user1.addPeer(user2);   
        user2.addPeer(user1);

        user1.addPeer(user3);   
        user3.addPeer(user1);
        
        user2.addPeer(user3); 
        user3.addPeer(user2);
   
        user1.mute("Mohan");
       
        user1.send("Hello everyone!");
        user3.sendTo(user2, "Hey Neha!");

    }
}