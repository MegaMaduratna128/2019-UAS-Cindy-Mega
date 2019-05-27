package fesia.mega.com.music.views.songlist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder> {

    @NonNull
    @Override
    public SongAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout row;
        ImageView imgTrackArtwork;
        TextView txtTrackName, txtArtistNameNGenre, txtPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            row = (LinearLayout) view.findViewById(R.id.song_item_row);
            imgTrackArtwork = (ImageView) view.findViewById(R.id.artwork);
            txtTrackName = (TextView) view.findViewById(R.id.track_name);
            txtArtistNameNGenre = (TextView) view.findViewById(R.id.artist_name_and_genre);
            txtPrice = (TextView) view.findViewById(R.id.price);
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detail = new Intent(context, SongDetailView.class);
                    detail.putExtra("track", trackList.get(getAdapterPosition()));
                    context.startActivity(detail);
                }
            });
        }
    }
}
