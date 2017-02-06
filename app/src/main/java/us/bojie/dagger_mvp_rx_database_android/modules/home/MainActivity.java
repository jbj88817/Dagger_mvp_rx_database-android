package us.bojie.dagger_mvp_rx_database_android.modules.home;

import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import us.bojie.dagger_mvp_rx_database_android.R;
import us.bojie.dagger_mvp_rx_database_android.base.BaseActivity;
import us.bojie.dagger_mvp_rx_database_android.di.components.DaggerCakeComponent;
import us.bojie.dagger_mvp_rx_database_android.mvp.presenter.CakePresenter;
import us.bojie.dagger_mvp_rx_database_android.mvp.view.MainView;

public class MainActivity extends BaseActivity implements MainView {

    @Inject protected CakePresenter mPresenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        mPresenter.getCakes();
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerCakeComponent.builder().build();
    }
}
