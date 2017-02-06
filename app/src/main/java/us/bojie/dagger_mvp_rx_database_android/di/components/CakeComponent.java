package us.bojie.dagger_mvp_rx_database_android.di.components;

import dagger.Component;
import us.bojie.dagger_mvp_rx_database_android.di.module.CakeModule;
import us.bojie.dagger_mvp_rx_database_android.di.scope.PerActivity;
import us.bojie.dagger_mvp_rx_database_android.modules.home.MainActivity;

/**
 * Created by bojiejiang on 2/5/17.
 */

@PerActivity
@Component(modules = CakeModule.class, dependencies = ApplicationComponent.class)
public interface CakeComponent {

    void inject(MainActivity activity);
}
