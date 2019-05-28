package fesia.mega.com.music.api;

import fesia.mega.com.music.api.model.SportModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIService {

    @GET("search")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<SportModel> getSports(@Query("term") String term);
}