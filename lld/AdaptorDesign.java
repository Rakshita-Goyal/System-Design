//Adapter Pattern allows two incompatible interfaces to work together by
//  converting one interface into another that the client expects.
// Client  →  Target (expected interface)
//               ↑
//            Adapter
//               ↑
//           Adaptee (existing class)

//adapter converts the interface of a class into a class into another interface that client excepts 
//adapter lets the classes work together that couldnt because of incompatible interface 

package lld;
class VlcPlayer{
     public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

interface MediaPlayer{
    void play(String file);
}
class Adapter implements MediaPlayer{
    private VlcPlayer vlc;
    public Adapter (VlcPlayer vlc){
        this.vlc=vlc;
    }
    @Override
  public   void play(String file){
        vlc.playVlc(file);
    }
}
public class AdaptorDesign{
    public static void main(String args[]){
MediaPlayer player=new Adapter(new VlcPlayer());
player.play("hello");
    }
}
