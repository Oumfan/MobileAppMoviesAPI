package ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api;

import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.Models.MovieModel;
import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.response.MovieSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    //Search for movies:
    @GET("/3/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") int page
    );

    //search by movie's Id:
    @GET("/3/movie{movie_id}?")
    Call<MovieModel> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );

}
