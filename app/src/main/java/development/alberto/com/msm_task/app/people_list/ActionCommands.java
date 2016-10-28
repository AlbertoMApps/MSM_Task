package development.alberto.com.msm_task.app.people_list;

import android.os.Bundle;

import development.alberto.com.msm_task.data.api.Models.Person;

/**
 * Created by AlbertoMedrano on 21/07/16.
 */
public interface ActionCommands {

    void showStepPage(int pos, Bundle args);

    void sendDataStepForward(Person person);

    int getCurrentPosition();
}
