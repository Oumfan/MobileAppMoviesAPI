package ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.Models;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class MovieModel implements Parcelable {
    private String title;
    private String poster_path;
    private String release_date;
    private int movie_id;
    private float vote_average;
    @SerializedName("overview")
    private String movie_overview;
    private String original_langage;

    public MovieModel(String title, String poster_path, String release_date, int movie_id, float vote_average, String movie_overview, String originale_langage) {
        this.title = title;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.movie_id = movie_id;
        this.vote_average = vote_average;
        this.movie_overview = movie_overview;
        this.original_langage = originale_langage;
    }

    protected MovieModel(Parcel in) {
        title = in.readString();
        poster_path = in.readString();
        release_date = in.readString();
        movie_id = in.readInt();
        vote_average = in.readFloat();
        movie_overview = in.readString();
        original_langage=in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getMovie_overview() {
        return movie_overview;
    }

    public String getPoster_path() {
        return poster_path;
    }


    public String getRelease_date() {
        return release_date;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getOriginale_langage() {
        return original_langage;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(poster_path);
        dest.writeString(release_date);
        dest.writeInt(movie_id);
        dest.writeFloat(vote_average);
        dest.writeString(movie_overview);
        dest.writeString(original_langage);
    }

    @Override
    public String toString() {
        return "MovieModel{" +
                "title='" + title +
                ", poster_path='" + poster_path +
                ", release_date='" + release_date +
                ", movie_id=" + movie_id +
                ", vote_average=" + vote_average +
                ", movie_overview='" + movie_overview +
                ", originale_langage='" + original_langage +
                "}";
    }
}
