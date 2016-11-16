package development.alberto.com.msm_task.app;


import android.app.Application;

import development.alberto.com.msm_task.app.di.components.AppComponent;
import development.alberto.com.msm_task.app.di.components.DaggerAppComponent;
import development.alberto.com.msm_task.app.di.modules.AppModule;
import development.alberto.com.msm_task.app.di.modules.PeopleModule;
import io.realm.Realm;

/**
 * Created by alber on 24/10/2016.
 */

public class MSMApp extends Application {
    private AppComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        Realm.init(this);
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .peopleModule(new PeopleModule())
                .build();
    }

    public AppComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
