package zhaoliang.com.hmandroid.activity.day02.storageoption.storage;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     基本的存储类
 * </pre>
 */
public abstract class BaseStorageActivity extends BaseBackActivity {

    private EditText mEtUsername, mEtPassword;
    private CheckBox mCbRemeber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_storage);

        init();
    }

    /**
     * 初始化
     */
    private void init() {
        findView();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        Map<String, String> account = readAccount();
        if (account != null) {
            mEtUsername.setText(account.get("username"));
            mEtPassword.setText(account.get("password"));
        }
    }

    /**
     * 读取账户信息
     *
     * @return
     */
    protected abstract Map<String, String> readAccount();

    /**
     * 查找控件
     */
    private void findView() {
        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mCbRemeber = (CheckBox) findViewById(R.id.cb_remeber);
    }

    /**
     * 点击登录按钮调用这个方法
     *
     * @param view
     */
    public void login(View view) {
        String usernameStr = mEtUsername.getText().toString();
        String passwordStr = mEtPassword.getText().toString();
        if (mCbRemeber.isChecked()) {
            boolean flag = saveAccount(usernameStr, passwordStr);
            if (flag)
                Toast.makeText(this, "保存成功！", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
    }

    /**
     * 保存账户信息
     *
     * @param usernameStr
     * @param passwordStr
     * @return
     */
    protected abstract boolean saveAccount(String usernameStr, String passwordStr);
}
