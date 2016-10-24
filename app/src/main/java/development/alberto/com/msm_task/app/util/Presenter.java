package development.alberto.com.msm_task.app.util;

/**
 * Base class with lifecycle methods
 */
public abstract class Presenter {

    protected Presenter() {}

    protected abstract void onCreate();

    protected abstract void onResume();

    protected abstract void onPause();

    protected abstract void onDestroy();
}
