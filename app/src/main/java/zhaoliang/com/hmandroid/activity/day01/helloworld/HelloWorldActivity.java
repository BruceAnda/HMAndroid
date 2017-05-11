package zhaoliang.com.hmandroid.activity.day01.helloworld;

import android.os.Bundle;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：在屏幕上显示HelloWorld的字样
 *     思路：
 *          1. 新建一个Activity类
 *          2. 编写布局文件，在布局文件中添加一个TextView，设置TextView的text属性为HelloWorld就可以显示HelloWorld的字样了
 * </pre>
 */
public class HelloWorldActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day01_title1);
    }
}
