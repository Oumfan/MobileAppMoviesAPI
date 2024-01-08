package ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.Models.MovieModel;
import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.adapters.MovieRecycleView;
import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.adapters.OnMovieListener;
import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.request.Servicey;
import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.response.MovieSearchResponse;
import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.viewmodels.MovieListViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity implements OnMovieListener {
    private RecyclerView recycleView;
    private MovieRecycleView movieRecycleAdapter;
    private MovieListViewModel movieListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        //ToolBar
        Toolbar toolbar = findViewById(R.id.toolbar);
          setSupportActionBar(toolbar);
        //Search view:
        SetupSearchView();

        recycleView = findViewById(R.id.recycleView);
        movieListViewModel=new  ViewModelProvider(this).get(MovieListViewModel.class);
        ConfigureRecyclerView();
        ObserveAnyChange();

    }



    //observing any data change:
    private void ObserveAnyChange()
    {
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                //Observing for any data change:
                if(movieModels !=null)
                {
                    for(MovieModel movieModel:movieModels)
                    {
                        movieRecycleAdapter.setmMovies(movieModels);

                    }
                }
            }
        });
    }


    //5-Initializing recycleView & adding data to it:
    private void ConfigureRecyclerView()
    {
        movieRecycleAdapter=new MovieRecycleView(this);
        recycleView.setAdapter(movieRecycleAdapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onMovieClick(int position) {
        // Toast.makeText(this,"The position "+position,Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,MovieDetails.class);
        intent.putExtra("movie",movieRecycleAdapter.getSelectedMovie(position));
        startActivity(intent);


    }

    @Override
    public void onCategoryClick(String category) {

    }

    //Get data from search view  & query the api to get the results
    private void SetupSearchView() {
        final SearchView searchView=findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                movieListViewModel.SearchMoviesApi(query,1);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



    }



}