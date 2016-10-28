package development.alberto.com.msm_task.app.people_list;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnPageChange;
import butterknife.Unbinder;
import development.alberto.com.msm_task.R;
import development.alberto.com.msm_task.app.adapter.ScreenSliderPagerAdapter;
import development.alberto.com.msm_task.app.people_list.screen1.Screen1Fragment;
import development.alberto.com.msm_task.app.people_list.screen2.Screen2Fragment;
import development.alberto.com.msm_task.app.widget.CustomViewPager;
import development.alberto.com.msm_task.data.api.Models.Person;

public class MainActivity extends AppCompatActivity implements ActionCommands {

    @BindView(R.id.pager)
    CustomViewPager mPager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Screen1Fragment firstScreenFragment;

    private Screen2Fragment secondScreenFragment;

    private int currentFragmentPosition;

    private ScreenSliderPagerAdapter mPagerAdapter;

    private Unbinder unbinder;

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
        mPagerAdapter = new ScreenSliderPagerAdapter(getSupportFragmentManager(), firstScreenFragment, secondScreenFragment);
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
            showStepPage(0, null);
        }
    }

    @Override
    public void showStepPage(int pos, Bundle args) {
        Bundle existentArgs = new Bundle();
        if (existentArgs != null) {
            existentArgs.clear();
            if (args != null) {
                args.getParcelable("selectedPerson");
                existentArgs.putAll(args);
            }
        }
        mPager.setCurrentItem(pos);
    }

    @Override
    public void sendDataStepForward(Person person) {

    }

    @OnPageChange(R.id.pager)
    public void onFragmentSelected(int position) {
        if (position != currentFragmentPosition) {
            switch (position) {
                case 0:
                    if (firstScreenFragment != null) {
                        firstScreenFragment.onPauseFragment();
                    }
                    if (secondScreenFragment != null) {
                        secondScreenFragment.onPauseFragment();
                    }
                    if (firstScreenFragment != null) {
                        firstScreenFragment.onResumeFragment();
                    }
                    break;
                case 1:
                    if (currentFragmentPosition == 0) {
                        if (firstScreenFragment != null) {
                            firstScreenFragment.onPauseFragment();
                        }
                    } else {
                        if (secondScreenFragment != null) {
                            secondScreenFragment.onPauseFragment();
                        }
                    }
                    if (secondScreenFragment != null) {
                        secondScreenFragment.onResumeFragment();
                    }
                    break;
            }
            currentFragmentPosition = position;
        }
    }

    @Override
    public int getCurrentPosition() {
        return currentFragmentPosition;
    }
}
