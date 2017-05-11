package zhaoliang.com.hmandroid.activity.day01.smssender;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：短信发送器
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局界面
 *          3. 编写逻辑代码
 * </pre>
 */
public class SmsSenderActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_sender);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day01_title3);
    }

    /**
     * 点击发送按钮的时候调用
     *
     * @param view
     */
    public void send(View view) {
        // 1. 获取电话号码和短信内容
        String phoneNum = ((EditText) findViewById(R.id.et_phone_num)).getText().toString();
        String smsContent = ((EditText) findViewById(R.id.et_sms_content)).getText().toString();
        // 2. 获取发送短信的api
        SmsManager smsManager = SmsManager.getDefault();
        // 3. 发送短信
        smsManager.sendMultipartTextMessage(phoneNum, null, smsManager.divideMessage(smsContent), null, null);
    }
}
