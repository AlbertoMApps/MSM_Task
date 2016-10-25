package development.alberto.com.msm_task.app.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import development.alberto.com.msm_task.app.MSMApp;
import development.alberto.com.msm_task.app.UIThread;
import development.alberto.com.msm_task.business.executor.PostExecutionThread;
import development.alberto.com.msm_task.business.executor.ThreadExecutor;
import development.alberto.com.msm_task.business.repository.PeopleRepository;
import development.alberto.com.msm_task.data.api.PeopleDataRepository;
import development.alberto.com.msm_task.data.api.executor.JobExecutor;

/**
 * Created by alber on 24/10/2016.
 */
@Module
public class AppModule {
    private final MSMApp application;

    public AppModule (MSMApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton
    PeopleRepository providePeopleRepository(PeopleDataRepository peopleDataRepository) {
        return peopleDataRepository;
    }
}
