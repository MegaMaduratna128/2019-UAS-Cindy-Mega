package fesia.mega.com.music.views.songlist;

import java.util.List;

import fesia.mega.com.music.api.model.Track;

public class SongListContract {
    interface View {
        void displayMessage(String message);

        void setLoadingIndicator(boolean isLoading);

        void displayTracks(List<Track> dataTracks);
    }

    interface Presenter {
        void getTracks(String term);
    }
}
