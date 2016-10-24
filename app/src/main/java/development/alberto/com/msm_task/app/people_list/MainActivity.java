package development.alberto.com.msm_task.app.people_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnPageChange;
import butterknife.Unbinder;
import development.alberto.com.msm_task.R;
import development.alberto.com.msm_task.app.adapter.ScreenSlidePagerAdapter;
import development.alberto.com.msm_task.app.people_list.screen1.Screen1Fragment;
import development.alberto.com.msm_task.app.people_list.screen2.Screen2Fragment;
import development.alberto.com.msm_task.app.widget.CustomViewPager;

public class MainActivity extends AppCompatActivity implements ActionCommands {

    @BindView(R.id.pager)
    CustomViewPager mPager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Screen1Fragment firstScreenFragment;

    private Screen2Fragment secondScreenFragment;

    private int currentFragmentPosition;

    private ScreenSlidePagerAdapter mPagerAdapter;

    private Unbinder unbinder;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

//    public static Intent getCallingIntent(Context context, String username) {
//        Intent intent = new Intent(context, MainActivity.class);
//        intent.putExtra(Constants.ARG_USERNAME, username);
//        return intent;
//    }

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
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), firstScreenFragment, secondScreenFragment);
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
                        showStepPage(0);
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
            showStepPage(0);
        }
    }

    @Override
    public void showStepPage(int pos) {
        mPager.setCurrentItem(pos);
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
