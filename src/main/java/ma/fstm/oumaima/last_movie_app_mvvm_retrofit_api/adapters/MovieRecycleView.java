package ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.Models.MovieModel;
import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.R;

public class MovieRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieModel> mMovies;
    private OnMovieListener onMovieListener;

    public MovieRecycleView(OnMovieListener onMovieListener)
    {
        this.onMovieListener=onMovieListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,parent,false);
        return new MovieViewHolder(view,onMovieListener);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        ((MovieViewHolder)holder).title.setText(mMovies.get(i).getTitle());
        ((MovieViewHolder)holder).release_date.setText(mMovies.get(i).getRelease_date());
        //((MovieViewHolder)holder).duration.setText(""+mMovies.get(i).getOriginale_langage());
        ((MovieViewHolder)holder).ratingBar.setRating((mMovies.get(i).getVote_average())/2);
        //glide:
        Glide.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500/"+mMovies.get(i).getPoster_path()).into(((MovieViewHolder)holder).imageView);

    }

    @Override
    public int getItemCount() {
        if(mMovies !=null)
        {
            return mMovies.size();
        }
        return 0;
    }

    public void setmMovies(List<MovieModel> mMovies) {
        this.mMovies = mMovies;
        notifyDataSetChanged();
    }

    public MovieModel getSelectedMovie(int position)
    {
        if(mMovies!=null)
        {
            if(mMovies.size()>0)
            {
                return mMovies.get(position);
            }
        }
        return null;

    }




}
