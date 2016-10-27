package development.alberto.com.msm_task.app.people_list.screen1;

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
        }

    interface UserActionsListener {

        void stepForward(boolean lastStep);

    }
}
