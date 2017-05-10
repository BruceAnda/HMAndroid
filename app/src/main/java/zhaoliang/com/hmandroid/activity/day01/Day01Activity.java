package zhaoliang.com.hmandroid.activity.day01;

import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackListActivity;

/**
 * 快速入门
 * Created by zhaoliang on 2017/5/10.
 */

public class Day01Activity extends BaseBackListActivity {

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day01);
    }

    @Override
    protected String[] getListData() {
        return getResources().getStringArray(R.array.Day01);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
