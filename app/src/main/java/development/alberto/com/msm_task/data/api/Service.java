package development.alberto.com.msm_task.data.api;

import development.alberto.com.msm_task.data.api.constant.Constant;
import development.alberto.com.msm_task.data.api.models.api_model.People;
import retrofit2.http.GET;

/**
 * Created by alber on 21/10/2016.
 */

public class Service {
    public interface IContactsAPI {
        @GET(Constant.GET_CONTACTS_URL)
        rx.Observable<People> getContacts();
    }
}
