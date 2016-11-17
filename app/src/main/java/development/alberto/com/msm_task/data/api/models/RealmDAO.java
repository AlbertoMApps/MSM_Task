package development.alberto.com.msm_task.data.api.models;

import android.util.Log;

import development.alberto.com.msm_task.data.api.models.data_model.PersonTable;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by alber on 15/11/2016.
 */

public class RealmDAO {

    private Realm realm;
    private PersonTable person;

    public RealmDAO(){
        // Get a Realm instance for this thread
        realm = Realm.getDefaultInstance();
        person = new PersonTable();
    }

    public void initData(){
//        realm.beginTransaction();
//        person = realm.createObject(PersonTable.class, person); // Create managed objects directly
//        realm.commitTransaction();
    }

    public  void addPersonData(final String firstName, final String lastName,
                               final String role, final String dob, final String avatarImgString) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                person = realm.createObject(PersonTable.class);
                person.setFirstName(firstName);
                person.setLastName(lastName);
                person.setRole(role);
                person.setDateOfBirth(dob);
                person.setAvatarImage(avatarImgString);
                Log.i("model added ", "" + firstName);
            }
        });
    }

    public RealmResults<PersonTable> getAllFromPersonTableData (){
        realm.beginTransaction();
        RealmQuery<PersonTable> query = realm.where(PersonTable.class);
        RealmResults<PersonTable> result = query.findAll();
        realm.commitTransaction();
        return result;
    }

    public void clearDB() {
        realm.beginTransaction();
        realm.delete(PersonTable.class);
        realm.commitTransaction();
    }

}
