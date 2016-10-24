package development.alberto.com.msm_task.data.api;

import development.alberto.com.msm_task.business.repository.PeopleRepository;
import development.alberto.com.msm_task.data.api.Models.People;
import rx.Observable;

/**
 * Created by alber on 24/10/2016.
 */

public class PeopleDataRepository implements PeopleRepository {

    @Override
    public Observable<People> getPeople() {
        return Server.createPeopleAPI().getContacts();
    }
}
