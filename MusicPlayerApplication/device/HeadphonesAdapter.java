package MusicPlayerApplication.device;

import MusicPlayerApplication.models.Song;
import MusicPlayerApplication.external.HeadphonesAPI;


public class HeadphonesAdapter implements AudioOutputDevice{
private HeadphonesAPI headphonesApi;
 public HeadphonesAdapter(HeadphonesAPI api) {
        this.headphonesApi = api;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        headphonesApi.playSoundViaHeadphones(payload);
    }
}