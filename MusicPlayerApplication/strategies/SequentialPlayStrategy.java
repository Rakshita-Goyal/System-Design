package MusicPlayerApplication.strategies;

import MusicPlayerApplication.models.Playlist;
import MusicPlayerApplication.models.Song;

public class SequentialPlayStrategy implements PlayStrategy{
     private Playlist currentPlaylist;
    private int currentIndex;
    private Song currentSong;
   public SequentialPlayStrategy() {
        currentPlaylist = null;
        currentIndex = -1;
        currentSong=null;

    }
@Override
public Song next(){
if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }

        currentIndex+=1;
        return currentPlaylist.getSongs().get(currentIndex);
}
@Override
public Song previous(){
 if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        currentIndex-=1;
        return currentPlaylist.getSongs().get(currentIndex);

}
@Override
public boolean hasNext(){
return ((currentIndex + 1) < currentPlaylist.getSize());
}
@Override
public boolean hasPrevious(){
 return (currentIndex - 1 > 0);
}
@Override
  public  void setPlaylist(Playlist playlist){
this.currentPlaylist=playlist;
currentIndex=-1;
    }
   

}