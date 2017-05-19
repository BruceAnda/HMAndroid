package zhaoliang.com.hmandroid.activity.day06.activitylunchmode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day06.activitylunchmode.activity.SingleInstanceActivity;
import zhaoliang.com.hmandroid.activity.day06.activitylunchmode.activity.SingleTaskActivity;
import zhaoliang.com.hmandroid.activity.day06.activitylunchmode.activity.SingleTopActivity;
import zhaoliang.com.hmandroid.activity.day06.activitylunchmode.activity.StandardActivity;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：ActivityLunchMode
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 完成逻辑
 * </pre>
 */
public class ActivityLunchModeActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_mode);
    }

    /**
     * 点击按钮调用这个方法
     *
     * @param view
     */
    public void lunchmode(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_lunchmode:
                intent = new Intent(this, StandardActivity.class);
                break;
            case R.id.btn_lunchmode2:
                intent = new Intent(this, SingleTopActivity.class);
                break;
            case R.id.btn_lunchmode3:
                intent = new Intent(this, SingleTaskActivity.class);
                break;
            case R.id.btn_lunchmode4:
                intent = new Intent(this, SingleInstanceActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day06_title4);
    }
}
