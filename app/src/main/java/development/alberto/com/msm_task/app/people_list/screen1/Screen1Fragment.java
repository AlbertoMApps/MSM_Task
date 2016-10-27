package development.alberto.com.msm_task.app.people_list.screen1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import development.alberto.com.msm_task.R;
import development.alberto.com.msm_task.app.MSMApp;
import development.alberto.com.msm_task.app.adapter.PeopleAdapter;
import development.alberto.com.msm_task.app.people_list.ActionCommands;
import development.alberto.com.msm_task.app.people_list.MainActivity;
import development.alberto.com.msm_task.business.interactor.UseCase;
import development.alberto.com.msm_task.data.api.Models.Person;

/**
 * Created by alber on 24/10/2016.
 */

public class Screen1Fragment extends Fragment implements Screen1Contract.View {

    private Screen1Presenter presenter;

    private Screen1Contract.UserActionsListener actionsListener;

    private ActionCommands mCallback;

    private MainActivity activity;

    private Unbinder unbinder;

    @BindView(R.id.list)
    RecyclerView mRecyclerView;

    private PeopleAdapter mAdapter;

    private ArrayList <Person> pData;

    @Inject
    UseCase getPeopleList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MSMApp)getActivity().getApplicationContext()).getApplicationComponent().inject(this);
        getPeopleList =  ((MSMApp) getActivity().getApplicationContext()).getApplicationComponent().getUserListUseCase();
        presenter = new Screen1Presenter(this, getPeopleList);
        presenter.onCreate();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.screen1_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public void initRecyclerView(){

        pData = presenter.getPeople();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new PeopleAdapter(pData, R.layout.row_person, getContext());
        mRecyclerView.setAdapter(mAdapter);
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
