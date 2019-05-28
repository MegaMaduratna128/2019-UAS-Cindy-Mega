package fesia.mega.com.music.views.songdetail;

import fesia.mega.com.music.api.model.Sport;

public class SongDetailContract {
    interface View {
        void displayMessage(String message);

        void displaySport(Sport sport);
    }
}
