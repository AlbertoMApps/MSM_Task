
package development.alberto.com.msm_task.app;


import javax.inject.Inject;
import javax.inject.Singleton;

import development.alberto.com.msm_task.business.executor.PostExecutionThread;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * MainThread (UI Thread) implementation based on a {@link rx.Scheduler}
 * which will execute actions on the Android UI thread
 */
@Singleton
public class UIThread implements PostExecutionThread {

  @Inject
  public UIThread(){}

  @Override
  public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
