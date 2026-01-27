package MusicPlayerApplication.strategies;

import MusicPlayerApplication.models.Playlist;
import MusicPlayerApplication.models.Song;


public interface PlayStrategy{
  public  Song next();
   public boolean hasNext();
  public  Song previous();
 public   boolean hasPrevious();
   public void setPlaylist(Playlist playlist);
    default void addToNext(Song song) {};

}