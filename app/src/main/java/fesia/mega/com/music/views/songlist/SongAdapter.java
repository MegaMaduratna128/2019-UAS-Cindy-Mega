package fesia.mega.com.music.views.songlist;

import android.content.Context;
import android.content.Intent;

import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import fesia.mega.com.music.R;
import fesia.mega.com.music.api.model.Sport;
import fesia.mega.com.music.views.songdetail.SongDetailView;


public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder> {

    Context context;
    private List<Sport> sportList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout row;
        ImageView strSportThumb;
        TextView txtSportName;
//        TextView txtDescription;

        MyViewHolder(View view) {
            super(view);
            row = (LinearLayout) view.findViewById(R.id.sport_item_row);
            strSportThumb = (ImageView) view.findViewById(R.id.picturesport);
            txtSportName = (TextView) view.findViewById(R.id.sport_name);
//            txtDescription = (TextView) view.findViewById(R.id.artist_name_and_genre);
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detail = new Intent(context, SongDetailView.class);
                    detail.putExtra("sport", (Parcelable) sportList.get(getAdapterPosition()));
                    context.startActivity(detail);
                }
            });
        }
    }

    SongAdapter(Context context, List<Sport> sportList) {
        this.context = context;
        this.sportList = sportList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Sport sport = sportList.get(position);

        final String strSportThumb = sport.getStrSportThumb();
        Glide.with(context).load(strSportThumb).placeholder(R.drawable.ic_logo).into(holder.strSportThumb);

        holder.txtSportName.setText(sport.getStrSport());
//        holder.txtDescription.setText(sport.getStrSportDescription());
    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }
}