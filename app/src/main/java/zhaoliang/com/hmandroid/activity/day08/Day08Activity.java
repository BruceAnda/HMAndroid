package zhaoliang.com.hmandroid.activity.day08;

import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackListActivity;

/**
 * 广播和服务下
 * Created by zhaoliang on 2017/5/10.
 */

public class Day08Activity extends BaseBackListActivity {

    @Override
    protected String[] getListData() {
        return getResources().getStringArray(R.array.Day08);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day08);
    }
}
