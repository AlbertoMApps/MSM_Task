package development.alberto.com.msm_task.data.api;

import javax.inject.Inject;

import development.alberto.com.msm_task.business.repository.PeopleRepository;
import development.alberto.com.msm_task.data.api.models.api_model.People;
import rx.Observable;

/**
 * Created by alber on 24/10/2016.
 */

public class PeopleDataRepository implements PeopleRepository {

    @Inject
    PeopleDataRepository(){}

    @Override
    public Observable<People> getPeople() {
        return Server.createPeopleAPI().getContacts();
    }
}
