package development.alberto.com.msm_task.data.api;

import development.alberto.com.msm_task.data.api.Constant.Constant;
import development.alberto.com.msm_task.data.api.Models.People;
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
