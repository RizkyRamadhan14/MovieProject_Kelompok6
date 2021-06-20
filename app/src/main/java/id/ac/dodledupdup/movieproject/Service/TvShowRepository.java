package id.ac.dodledupdup.movieproject.Service;

import id.ac.dodledupdup.movieproject.Model.TvShow.TvShowResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TvShowRepository {
    @GET("3/discover/tv?api_key=4ce64defc740cfe50c9af126f459a7f0")
    Call<TvShowResponse> getTvShow();
}
