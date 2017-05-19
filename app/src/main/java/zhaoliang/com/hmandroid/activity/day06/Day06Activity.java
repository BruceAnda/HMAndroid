package zhaoliang.com.hmandroid.activity.day06;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day06.activityjump.ActivityJumpActivity;
import zhaoliang.com.hmandroid.activity.day06.activitylifecycle.ActivityLifeCycleActivity;
import zhaoliang.com.hmandroid.activity.day06.activitylunchmode.ActivityLunchModeActivity;
import zhaoliang.com.hmandroid.activity.day06.screenorientation.ScreenOrientationActivity;
import zhaoliang.com.hmandroid.activity.day06.secondactivity.SecondActivity;
import zhaoliang.com.hmandroid.activity.day06.startactivityforresult.StartActivityForResultActivity;
import zhaoliang.com.hmandroid.base.BaseBackListActivity;

/**
 * 界面跳转和数据传递
 * Created by zhaoliang on 2017/5/10.
 */

public class Day06Activity extends BaseBackListActivity {

    @Override
    protected String[] getListData() {
        return getResources().getStringArray(R.array.Day06);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, SecondActivity.class);
                break;
            case 1:
                intent = new Intent(this, ActivityJumpActivity.class);
                break;
            case 2:
                intent = new Intent(this, ActivityLifeCycleActivity.class);
                break;
            case 3:
                intent = new Intent(this, ActivityLunchModeActivity.class);
                break;
            case 4:
                intent = new Intent(this, ScreenOrientationActivity.class);
                break;
            case 5:
                intent = new Intent(this, StartActivityForResultActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day06);
    }
}
