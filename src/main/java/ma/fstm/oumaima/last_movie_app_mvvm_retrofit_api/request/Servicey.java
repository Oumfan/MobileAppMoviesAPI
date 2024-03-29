package ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.request;

import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.Credentials;

import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.MovieApi;
import ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api.request.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class Servicey {
    private static Retrofit.Builder retrofitBuilder=
            new Retrofit.Builder()
                    .baseUrl(Credentials.Base_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit=retrofitBuilder.build();
    private static MovieApi movieApi= retrofit.create(MovieApi.class);
    public static MovieApi getMovieApi()
    {
        return movieApi;
    }


}

