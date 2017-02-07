package us.bojie.dagger_mvp_rx_database_android.application;

import android.app.Application;

import us.bojie.dagger_mvp_rx_database_android.di.components.ApplicationComponent;
import us.bojie.dagger_mvp_rx_database_android.di.components.DaggerApplicationComponent;
import us.bojie.dagger_mvp_rx_database_android.di.module.ApplicationModule;

/**
 * Created by bojiejiang on 2/5/17.
 */

public class CakeApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this, "https://gist.githubusercontent.com"))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
