package ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {

    private static AppExecutors instance;

    public static AppExecutors getInstance()
    {
        if(instance==null)
        {
            instance=new AppExecutors();
        }
        return instance;
    }

    private final ScheduledExecutorService mNetworkIO= Executors.newScheduledThreadPool(3);

    public ScheduledExecutorService networkIO()
    {
        return mNetworkIO;
    }


}
