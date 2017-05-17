package zhaoliang.com.hmandroid.activity.day03.junit;

import android.os.Bundle;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：单元测试
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 在测试包下新建一个测试类，测试Junit的使用
 * </pre>
 */
public class JunitActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junit);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day03_title1);
    }
}
