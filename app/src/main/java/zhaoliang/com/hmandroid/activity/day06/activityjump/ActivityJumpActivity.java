package zhaoliang.com.hmandroid.activity.day06.activityjump;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day06.secondactivity.activity.SecondActivityActivity;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：ActivityJump
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局
 *          3. 完成逻辑
 * </pre>
 */
public class ActivityJumpActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
    }

    /**
     * 点击跳转按钮调用这个方法
     *
     * @param view
     */
    public void jump(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_jump:
                intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:10086"));
                break;
            case R.id.btn_jump2:
                intent = new Intent(this, SecondActivityActivity.class);
                break;
            case R.id.btn_jump3:
                intent = new Intent("day06.secondactivity");
                break;
            case R.id.btn_jump4:
                //com.google.android.dialer/.extensions.GoogleDialtactsActivity
                intent = new Intent();
                intent.setClassName("com.google.android.dialer", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
                break;
            case R.id.btn_jump5:
                intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                break;
            case R.id.btn_jump6:
                //com.android.chrome/org.chromium.chrome.browser.ChromeTabbedActivity
                intent = new Intent();
                intent.setClassName("com.android.chrome", "com.android.chrome.org.chromium.chrome.browser.ChromeTabbedActivity");
                break;
            case R.id.btn_jump7:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day06_title2);
    }
}
