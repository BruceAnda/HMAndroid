package zhaoliang.com.hmandroid.activity.day06.activitylunchmode.activity;

import android.os.Bundle;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

public class StandardActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day06_values10);
    }
}
