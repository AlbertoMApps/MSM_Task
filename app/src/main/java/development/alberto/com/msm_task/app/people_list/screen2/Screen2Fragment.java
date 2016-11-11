package development.alberto.com.msm_task.app.people_list.screen2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import development.alberto.com.msm_task.R;
import development.alberto.com.msm_task.app.people_list.MainActivity;
import development.alberto.com.msm_task.data.api.Models.Person;

/**
 * Created by alber on 24/10/2016.
 */

public class Screen2Fragment extends Fragment implements Screen2Contract.View {

    private Unbinder unbinder;
    private Screen2Presenter screen2Presenter;
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

    public static Screen2Fragment newInstance () {
        return new Screen2Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.person_details, container, false);
        unbinder = ButterKnife.bind(this, view);
        screen2Presenter = new Screen2Presenter(this);
        Bundle args = getArguments();
        if( args!=null ) {
            Person person = (Person) args
                    .getParcelable("selectedPerson");
            setViews(person);
        }
//        Bundle person = ((MainActivity)getActivity()).sendDataStepForward();
//        if(person!=null) {
//            setViews((Person) person.getParcelable("selectedPerson"));
//        }
        return view;
    }

    public void setViews(Person person){
        Picasso.with(getContext())
                .load(person.getAvatarImage())
                .resize(350,350)
                .into(personImage);
        personName.setText(person.getFirstName());
        personLastName.setText(person.getLastName());
        role.setText(person.getRole());
        dob.setText(person.getDateOfBirth());
    }

    public void onPauseFragment() {
        onPause();
    }

    public void onResumeFragment() {
        onResume();
    }

    @Override
    public void setActionsListener(Screen2Contract.UserActionsListener actionsListener) {

    }

    @Override
    public void showErrorSnackBar(String errorMessage) {

    }
}
