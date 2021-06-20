package id.ac.dodledupdup.movieproject.View.Viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import id.ac.dodledupdup.movieproject.Model.TvShow.TvShowResponse;
import id.ac.dodledupdup.movieproject.Model.TvShow.TvShowResultsItem;
import id.ac.dodledupdup.movieproject.Service.ApiMain;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<TvShowResultsItem>> listDiscoverTvShow = new MutableLiveData<>();

    public void setTvShow(){
        if(this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiTvShow().getTvShow().enqueue(new Callback<TvShowResponse>() {
            @Override
            public void onResponse(Call<TvShowResponse> call, Response<TvShowResponse> response) {
                TvShowResponse responseDiscover = response.body();
                if(responseDiscover!=null&& responseDiscover.getResults()!=null){
                    ArrayList<TvShowResultsItem> tvShowItems = responseDiscover.getResults();
                    listDiscoverTvShow.postValue(tvShowItems);
                }
            }

            @Override
            public void onFailure(Call<TvShowResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<TvShowResultsItem>> getTvShow(){
        return listDiscoverTvShow;
    }
}
