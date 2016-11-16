package development.alberto.com.msm_task.app.people_list.screen1;

import android.util.Log;

import java.util.List;

import development.alberto.com.msm_task.app.net.ConnectionManager;
import development.alberto.com.msm_task.app.util.Presenter;
import development.alberto.com.msm_task.business.interactor.DefaultSubscriber;
import development.alberto.com.msm_task.business.interactor.UseCase;
import development.alberto.com.msm_task.data.api.models.RealmDAO;
import development.alberto.com.msm_task.data.api.models.api_model.People;
import development.alberto.com.msm_task.data.api.models.api_model.Person;
import development.alberto.com.msm_task.data.api.models.data_model.PersonTable;
import development.alberto.com.msm_task.data.api.models.mapper.RealmMapper;

/**
 * Created by alber on 24/10/2016.
 */

public class Screen1Presenter extends Presenter implements Screen1Contract.UserActionsListener {

    private static final String TAG = "Error TAG";
    private Screen1Contract.View mView;
    private  List<Person> peopleList;
    private UseCase getPeopleList;
    private ConnectionManager connectionManager;
    private  RealmDAO realmDAO;

    public Screen1Presenter( Screen1Contract.View view, UseCase getPeopleList) {
        if (view == null) throw new NullPointerException();
        mView = view;
        this.getPeopleList = getPeopleList;
        connectionManager = new ConnectionManager(mView.getContextFragment1());
    }

    @Override
    public void stepForward(boolean lastStep ) {
        if (lastStep) {
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

    public List<Person> getPeople() {
        return peopleList;
    }

    private final class PeopleListSubscriber extends DefaultSubscriber<People> {

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            mView.showErrorSnackBar(e.getMessage());
            Log.e(TAG, e.getMessage());
        }

        @Override
        public void onNext(People people) {
            peopleList = people.getPeople();
            mView.updateList(peopleList);
            if ( connectionManager.isNetworkAvailable() ) {
                //We have connection so, we can download and save into the DB
                //Check realmDao
                realmDAO = new RealmDAO();
                realmDAO.initData();
                for (Person person : peopleList) {
                    realmDAO.addPersonData(person.getFirstName(), person.getLastName(),
                            person.getRole(), person.getDateOfBirth(), person.getAvatarImage());
                }

            } else {
                //Otherwise we will send the list of persons from the database
                peopleList = RealmMapper.transform(realmDAO.getAllFromPersonTableData());
                for (PersonTable personTable : realmDAO.getAllFromPersonTableData()) {
                    Log.i(TAG, personTable.getFirstName());
                }
            }
        }
    }
}
