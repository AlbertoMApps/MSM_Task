package development.alberto.com.msm_task.app;

import android.app.Application;

import development.alberto.com.msm_task.app.di.components.AppComponent;
import development.alberto.com.msm_task.app.di.components.DaggerAppComponent;
import development.alberto.com.msm_task.app.di.modules.AppModule;

/**
 * Created by alber on 24/10/2016.
 */

public class MSMApp extends Application {
    private AppComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
