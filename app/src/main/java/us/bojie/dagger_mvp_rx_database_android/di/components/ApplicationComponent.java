package us.bojie.dagger_mvp_rx_database_android.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;
import us.bojie.dagger_mvp_rx_database_android.di.module.ApplicationModule;

/**
 * Created by bojiejiang on 2/5/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Retrofit exposeRetrofit();

    Context exposeContext();
}
