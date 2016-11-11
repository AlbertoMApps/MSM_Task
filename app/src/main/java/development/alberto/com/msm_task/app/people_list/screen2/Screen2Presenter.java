package development.alberto.com.msm_task.app.people_list.screen2;

import development.alberto.com.msm_task.app.util.Presenter;

/**
 * Created by alber on 24/10/2016.
 */

public class Screen2Presenter extends Presenter implements Screen2Contract.UserActionsListener {

    private Screen2Contract.View mView;

    public Screen2Presenter(Screen2Contract.View view) {
        if (view== null) throw new NullPointerException();
        mView = view;
    }

    @Override
    protected void onCreate() {

    }

    @Override
    protected void onResume() {

    }

    @Override
    protected void onPause() {

    }

    @Override
    protected void onDestroy() {

    }

    @Override
    public void stepForward(boolean lastStep) {

    }
}
