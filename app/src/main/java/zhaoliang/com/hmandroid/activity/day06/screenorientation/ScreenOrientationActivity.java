package zhaoliang.com.hmandroid.activity.day06.screenorientation;

import android.os.Bundle;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：屏幕方向
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 完成逻辑
 * </pre>
 */
public class ScreenOrientationActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_orientation);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day06_title5);
    }
}
