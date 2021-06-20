package id.ac.dodledupdup.movieproject.View.Viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import id.ac.dodledupdup.movieproject.Model.Popular.PopularMovieResultsItem;
import id.ac.dodledupdup.movieproject.Model.Popular.PopularMoviesResponse;
import id.ac.dodledupdup.movieproject.Service.ApiMain;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularMovieViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<PopularMovieResultsItem>> listDiscoverPopularMovie = new MutableLiveData<>();

    public void setPopularMovie(){
        if(this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiPopularMovies().getPopularMovies().enqueue(new Callback<PopularMoviesResponse>() {
            @Override
            public void onResponse(Call<PopularMoviesResponse> call, Response<PopularMoviesResponse> response) {
                PopularMoviesResponse responseDiscover = response.body();
                if(responseDiscover!=null&& responseDiscover.getResults()!=null){
                    ArrayList<PopularMovieResultsItem> popularMovieItem = responseDiscover.getResults();
                    listDiscoverPopularMovie.postValue(popularMovieItem);
                }
            }

            @Override
            public void onFailure(Call<PopularMoviesResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<PopularMovieResultsItem>> getPopularMovie(){
        return listDiscoverPopularMovie;
    }
}
