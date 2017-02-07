package us.bojie.dagger_mvp_rx_database_android.mvp.view;

import java.util.List;

import us.bojie.dagger_mvp_rx_database_android.base.BaseView;
import us.bojie.dagger_mvp_rx_database_android.mvp.model.Cake;

/**
 * Created by bojiejiang on 2/6/17.
 */

public interface MainView extends BaseView {
    void onCakeLoaded(List<Cake> cakes);

    void onShowDialog(String message);

    void onHideDialog();

    void onShowToast(String message);
}
