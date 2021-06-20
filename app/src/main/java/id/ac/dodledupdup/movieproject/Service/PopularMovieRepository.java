package id.ac.dodledupdup.movieproject.Service;

import id.ac.dodledupdup.movieproject.Model.Popular.PopularMoviesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PopularMovieRepository {
    @GET("3/movie/popular?api_key=4ce64defc740cfe50c9af126f459a7f0")
    Call<PopularMoviesResponse> getPopularMovies();
}
