package zhaoliang.com.hmandroid.activity.day02.logcat;

import android.os.Bundle;
import android.util.Log;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：Android中Logcat的使用
 *     思路：
 *          1. 新建一个Activity
 *          2. 使用Log输出不同的日志
 * </pre>
 */
public class LogcatActivity extends BaseBackActivity {

    private static final String TAG = LogcatActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logcat);

        Log.v(TAG, "Verbose");
        Log.d(TAG, "Debug");
        Log.i(TAG, "Info");
        Log.w(TAG, "Warn");
        Log.e(TAG, "Error");
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day02_title2);
    }
}
