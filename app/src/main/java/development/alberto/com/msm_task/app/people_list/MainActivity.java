package development.alberto.com.msm_task.app.people_list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import development.alberto.com.msm_task.R;
import development.alberto.com.msm_task.app.adapter.ScreenSliderPagerAdapter;
import development.alberto.com.msm_task.app.people_list.screen2.Screen2Fragment;
import development.alberto.com.msm_task.app.widget.CustomViewPager;
import development.alberto.com.msm_task.data.api.models.api_model.Person;

public class MainActivity extends AppCompatActivity implements ActionCommands.View {

    @BindView(R.id.pager)
    CustomViewPager mPager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private int currentFragmentPosition;
    private ScreenSliderPagerAdapter mPagerAdapter;
    private Bundle person;
    private Unbinder unbinder;
    private MainActivityPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        //firstScreenFragment = new Screen1Fragment();
        //secondScreenFragment = new Screen2Fragment();
        presenter = new MainActivityPresenter();
        presenter.onCreate();
        mPagerAdapter = new ScreenSliderPagerAdapter(getSupportFragmentManager(), presenter.getFragmentList());
        mPager.setSwipePageEnabled(false);
        mPager.setAdapter(mPagerAdapter);
        currentFragmentPosition = 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home:
                if (mPager != null) {
                    if (mPager.getCurrentItem() == 0) {
                        finish();
                    } else {
                        showStepPage(0, null);
                    }
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mPager == null || mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            showStepPage(currentFragmentPosition, null);
            currentFragmentPosition = 0;
        }
    }

    @Override
    public void showStepPage(int pos, Person args) {
//            if (args != null) {
//                args.getParcelable("selectedPerson");
//                person = args;
        currentFragmentPosition = pos;
        if (currentFragmentPosition == 1
                ) {
            final List<Fragment> fragmentList = presenter.getFragmentList();
            final Screen2Fragment secondScreenFragment = (Screen2Fragment) fragmentList.get(pos);
            secondScreenFragment.setViews(args);
//            }
        }
        mPager.setCurrentItem(pos);


    }

//    public Bundle sendDataStepForward() {
//        return  person;
//    }

//    @OnPageChange(R.id.pager)
//    public void onFragmentSelected(int position) {
//        if (position != currentFragmentPosition) {
//            switch (position) {
//                case 0:
//                    if (currentFragmentPosition == 1) {
//                        if (secondScreenFragment != null) {
//                            secondScreenFragment.onPauseFragment();
//                        }
//                    } else {
//                        if (firstScreenFragment != null) {
//                            firstScreenFragment.onResumeFragment();
//                        } else {
//                            secondScreenFragment.onPauseFragment();
//                        }
//                    }
//                    if (firstScreenFragment != null) {
//                        firstScreenFragment.onResumeFragment();
//                    }
//                    break;
//                case 1:
//                    if (currentFragmentPosition == 0) {
//                        if (firstScreenFragment != null) {
//                            firstScreenFragment.onPauseFragment();
//                        }
//                    } else {
//                        if (secondScreenFragment != null) {
//                            secondScreenFragment.onResumeFragment();
//                        } else {
//                            firstScreenFragment.onPauseFragment();
//                        }
//                    }
//                    if (secondScreenFragment != null) {
//                        secondScreenFragment.onResumeFragment();
//                    }
//                    break;
//            }
//            currentFragmentPosition = position;
//        }
//    }

    @Override
    public int getCurrentPosition() {
        return currentFragmentPosition;
    }
}
