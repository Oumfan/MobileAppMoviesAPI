package ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.Models.MovieModel;
import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.repositories.MovieRepository;

public class MovieListViewModel extends ViewModel {

    private MovieRepository movieRepository;

    /* public MovieListViewModel(MutableLiveData<List<MovieModel>> mMovies) {
         this.mMovies = mMovies;
     }
     */
    public MovieListViewModel()
    {
        movieRepository=MovieRepository.getInstance();
    }


    public LiveData<List<MovieModel>> getMovies() {
        return movieRepository.getMovies();
    }
    //3-calling the method in view-model:
    public void SearchMoviesApi(String query, int pageNumber)
    {
        movieRepository.SearchMoviesApi(query,pageNumber);
    }




}
