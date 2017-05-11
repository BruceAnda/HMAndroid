package zhaoliang.com.hmandroid.activity.day01.phonedialer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：电话拨号器
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件，布局一个输入电话号码的输入框和一个拨打按钮
 *          3. 实现拨打电话
 *          4. 添加拨打电话的权限
 * </pre>
 */
public class PhoneDialerActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day01_title2);
    }

    /**
     * 当点击拨打按钮的时候调用
     *
     * @param view
     */
    public void call(View view) {
        // 1. 获取电话号码
        String phoneNum = ((EditText) findViewById(R.id.et_phone_num)).getText().toString();
        // 2. 创建拨打电话的意图
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNum));
        // 3. 拨打电话
        startActivity(intent);
    }
}
