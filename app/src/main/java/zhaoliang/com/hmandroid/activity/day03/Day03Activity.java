package zhaoliang.com.hmandroid.activity.day03;

import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackListActivity;

/**
 * 数据存储和界面展示下
 * Created by zhaoliang on 2017/5/10.
 */

public class Day03Activity extends BaseBackListActivity {

    @Override
    protected String[] getListData() {
        return getResources().getStringArray(R.array.Day03);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day03);
    }
}
