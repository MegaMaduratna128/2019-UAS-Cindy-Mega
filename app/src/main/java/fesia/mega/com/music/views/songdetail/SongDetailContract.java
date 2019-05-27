package fesia.mega.com.music.views.songdetail;

public class SongDetailContract {
    interface View {
        void displayMessage(String message);

        void displayTrack(Track track);
    }
}
