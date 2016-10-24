package development.alberto.com.msm_task.app.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * ViewPager that allows the swipe gesture to be disabled/enabled on the fly.
 *
 * Created by gustavopagani on 21/12/2015.
 */
public class CustomViewPager extends ViewPager {

    private boolean swipePageEnabled;

    public CustomViewPager(Context context) {
        super(context);
        this.swipePageEnabled = true;
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.swipePageEnabled = true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.swipePageEnabled && super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.swipePageEnabled && super.onTouchEvent(event);
    }

    public boolean isSwipePageEnabled() {
        return swipePageEnabled;
    }

    public void setSwipePageEnabled(boolean swipePageEnabled) {
        this.swipePageEnabled = swipePageEnabled;
    }

}