package fesia.mega.com.music.views.songdetail;

import fesia.mega.com.music.api.model.Track;

public class SongDetailContract {
    interface View {
        void displayMessage(String message);

        void displayTrack(Track track);
    }
}
