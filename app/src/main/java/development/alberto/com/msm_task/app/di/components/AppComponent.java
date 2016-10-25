package development.alberto.com.msm_task.app.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import development.alberto.com.msm_task.app.di.modules.AppModule;
import development.alberto.com.msm_task.app.people_list.screen1.Screen1Fragment;
import development.alberto.com.msm_task.business.executor.PostExecutionThread;
import development.alberto.com.msm_task.business.executor.ThreadExecutor;
import development.alberto.com.msm_task.business.repository.PeopleRepository;
import development.alberto.com.msm_task.data.api.PeopleDataRepository;

/**
 * Created by alber on 24/10/2016.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(Screen1Fragment screen1Fragment);

    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    PeopleRepository peopleRepository();
}
