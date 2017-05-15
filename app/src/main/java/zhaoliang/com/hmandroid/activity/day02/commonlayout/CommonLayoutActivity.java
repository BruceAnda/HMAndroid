package zhaoliang.com.hmandroid.activity.day02.commonlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day02.commonlayout.layout.AbsolueLayoutDemoActivity;
import zhaoliang.com.hmandroid.activity.day02.commonlayout.layout.FrameLayoutDemoActivity;
import zhaoliang.com.hmandroid.activity.day02.commonlayout.layout.LinearLayoutDemoOneActivity;
import zhaoliang.com.hmandroid.activity.day02.commonlayout.layout.LinearLayoutDemoTwoActivity;
import zhaoliang.com.hmandroid.activity.day02.commonlayout.layout.RelativeLayoutDemoOneActivity;
import zhaoliang.com.hmandroid.activity.day02.commonlayout.layout.RelativeLayoutDemoTwoActivity;
import zhaoliang.com.hmandroid.activity.day02.commonlayout.layout.TableLayoutDemoActivity;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：常用的五中布局
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 在布局文件中添加几个按钮，点击分别跳转的不同的布局Activity页面
 * </pre>
 */
public class CommonLayoutActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_layout);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day02_title1);
    }

    public void click(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.layout_demo:
                intent = new Intent(this, LinearLayoutDemoOneActivity.class);
                break;
            case R.id.layout_demo2:
                intent = new Intent(this, LinearLayoutDemoTwoActivity.class);
                break;
            case R.id.layout_demo3:
                intent = new Intent(this, RelativeLayoutDemoOneActivity.class);
                break;
            case R.id.layout_demo4:
                intent = new Intent(this, RelativeLayoutDemoTwoActivity.class);
                break;
            case R.id.layout_demo5:
                intent = new Intent(this, FrameLayoutDemoActivity.class);
                break;
            case R.id.layout_demo6:
                intent = new Intent(this, TableLayoutDemoActivity.class);
                break;
            case R.id.layout_demo7:
                intent = new Intent(this, AbsolueLayoutDemoActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }
}
