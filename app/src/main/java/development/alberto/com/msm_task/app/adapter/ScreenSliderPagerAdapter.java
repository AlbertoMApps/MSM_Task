package development.alberto.com.msm_task.app.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import development.alberto.com.msm_task.app.people_list.screen1.Screen1Fragment;
import development.alberto.com.msm_task.app.people_list.screen2.Screen2Fragment;

/**
 * Created by alber on 24/10/2016.
 */

public class ScreenSliderPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> screens;

        public ScreenSliderPagerAdapter(FragmentManager fm, List<Fragment> screens) {
            super(fm);
            this.screens = screens;
        }

        @Override
        public Fragment getItem(int position) {
            return screens.get(position);
        }

        @Override
        public int getCount() {
            return screens.size();
        }
    }
