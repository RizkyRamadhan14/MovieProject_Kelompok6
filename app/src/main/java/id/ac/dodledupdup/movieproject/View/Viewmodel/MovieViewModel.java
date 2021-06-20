package id.ac.dodledupdup.movieproject.View.Viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import id.ac.dodledupdup.movieproject.Model.Movie.MovieDiscoverResponse;
import id.ac.dodledupdup.movieproject.Model.Movie.MovieDiscoverResultsItem;
import id.ac.dodledupdup.movieproject.Service.ApiMain;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<MovieDiscoverResultsItem>> listDiscoverMovie = new MutableLiveData<>();

    public void setMovieDiscover(){
        if(this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiMovie().getMovieDiscover().enqueue(new Callback<MovieDiscoverResponse>() {
            @Override
            public void onResponse(Call<MovieDiscoverResponse> call, Response<MovieDiscoverResponse> response) {
                MovieDiscoverResponse responseDiscover = response.body();
                if(responseDiscover!=null&& responseDiscover.getResults()!=null){
                    ArrayList<MovieDiscoverResultsItem> movieDiscoverItems = responseDiscover.getResults();
                    listDiscoverMovie.postValue(movieDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<MovieDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<MovieDiscoverResultsItem>> getMoviesDiscover(){
        return listDiscoverMovie;
    }
}
