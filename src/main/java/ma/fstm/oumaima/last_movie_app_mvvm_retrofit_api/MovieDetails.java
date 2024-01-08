package ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.Models.MovieModel;

public class MovieDetails extends AppCompatActivity {
    private ImageView imageViewDetails;
    private TextView titleDetails, descDetails;
    private RatingBar ratingBarDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        imageViewDetails = findViewById(R.id.imageView_details);
        titleDetails = findViewById(R.id.textView_title_details);
        descDetails = findViewById(R.id.textView_desc);
        ratingBarDetails = findViewById(R.id.ratingBar_details);
        GetDataFromInternet();


    }

    private void GetDataFromInternet() {
        if (getIntent().hasExtra("movie")) {
            MovieModel movieModel = getIntent().getParcelableExtra("movie");
            titleDetails.setText(movieModel.getTitle());
            descDetails.setText(movieModel.getMovie_overview());
            ratingBarDetails.setRating(movieModel.getVote_average()/2);

            Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+movieModel.getPoster_path()).into(imageViewDetails);

        }

    }
}