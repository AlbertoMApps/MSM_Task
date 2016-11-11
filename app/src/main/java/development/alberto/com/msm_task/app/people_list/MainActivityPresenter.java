package development.alberto.com.msm_task.app.people_list;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import development.alberto.com.msm_task.app.people_list.screen1.Screen1Fragment;
import development.alberto.com.msm_task.app.people_list.screen2.Screen2Fragment;
import development.alberto.com.msm_task.app.util.Presenter;

/**
 * Created by alber on 11/11/2016.
 */
public class MainActivityPresenter extends Presenter {

    private List<Fragment> fragmentList;

    public MainActivityPresenter(){
    }

    @Override
    protected void onCreate() {
        fragmentList = new ArrayList<>(2);
        fragmentList.add(Screen1Fragment.newInstance());
        fragmentList.add(Screen2Fragment.newInstance());
    }

    @Override
    protected void onResume() {

    }

    @Override
    protected void onPause() {

    }

    @Override
    protected void onDestroy() {

    }

}
