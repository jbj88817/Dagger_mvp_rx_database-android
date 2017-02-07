package us.bojie.dagger_mvp_rx_database_android.mvp.presenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import us.bojie.dagger_mvp_rx_database_android.api.CakeApiService;
import us.bojie.dagger_mvp_rx_database_android.base.BasePresenter;
import us.bojie.dagger_mvp_rx_database_android.mapper.CakeMapper;
import us.bojie.dagger_mvp_rx_database_android.mvp.model.Cake;
import us.bojie.dagger_mvp_rx_database_android.mvp.model.CakeResponse;
import us.bojie.dagger_mvp_rx_database_android.mvp.model.Storage;
import us.bojie.dagger_mvp_rx_database_android.mvp.view.MainView;

/**
 * Created by bojiejiang on 2/6/17.
 */

public class CakePresenter extends BasePresenter<MainView> implements Observer<CakeResponse> {

    @Inject protected CakeApiService mApiService;
    @Inject protected CakeMapper mCakeMapper;
    @Inject protected Storage mStorage;

    @Inject
    public CakePresenter() {

    }

    public void getCakes() {
        getView().onShowDialog("Loading cakes...");
        Observable<CakeResponse> cakeResponseObservable = mApiService.getCakes();
        subscribe(cakeResponseObservable, this);
    }

    @Override
    public void onCompleted() {
        getView().onHideDialog();
        getView().onShowToast("Cakes loading complete!");
    }

    @Override
    public void onError(Throwable e) {
        getView().onHideDialog();
        getView().onShowToast("Error loading cakes");
    }

    @Override
    public void onNext(CakeResponse cakeResponse) {
        List<Cake> cakes = mCakeMapper.mapCakes(mStorage, cakeResponse);
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }

    public void getCakesFromDatabase() {
        List<Cake> cakes = mStorage.getSavedCakes();
        getView().onClearItems();
        getView().onCakeLoaded(cakes);
    }
}
