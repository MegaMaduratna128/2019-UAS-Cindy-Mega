package fesia.mega.com.music.views.songlist;

import java.util.List;

import fesia.mega.com.music.api.model.Sport;

public class SongListContract {
    interface View {
        void displayMessage(String message);

        void setLoadingIndicator(boolean isLoading);

        void displaySports(List<Sport> dataSports);
    }

    interface Presenter {
        void getSports(String term);
    }
}
