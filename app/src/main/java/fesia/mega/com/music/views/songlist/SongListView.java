package fesia.mega.com.music.views.songlist;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.ArrayList;
import java.util.List;

import fesia.mega.com.music.R;
import fesia.mega.com.music.api.model.Sport;

public class SongListView extends AppCompatActivity implements SongListContract.View {

    Context context;
    LinearLayout main;
    TextView txtNoSports;
    ShimmerRecyclerView listSports;

    private List<Sport> dataSports = new ArrayList<>();
    private SongAdapter adapter;

    SportListPresenter presenter;

    public SongListView() {
        presenter = new SportListPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        context = SongListView.this;

        main = (LinearLayout) findViewById(R.id.sport_list_main);
        txtNoSports  = (TextView) findViewById(R.id.txtNoSports);
        listSports = (ShimmerRecyclerView) findViewById(R.id.listSports);

        adapter = new SongAdapter(context, dataSports);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        listSports.setLayoutManager(mLayoutManager);
        listSports.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        listSports.setItemAnimator(new DefaultItemAnimator());
        listSports.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search for Songs, Artists & More");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    public void search(final String strTerm) {
        txtNoSports.setVisibility(View.GONE);
        listSports.setVisibility(View.VISIBLE);

        dataSports.clear();
        adapter.notifyDataSetChanged();

        setLoadingIndicator(true);
        listSports.postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.getSports(strTerm);
            }
        }, 2000);
    }

    @Override
    public void displaySports(List<Sport> dataSports) {
        setLoadingIndicator(false);
        this.dataSports.clear();
        this.dataSports.addAll(dataSports);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void displayMessage(String message) {
        setLoadingIndicator(false);
        Snackbar.make(main, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setLoadingIndicator(boolean isLoading) {
        if (isLoading) {
            listSports.showShimmerAdapter();
        } else {
            listSports.hideShimmerAdapter();
        }
    }
}