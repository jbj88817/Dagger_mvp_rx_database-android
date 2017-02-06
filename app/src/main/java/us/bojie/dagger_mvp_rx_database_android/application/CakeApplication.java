package us.bojie.dagger_mvp_rx_database_android.application;

import android.app.Application;

import us.bojie.dagger_mvp_rx_database_android.di.components.DaggerApplicationComponent;

/**
 * Created by bojiejiang on 2/5/17.
 */

public class CakeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        DaggerApplicationComponent.builder().build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
