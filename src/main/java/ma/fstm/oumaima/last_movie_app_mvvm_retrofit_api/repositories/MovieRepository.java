package ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.repositories;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.Models.MovieModel;
import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.request.MovieApiClient;

public class MovieRepository {

    private  static MovieRepository instance;
    //Live data:
    private MovieApiClient movieApiClient;
    public static MovieRepository getInstance()
    {
        if(instance == null)
        {
            instance=new MovieRepository();
        }
        return instance;
    }
    private MovieRepository()
    {
        movieApiClient=MovieApiClient.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies()
    {
        return movieApiClient.getMovies();
    }

    //2- Calling the method in repository:
    public void SearchMoviesApi(String query, int pageNumber)
    {
        movieApiClient.SearchMoviesAPi(query,pageNumber);
    }



}
