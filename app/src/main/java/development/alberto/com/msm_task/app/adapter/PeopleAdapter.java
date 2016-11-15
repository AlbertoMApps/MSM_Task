package development.alberto.com.msm_task.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import development.alberto.com.msm_task.R;
import development.alberto.com.msm_task.app.people_list.screen1.Screen1Fragment;
import development.alberto.com.msm_task.data.api.models.api_model.Person;

/**
 * Created by alber on 24/10/2016.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private Context context;
    private int mLayout;
    private List<Person> persons;
    private int listPosition;
    private Screen1Fragment sc1Fragment;

    public PeopleAdapter(List<Person> pData, int row_person, Context context) {
        this.context = context;
        this.mLayout = row_person;
        this.persons = pData;
    }

    public PeopleAdapter(List<Person> pData, int row_person, Context context, Screen1Fragment screen1Fragment) {
        this.context = context;
        this.mLayout = row_person;
        this.persons = pData;
        this.sc1Fragment = screen1Fragment;

    }

    @Override
    public PeopleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(mLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Person dataPersonAPI = persons.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPosition = holder.getAdapterPosition();
                sc1Fragment.stepForward(listPosition);
            }
        });
        Picasso.with(context)
                .load(dataPersonAPI.getAvatarImage())
                .resize(350, 350)
                .into(holder.personImage);
        holder.personName.setText(dataPersonAPI.getFirstName());
        holder.personLastName.setText(dataPersonAPI.getLastName());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void update(List<Person> persons) {
        this.persons = persons;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.personImage)
        ImageView personImage;
        @BindView(R.id.personName)
        TextView personName;
        @BindView(R.id.personLastName)
        TextView personLastName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
