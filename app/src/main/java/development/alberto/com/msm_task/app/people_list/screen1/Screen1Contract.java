package development.alberto.com.msm_task.app.people_list.screen1;

import java.util.List;

import development.alberto.com.msm_task.data.api.Models.Person;

/**
 * Created by alber on 24/10/2016.
 */

public interface Screen1Contract  {

    interface View {

        void setActionsListener(UserActionsListener actionsListener);

        void showNextPage();

        void showErrorSnackBar(String errorMessage);

        void showProgress();

        void dismissProgress();

        void initRecyclerView();

        void updateList(List<Person> peopleList);
    }

    interface UserActionsListener {

        void stepForward(boolean lastStep);

    }

    interface ActionsAdapter {
        void stepForward(int pos);
    }
}
