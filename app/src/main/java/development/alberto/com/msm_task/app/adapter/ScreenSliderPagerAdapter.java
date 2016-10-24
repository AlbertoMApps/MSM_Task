package development.alberto.com.msm_task.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import development.alberto.com.msm_task.app.people_list.screen1.Screen1Fragment;
import development.alberto.com.msm_task.app.people_list.screen2.Screen2Fragment;

/**
 * Created by alber on 24/10/2016.
 */

public class ScreenSliderPagerAdapter extends FragmentPagerAdapter {
        private static final int NUM_PAGES = 2;
        private Screen1Fragment firstScreenFragment;
        private Screen2Fragment secondScreenFragment;

        public ScreenSliderPagerAdapter(FragmentManager fm, Screen1Fragment firstScreenFragment, Screen2Fragment secondScreenFragment) {
            super(fm);
            this.firstScreenFragment = firstScreenFragment;
            this.secondScreenFragment = secondScreenFragment;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new Screen1Fragment();
            } else if (position == 1) {
                return new Screen2Fragment();
            } else {
                throw new RuntimeException("Invalid position requested for this adapter.");
            }
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment createdFragment = (Fragment) super.instantiateItem(container, position);
            switch (position) {
                case 0:
                    firstScreenFragment = (Screen1Fragment) createdFragment;
                    break;
                case 1:
                    secondScreenFragment = (Screen2Fragment) createdFragment;
                    break;
            }
            return createdFragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
