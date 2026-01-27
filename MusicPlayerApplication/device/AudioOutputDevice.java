package MusicPlayerApplication.device;

import MusicPlayerApplication.models.Song;

public interface AudioOutputDevice {
    void playAudio(Song song);
}