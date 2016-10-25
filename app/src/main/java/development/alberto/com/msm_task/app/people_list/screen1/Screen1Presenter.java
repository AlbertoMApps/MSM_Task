package development.alberto.com.msm_task.app.people_list.screen1;

import java.util.ArrayList;

import development.alberto.com.msm_task.app.util.Presenter;
import development.alberto.com.msm_task.business.interactor.DefaultSubscriber;
import development.alberto.com.msm_task.business.interactor.GetPeopleList;

/**
 * Created by alber on 24/10/2016.
 */

public class Screen1Presenter extends Presenter implements Screen1Contract.UserActionsListener {

    private Screen1Contract.View mView;
    private GetPeopleList getPeopleList;

    public Screen1Presenter( Screen1Contract.View view ) {
        if (view == null) throw new NullPointerException();
        mView = view;
//        getPeopleList = new GetPeopleList()
    }

    @Override
    public void stepForward(boolean lastStep) {
        if (!lastStep) {
            mView.showNextPage();
        }
    }

    @Override
    protected void onCreate() {
        getPeopleList.execute(new DefaultSubscriber());
    }

    @Override
    protected void onResume() {

    }

    @Override
    protected void onPause() {
        getPeopleList.unsubscribe();
    }

    @Override
    protected void onDestroy() {
        getPeopleList.unsubscribe();
    }

    public ArrayList<String> getPeople() {
        return null;
    }
}
