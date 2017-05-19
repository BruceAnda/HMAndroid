package zhaoliang.com.hmandroid.activity.day06.activitylifecycle;

import android.os.Bundle;
import android.util.Log;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：Activity的生命周期
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 完成逻辑
 * </pre>
 */
public class ActivityLifeCycleActivity extends BaseBackActivity {

    private static final String TAG = ActivityLifeCycleActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day06_title3);
    }
}
