package MusicPlayerApplication;

import MusicPlayerApplication.enums.DeviceType;
import MusicPlayerApplication.enums.PlayStrategyType;

public class Main {
    public static void main(String[] args) {

MusicPlayerApplication application = MusicPlayerApplication.getInstance();

 application.createSongInLibrary("Kesariya", "Arijit Singh", "/music/kesariya.mp3");
            application.createSongInLibrary("Chaiyya Chaiyya", "Sukhwinder Singh", "/music/chaiyya_chaiyya.mp3");
            application.createSongInLibrary("Tum Hi Ho", "Arijit Singh", "/music/tum_hi_ho.mp3");
            application.createSongInLibrary("Jai Ho", "A. R. Rahman", "/music/jai_ho.mp3");
            application.createSongInLibrary("Zinda", "Siddharth Mahadevan", "/music/zinda.mp3");

            application.createPlaylist("Bollywood Vibes");
            application.addSongToPlaylist("Bollywood Vibes", "Kesariya");
            application.addSongToPlaylist("Bollywood Vibes", "Chaiyya Chaiyya");
            application.addSongToPlaylist("Bollywood Vibes", "Tum Hi Ho");
            application.addSongToPlaylist("Bollywood Vibes", "Jai Ho");

           
            application.connectAudioDevice(DeviceType.BLUETOOTH);


            application.playSingleSong("Zinda");
            application.pauseCurrentSong("Zinda");
            application.playSingleSong("Zinda");


            application.selectPlayStrategy(PlayStrategyType.SEQUENTIAL);
            application.loadPlaylist("Bollywood Vibes");
            application.playAllTracksInPlaylist();

              application.selectPlayStrategy(PlayStrategyType.RANDOM);
            application.loadPlaylist("Bollywood Vibes");
            application.playAllTracksInPlaylist();


            application.selectPlayStrategy(PlayStrategyType.CUSTOM_QUEUE);
            application.loadPlaylist("Bollywood Vibes");
            application.queueSongNext("Kesariya");
            application.queueSongNext("Tum Hi Ho");
            application.playAllTracksInPlaylist();



              application.playPreviousTrackInPlaylist();
            application.playPreviousTrackInPlaylist();
    }
    
 }