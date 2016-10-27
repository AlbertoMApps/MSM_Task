package development.alberto.com.msm_task.app.people_list.screen1;

import java.util.ArrayList;
import java.util.List;

import development.alberto.com.msm_task.app.util.Presenter;
import development.alberto.com.msm_task.business.interactor.DefaultSubscriber;
import development.alberto.com.msm_task.business.interactor.UseCase;
import development.alberto.com.msm_task.data.api.Models.People;
import development.alberto.com.msm_task.data.api.Models.Person;

/**
 * Created by alber on 24/10/2016.
 */

public class Screen1Presenter extends Presenter implements Screen1Contract.UserActionsListener {

    private Screen1Contract.View mView;
    private  List<Person> peopleList;
    private UseCase getPeopleList;

    public Screen1Presenter( Screen1Contract.View view, UseCase getPeopleList) {
        if (view == null) throw new NullPointerException();
        mView = view;
        this.getPeopleList = getPeopleList;
    }

    @Override
    public void stepForward(boolean lastStep) {
        if (!lastStep) {
            mView.showNextPage();
        }
    }

    @Override
    protected void onCreate() {
        getPeopleList.execute(new PeopleListSubscriber());
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

    public ArrayList<Person> getPeople() {
        return (ArrayList<Person>) peopleList;
    }

    private final class PeopleListSubscriber extends DefaultSubscriber<People> {

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(People people) {
            peopleList = people.getPeople();
            mView.initRecyclerView();
        }
    }
}
