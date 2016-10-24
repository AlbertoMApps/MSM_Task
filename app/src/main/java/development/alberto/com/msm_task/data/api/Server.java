package development.alberto.com.msm_task.data.api;

import development.alberto.com.msm_task.data.api.Constant.Constant;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alber on 21/10/2016.
 */

public class Server {

    public static Service.IContactsAPI createPeopleAPI () {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build();

        return retrofit.create(Service.IContactsAPI.class);
    }
}
