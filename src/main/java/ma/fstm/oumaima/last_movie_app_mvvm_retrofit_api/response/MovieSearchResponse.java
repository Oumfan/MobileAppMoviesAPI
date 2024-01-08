package ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.response;

import android.graphics.Movie;

import com.google.gson.annotations.SerializedName;

import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.Models.MovieModel;
import com.google.gson.annotations.Expose;

import java.util.List;

public class MovieSearchResponse {
//this class is 4 getting multiple movies:movie list (popular ones)

    @SerializedName("total_results")
    @Expose()
    private int total_count;

    @SerializedName("results")
    @Expose()
    private List<MovieModel> movies;

    public int getTotal_count() {
        return total_count;
    }

    public List<MovieModel> getMovies()
    {
        return  movies;
    }

    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", movies=" + movies +
                "}";
    }
}
