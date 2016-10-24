package development.alberto.com.msm_task.app.people_list.screen1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import development.alberto.com.msm_task.R;
import development.alberto.com.msm_task.app.people_list.ActionCommands;
import development.alberto.com.msm_task.app.people_list.MainActivity;

/**
 * Created by alber on 24/10/2016.
 */

public class Screen1Fragment extends Fragment implements Screen1Contract.View {

    private Screen1Presenter presenter;

    private Screen1Contract.UserActionsListener actionsListener;

    private ActionCommands mCallback;

    private MainActivity activity;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.screen1_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter = new Screen1Presenter(this);
        presenter.onCreate();
        return view;
    }



    public void onResumeFragment() {
    }

    public void onPauseFragment() {
    }

    @Override
    public void setActionsListener(Screen1Contract.UserActionsListener actionsListener) {

    }

    @Override
    public void showNextPage() {

    }

    @Override
    public void showErrorSnackBar(String errorMessage) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }
}
