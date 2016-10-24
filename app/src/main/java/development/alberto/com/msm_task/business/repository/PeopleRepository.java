package development.alberto.com.msm_task.business.repository;

import development.alberto.com.msm_task.data.api.Models.People;
import rx.Observable;

/**
 * Created by alber on 24/10/2016.
 */

public interface PeopleRepository {
    Observable<People> getPeople();
}
