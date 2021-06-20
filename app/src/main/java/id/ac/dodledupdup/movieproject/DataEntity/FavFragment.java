package id.ac.dodledupdup.movieproject.DataEntity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import id.ac.dodledupdup.movieproject.Database.MainContract;
import id.ac.dodledupdup.movieproject.Database.MainPresenter;
import id.ac.dodledupdup.movieproject.R;

public class FavFragment extends Fragment implements MainContract.view {

    private AppDatabase appDatabase;
    private MainPresenter presenter;
    //private RecyclerView.Adapter;
    private RecyclerView rvfav;

    public FavFragment() {
        // Required empty public constructor
    }
    public static FavFragment newInstance(String param1, String param2) {
        FavFragment fragment = new FavFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav, container, false);
    }

    @Override
    public void successAdd() {

    }

    @Override
    public void successDelete() {

    }

    @Override
    public void getData(List<DataFavorite> list) {

    }

    @Override
    public void deleteData(DataFavorite item) {

    }

    @Override
    public void onClick(View v) {

    }
}