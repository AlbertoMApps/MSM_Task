package development.alberto.com.msm_task.business.interactor;

import javax.inject.Inject;

import development.alberto.com.msm_task.business.executor.PostExecutionThread;
import development.alberto.com.msm_task.business.executor.ThreadExecutor;
import development.alberto.com.msm_task.business.repository.PeopleRepository;
import rx.Observable;

/**
 * Created by alber on 24/10/2016.
 */

public class GetPeopleList extends UseCase{

    private PeopleRepository peopleRepository;
    private ThreadExecutor threadExecutor;
    private PostExecutionThread postExecutionThread;

    @Inject
    public GetPeopleList(PeopleRepository peopleRepository, ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.peopleRepository = peopleRepository;
    }

    @Override public Observable buildUseCaseObservable() {
        return this.peopleRepository.getPeople();
    }
}
