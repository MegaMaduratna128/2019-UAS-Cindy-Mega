package fesia.mega.com.music.views.songlist;

import java.util.List;

import fesia.mega.com.music.api.APIService;
import fesia.mega.com.music.api.ServiceFactory;
import fesia.mega.com.music.api.model.Sport;
import fesia.mega.com.music.api.model.SportModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportListPresenter implements SongListContract.Presenter {

    private SongListContract.View songListView;

    SportListPresenter(SongListContract.View songListView) {
        this.songListView = songListView;
    }

    @Override
    public void getSports(String term) {
        APIService service = ServiceFactory.getInstance();
        Call<SportModel> sportModelCall = service.getSports(term);
        sportModelCall.enqueue(new Callback<SportModel>() {
            @Override
            public void onResponse(Call<SportModel> call, Response<SportModel> response) {
                List<Sport> spotModel = response.body().getSports();
            }

            @Override
            public void onFailure(Call<SportModel> call, Throwable t) {
                songListView.displayMessage("No sport found, Try again.");
            }
        });
    }
}
