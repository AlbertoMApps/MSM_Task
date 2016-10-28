package development.alberto.com.msm_task.app.people_list.screen2;

/**
 * Created by alber on 24/10/2016.
 */

public interface Screen2Contract {
    interface View {

        void setActionsListener(UserActionsListener actionsListener);

        void showErrorSnackBar(String errorMessage);

    }

    interface UserActionsListener {

        void stepForward(boolean lastStep);

    }
}
