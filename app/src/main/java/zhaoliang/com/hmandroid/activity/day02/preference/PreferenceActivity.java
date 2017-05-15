package zhaoliang.com.hmandroid.activity.day02.preference;

import android.os.Bundle;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day02.preference.fragment.MySettingFragment;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：使用Preference
 *     思路：
 *          1. 新建一个Activity
 *          2. 新建一个Preference的Fragment
 *          3. 显示Fragment
 * </pre>
 */
public class PreferenceActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        getFragmentManager().beginTransaction().replace(R.id.setting_content, new MySettingFragment()).commit();
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day02_title6);
    }
}
