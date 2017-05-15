package zhaoliang.com.hmandroid.activity.day02.preference.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import zhaoliang.com.hmandroid.R;

/**
 * Created by zhaoliang on 2017/5/15.
 */

public class MySettingFragment extends PreferenceFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.my_settings);
    }
}
