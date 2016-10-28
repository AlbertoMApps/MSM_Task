package development.alberto.com.msm_task.app.people_list.screen2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import development.alberto.com.msm_task.R;
import development.alberto.com.msm_task.data.api.Models.Person;

/**
 * Created by alber on 24/10/2016.
 */

public class Screen2Fragment extends Fragment implements Screen2Contract.View {

    private Unbinder unbinder;
    @BindView(R.id.personImage)
    ImageView personImage;
    @BindView(R.id.personName)
    TextView personName;
    @BindView(R.id.personLastName)
    TextView personLastName;
    @BindView(R.id.role)
    TextView role;
    @BindView(R.id.dob)
    TextView dob;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.person_details, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public void setViews(Person person){
        personName.setText(person.getFirstName());
        personLastName.setText(person.getLastName());
        role.setText(person.getRole());
        dob.setText(person.getDateOfBirth());
    }

    public void onPauseFragment() {
    }

    public void onResumeFragment() {
    }

    @Override
    public void setActionsListener(Screen2Contract.UserActionsListener actionsListener) {

    }

    @Override
    public void showErrorSnackBar(String errorMessage) {

    }
}
