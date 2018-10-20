package saurabh.test.com.proficiencyexercise;

import android.app.Application;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

/**
 * Created by saurabha on 18/10/18.
 */
public class ProficiencyExerciseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // BEGIN_INCLUDE(Configuration of Piccaso to cache images)
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);

    }
}
