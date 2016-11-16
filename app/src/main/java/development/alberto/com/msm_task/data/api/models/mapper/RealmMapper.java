package development.alberto.com.msm_task.data.api.models.mapper;

import java.util.ArrayList;
import java.util.List;

import development.alberto.com.msm_task.data.api.models.api_model.Person;
import development.alberto.com.msm_task.data.api.models.data_model.PersonTable;
import io.realm.RealmResults;

/**
 * Created by alber on 16/11/2016.
 */

public class RealmMapper {

    public static Person transform(PersonTable personTable) {
        Person person = new Person();
        if(personTable !=null ) {
            person.setFirstName(personTable.getFirstName());
            person.setLastName(personTable.getLastName());
            person.setRole(personTable.getRole());
            person.setDateOfBirth(personTable.getDateOfBirth());
            person.setRole(personTable.getRole());
        }
        return person;
    }

    public static List<Person> transform(RealmResults<PersonTable> listPersonTable) {
        List<Person> personList = new ArrayList<>();
        if(listPersonTable !=null ) {
            for (PersonTable personTable : listPersonTable) {
                Person person = transform(personTable);
                personList.add(person);
            }
        }
        return personList;
    }
}
