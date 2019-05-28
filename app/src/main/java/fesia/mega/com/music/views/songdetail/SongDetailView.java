package fesia.mega.com.music.views.songdetail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import fesia.mega.com.music.R;
import fesia.mega.com.music.api.model.Sport;

public class SongDetailView extends AppCompatActivity implements SongDetailContract.View {

    Context context;
    LinearLayout main;
    ImageView strSportThumb;
    TextView txtSportName, txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_detail);

        context = SongDetailView.this;

        main = (LinearLayout) findViewById(R.id.song_detail_main);
        strSportThumb = (ImageView) findViewById(R.id.imgArtworkDetail);
        txtSportName = (TextView) findViewById(R.id.artist_name_detail);
        txtDescription = (TextView) findViewById(R.id.genre_detail);

        try {
            displaySport((Sport) getIntent().getSerializableExtra("sport"));
        } catch (Exception e) {
            displayMessage("Problem while getting song info, Try again.");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(main, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void displaySport(Sport sport) {

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(sport.getStrSport());
        }

        String artworkUrl = sport.getStrSportThumb();
        Glide.with(context).load(artworkUrl).placeholder(R.drawable.ic_logo).into(strSportThumb);

        txtSportName.setText(sport.getStrSport());
        txtDescription.setText(sport.getStrSportDescription());

//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        Uri video = Uri.parse(sport.getPreviewUrl());
//        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(video);
//        videoView.start();
    }
}