package zhaoliang.com.hmandroid.activity.day06.secondactivity.activity;

import android.os.Bundle;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：第二个Activity
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 编写逻辑
 * </pre>
 */
public class SecondActivityActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day06_values1);
    }
}
