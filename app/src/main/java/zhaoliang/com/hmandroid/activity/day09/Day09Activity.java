package zhaoliang.com.hmandroid.activity.day09;

import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackListActivity;

/**
 * 多媒体编程
 * Created by zhaoliang on 2017/5/10.
 */

public class Day09Activity extends BaseBackListActivity {

    @Override
    protected String[] getListData() {
        return getResources().getStringArray(R.array.Day09);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day09);
    }
}
