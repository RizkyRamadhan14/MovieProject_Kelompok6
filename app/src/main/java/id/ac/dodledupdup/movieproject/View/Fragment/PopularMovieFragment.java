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

import id.ac.dodledupdup.movieproject.Adapter.PopularMovieAdapter;
import id.ac.dodledupdup.movieproject.Model.Popular.PopularMovieResultsItem;
import id.ac.dodledupdup.movieproject.R;
import id.ac.dodledupdup.movieproject.View.Viewmodel.PopularMovieViewModel;


public class PopularMovieFragment extends Fragment {

    private PopularMovieAdapter popularMovieAdapter;
    private RecyclerView rvMovieDiscover;
    private PopularMovieViewModel popularMovieViewModel;

    public PopularMovieFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_movie, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        popularMovieAdapter = new PopularMovieAdapter(getContext());
        popularMovieAdapter.notifyDataSetChanged();

        rvMovieDiscover = view.findViewById(R.id.fragmentpopularmovie_rv);
        rvMovieDiscover.setLayoutManager(new GridLayoutManager(getContext(),2));

        popularMovieViewModel = new ViewModelProvider(this).get(PopularMovieViewModel.class);
        popularMovieViewModel.setPopularMovie();
        popularMovieViewModel.getPopularMovie().observe(this,getPopularMovie);

        rvMovieDiscover.setAdapter(popularMovieAdapter);
    }

    private Observer<ArrayList<PopularMovieResultsItem>> getPopularMovie = new Observer<ArrayList<PopularMovieResultsItem>>() {
        @Override
        public void onChanged(ArrayList<PopularMovieResultsItem> popularMovieResultsItems) {
            if (popularMovieResultsItems!=null){
                popularMovieAdapter.setData(popularMovieResultsItems);
            }
        }
    };
}