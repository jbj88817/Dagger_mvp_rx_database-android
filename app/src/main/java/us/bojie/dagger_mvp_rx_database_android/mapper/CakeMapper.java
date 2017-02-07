package us.bojie.dagger_mvp_rx_database_android.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import us.bojie.dagger_mvp_rx_database_android.mvp.model.Cake;
import us.bojie.dagger_mvp_rx_database_android.mvp.model.CakeResponse;
import us.bojie.dagger_mvp_rx_database_android.mvp.model.CakeResponseCakes;
import us.bojie.dagger_mvp_rx_database_android.mvp.model.Storage;

/**
 * Created by bojiejiang on 2/6/17.
 */

public class CakeMapper {

    @Inject protected Storage mStorage;

    @Inject
    public CakeMapper() {

    }

    public List<Cake> mapCakes(CakeResponse response) {
        List<Cake> cakeList = new ArrayList<>();

        if (response != null) {
            CakeResponseCakes[] responseCakes = response.getCakes();
            if (responseCakes != null) {
                for (CakeResponseCakes cake : responseCakes) {
                    Cake myCake = new Cake();
                    myCake.setId(cake.getId());
                    myCake.setTitle(cake.getTitle());
                    myCake.setDetailDescription(cake.getDetailDescription());
                    myCake.setPreviewDescription(cake.getPreviewDescription());
                    myCake.setImage(cake.getImage());
                    mStorage.addCake(myCake);
                    cakeList.add(myCake);
                }
            }
        }
        return cakeList;
    }
}



