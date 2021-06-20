package id.ac.dodledupdup.movieproject.View.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.ac.dodledupdup.movieproject.Adapter.TvShowAdapter;
import id.ac.dodledupdup.movieproject.Model.TvShow.TvShowResultsItem;
import id.ac.dodledupdup.movieproject.R;
import id.ac.dodledupdup.movieproject.View.Viewmodel.TvShowViewModel;


public class TvShowFragment extends Fragment {

    private TvShowAdapter tvShowAdapter;
    private RecyclerView rvTvShow;
    private TvShowViewModel tvshowViewModel;

    public TvShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvShowAdapter = new TvShowAdapter(getContext());
        tvShowAdapter.notifyDataSetChanged();

        rvTvShow = view.findViewById(R.id.fragmenttvshow_rv);
        rvTvShow.setLayoutManager(new GridLayoutManager(getContext(),2));

        tvshowViewModel = new ViewModelProvider(this).get(TvShowViewModel.class);
        tvshowViewModel.setTvShow();
        tvshowViewModel.getTvShow().observe(this,getTvShow);

        rvTvShow.setAdapter(tvShowAdapter);
    }

    private Observer<ArrayList<TvShowResultsItem>> getTvShow = new Observer<ArrayList<TvShowResultsItem>>() {
        @Override
        public void onChanged(ArrayList<TvShowResultsItem> tvShowResultsItems) {
            if (tvShowResultsItems!=null){
                tvShowAdapter.setData(tvShowResultsItems);
            }
        }
    };
}