package us.bojie.dagger_mvp_rx_database_android.api;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;
import us.bojie.dagger_mvp_rx_database_android.mvp.model.CakeResponse;

/**
 * Created by bojiejiang on 2/5/17.
 */

public interface CakeApiService {

    @GET("/filippella/a728a34822a3bc7add98e477a4057b69/raw/310d712e87941f569074a63fedb675d2b611342a/cakes")
    Observable<CakeResponse> getCakes();

    @GET("/filippella/a728a34822a3bc7add98e477a4057b69/raw/310d712e87941f569074a63fedb675d2b611342a/cakes")
    Call<CakeResponse> getTheCakes();
}
