
package development.alberto.com.msm_task.app;


import development.alberto.com.msm_task.business.executor.PostExecutionThread;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * MainThread (UI Thread) implementation based on a {@link rx.Scheduler}
 * which will execute actions on the Android UI thread
 */

public class UIThread implements PostExecutionThread {

  @Override
  public Scheduler getScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
