package development.alberto.com.msm_task.data.api.models.data_model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by alber on 15/11/2016.
 */

public class PersonTable extends RealmObject {

    @PrimaryKey
    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String avatarImage;
    private String role;

    /**
     *
     * @return
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     *     The firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     *     The lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     *     The dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     *
     * @param dateOfBirth
     *     The dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     *
     * @return
     *     The avatarImage
     */
    public String getAvatarImage() {
        return avatarImage;
    }

    /**
     *
     * @param avatarImage
     *     The avatarImage
     */
    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    /**
     *
     * @return
     *     The role
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     *     The role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

}