package zhaoliang.com.hmandroid.activity.day02;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day02.commonlayout.CommonLayoutActivity;
import zhaoliang.com.hmandroid.activity.day02.logcat.LogcatActivity;
import zhaoliang.com.hmandroid.activity.day02.operatorxml.OperatorXMLActivity;
import zhaoliang.com.hmandroid.activity.day02.preference.PreferenceActivity;
import zhaoliang.com.hmandroid.activity.day02.sdstateandsize.SDStateAndSizeActivity;
import zhaoliang.com.hmandroid.activity.day02.storageoption.StorageOptionActivity;
import zhaoliang.com.hmandroid.base.BaseBackListActivity;

/**
 * 数据存储和界面展示上
 * Created by zhaoliang on 2017/5/10.
 */

public class Day02Activity extends BaseBackListActivity {

    @Override
    protected String[] getListData() {
        return getResources().getStringArray(R.array.Day02);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, CommonLayoutActivity.class);
                break;
            case 1:
                intent = new Intent(this, LogcatActivity.class);
                break;
            case 2:
                intent = new Intent(this, SDStateAndSizeActivity.class);
                break;
            case 3:
                intent = new Intent(this, StorageOptionActivity.class);
                break;
            case 4:
                intent = new Intent(this, OperatorXMLActivity.class);
                break;
            case 5:
                intent = new Intent(this, PreferenceActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day02);
    }
}
