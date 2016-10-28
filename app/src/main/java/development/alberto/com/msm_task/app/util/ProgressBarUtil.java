package development.alberto.com.msm_task.app.util;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by alber on 24/10/2016.
 */

public class ProgressBarUtil {

    public static void showProgressDialog(ProgressDialog progressDoalog, Activity activity) {
        progressDoalog = new ProgressDialog(activity);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.setTitle("Loading contacts");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();
    }
}
