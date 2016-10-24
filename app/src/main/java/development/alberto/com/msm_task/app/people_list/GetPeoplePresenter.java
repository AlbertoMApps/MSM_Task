package development.alberto.com.msm_task.app.people_list;

import java.util.List;

import development.alberto.com.msm_task.business.interactor.DefaultSubscriber;
import development.alberto.com.msm_task.business.interactor.UseCase;
import development.alberto.com.msm_task.data.api.Models.People;

/**
 * Created by alber on 24/10/2016.
 */

public class GetPeoplePresenter {

    private UseCase peopleUseCase;

    private void getPeopleList() {
        this.peopleUseCase.execute(new PeopleListSubscriber());
    }

    private final class PeopleListSubscriber extends DefaultSubscriber<People> {

        @Override public void onCompleted() {
        }

        @Override public void onError(Throwable e) {
        }

        @Override public void onNext(People people) {
        }
    }
}
