package zhaoliang.com.hmandroid.activity.day02.commonlayout.layout;

import android.os.Bundle;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：线性布局LinearLayout的使用
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 * </pre>
 */
public class LinearLayoutDemoTwoActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_demo_two);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day02_values2);
    }
}
