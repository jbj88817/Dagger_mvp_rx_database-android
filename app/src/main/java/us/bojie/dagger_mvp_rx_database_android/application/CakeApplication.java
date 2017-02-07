package us.bojie.dagger_mvp_rx_database_android.application;

import android.app.Application;

import us.bojie.dagger_mvp_rx_database_android.di.components.ApplicationComponent;
import us.bojie.dagger_mvp_rx_database_android.di.components.DaggerApplicationComponent;

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
        mApplicationComponent = DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
