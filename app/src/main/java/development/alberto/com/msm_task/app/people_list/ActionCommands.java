package development.alberto.com.msm_task.app.people_list;

import development.alberto.com.msm_task.data.api.models.api_model.Person;

/**
 * Created by AlbertoMedrano on 21/07/16.
 */
public interface ActionCommands {

    interface View {
        void showStepPage(int pos, Person args);
        int getCurrentPosition();
    }

    interface UserActionsListener {
    }
}
