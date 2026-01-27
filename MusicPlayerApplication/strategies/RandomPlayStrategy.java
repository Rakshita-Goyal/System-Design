package MusicPlayerApplication.strategies;

import MusicPlayerApplication.models.Playlist;
import MusicPlayerApplication.models.Song;
import java.util.*;

public class RandomPlayStrategy implements PlayStrategy {

private Playlist currentPlaylist;
    private List<Song> remainingSongs;
    private Stack<Song> history;
    private Random random;

    public RandomPlayStrategy() {
        currentPlaylist = null;
        random = new Random();
    }

@Override
    public void setPlaylist(Playlist playlist){
this.currentPlaylist = playlist;
        if (currentPlaylist == null || currentPlaylist.getSize() == 0) return;

history=new Stack<Song>();
remainingSongs = new ArrayList<Song>(currentPlaylist.getSongs());

    }

    @Override
  public  Song next(){
 if (currentPlaylist == null || currentPlaylist.getSize() == 0) {
            throw new RuntimeException("No playlist loaded or playlist is empty.");
        }
        if (remainingSongs.isEmpty()) {
            throw new RuntimeException("No songs left to play");
        }

int ind=random.nextInt(remainingSongs.size());
Song currentSong=remainingSongs.get(ind );

int lastIndex = remainingSongs.size() - 1;
remainingSongs.set(ind, remainingSongs.get(lastIndex));
        remainingSongs.remove(lastIndex);

history.push(currentSong);
        return currentSong;
    }


    @Override
  public  Song previous(){
 if (history.isEmpty()) {
            throw new RuntimeException("No previous song available.");
        }
         Song song = history.pop();
        return song;
    }
    @Override
 public   boolean hasNext(){
  return currentPlaylist != null && !remainingSongs.isEmpty();
    }
    @Override
  public  boolean hasPrevious(){
return history.size() > 0;
    }
    


}