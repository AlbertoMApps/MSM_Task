package development.alberto.com.msm_task.app.di.modules;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import development.alberto.com.msm_task.business.interactor.GetPeopleList;
import development.alberto.com.msm_task.business.interactor.UseCase;

/**
 * Created by alber on 24/10/2016.
 */
@Module
public class PeopleModule {

    public PeopleModule(){}

    @Provides
    @Singleton
    UseCase provideGetUserListUseCase(GetPeopleList getPeopleList) {
        return getPeopleList;
    }

}
