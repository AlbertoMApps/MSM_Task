
package development.alberto.com.msm_task.data.api.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class People {

    @SerializedName("people")
    @Expose
    private List<Person> people = new ArrayList<Person>();

    /**
     * 
     * @return
     *     The people
     */
    public List<Person> getPeople() {
        return people;
    }

    /**
     * 
     * @param people
     *     The people
     */
    public void setPeople(List<Person> people) {
        this.people = people;
    }

}
