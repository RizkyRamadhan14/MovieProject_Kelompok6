package id.ac.dodledupdup.movieproject.Service;

import id.ac.dodledupdup.movieproject.Model.Movie.MovieDiscoverResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieRepository {
    @GET("3/movie/top_rated?api_key=4ce64defc740cfe50c9af126f459a7f0")
    Call<MovieDiscoverResponse> getMovieDiscover();
}
