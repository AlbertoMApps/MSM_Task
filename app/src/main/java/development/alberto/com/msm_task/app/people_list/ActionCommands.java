package development.alberto.com.msm_task.app.people_list;

import android.os.Bundle;

/**
 * Created by AlbertoMedrano on 21/07/16.
 */
public interface ActionCommands {

    interface View {
        void showStepPage(int pos, Bundle args);
        int getCurrentPosition();
    }

    interface UserActionsListener {
    }
}
