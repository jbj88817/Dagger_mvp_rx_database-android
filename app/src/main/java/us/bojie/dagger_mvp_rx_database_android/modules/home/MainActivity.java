package us.bojie.dagger_mvp_rx_database_android.modules.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import us.bojie.dagger_mvp_rx_database_android.R;
import us.bojie.dagger_mvp_rx_database_android.base.BaseActivity;
import us.bojie.dagger_mvp_rx_database_android.di.components.DaggerCakeComponent;
import us.bojie.dagger_mvp_rx_database_android.di.module.CakeModule;
import us.bojie.dagger_mvp_rx_database_android.modules.home.adapter.CakeAdapter;
import us.bojie.dagger_mvp_rx_database_android.mvp.model.Cake;
import us.bojie.dagger_mvp_rx_database_android.mvp.presenter.CakePresenter;
import us.bojie.dagger_mvp_rx_database_android.mvp.view.MainView;

public class MainActivity extends BaseActivity implements MainView {

    private CakeAdapter mCakeAdapter;

    @Inject
    protected CakePresenter mPresenter;

    @Bind(R.id.cake_list)
    protected RecyclerView mCakeList;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        initializeList();
        mPresenter.getCakes();
    }

    private void initializeList() {
        mCakeList.setHasFixedSize(true);
        mCakeList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mCakeAdapter = new CakeAdapter(getLayoutInflater());
        mCakeList.setAdapter(mCakeAdapter);
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerCakeComponent
                .builder()
                .applicationComponent(getApplicationComponent())
                .cakeModule(new CakeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onCakeLoaded(List<Cake> cakes) {
        mCakeAdapter.addCakes(cakes);
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
