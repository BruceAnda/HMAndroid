package zhaoliang.com.hmandroid.activity.day06.secondactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day06.secondactivity.activity.SecondActivityActivity;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：SecondActivity
 *     思路：
 *          1. 新建一个Activity
 * </pre>
 */
public class SecondActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    /**
     * 按钮点击调用这个方法
     *
     * @param view
     */
    public void secondActivity(View view) {
        startActivity(new Intent(this, SecondActivityActivity.class));
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day06_title1);
    }
}
