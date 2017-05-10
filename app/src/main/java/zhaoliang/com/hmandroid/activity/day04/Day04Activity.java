package zhaoliang.com.hmandroid.activity.day04;

import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackListActivity;

/**
 * 网络编程上
 * Created by zhaoliang on 2017/5/10.
 */

public class Day04Activity extends BaseBackListActivity {

    @Override
    protected String[] getListData() {
        return getResources().getStringArray(R.array.Day04);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day04);
    }
}
