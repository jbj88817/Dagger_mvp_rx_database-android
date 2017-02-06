package us.bojie.dagger_mvp_rx_database_android.di.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import us.bojie.dagger_mvp_rx_database_android.api.CakeApiService;
import us.bojie.dagger_mvp_rx_database_android.di.scope.PerActivity;
import us.bojie.dagger_mvp_rx_database_android.mvp.view.MainView;

/**
 * Created by bojiejiang on 2/5/17.
 */

@Module
public class CakeModule {

    private MainView mView;

    public CakeModule(MainView view) {
        mView = view;
    }

    @PerActivity
    @Provides
    CakeApiService provideCakeApiService(Retrofit retrofit) {
        return retrofit.create(CakeApiService.class);
    }

    @PerActivity
    @Provides
    MainView provideView() {
        return mView;
    }
}
