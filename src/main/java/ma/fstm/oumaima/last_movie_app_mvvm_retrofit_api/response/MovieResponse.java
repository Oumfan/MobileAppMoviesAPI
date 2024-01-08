package ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.Models.MovieModel;

public class MovieResponse {
    //for finding the movie object :this class is for single movie request:
    @SerializedName("results")
    @Expose
    private MovieModel movie;
    public MovieModel getMovie(){
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +"}";
    }
}
