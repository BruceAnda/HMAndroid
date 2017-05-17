package zhaoliang.com.hmandroid.activity.day03;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day03.dialog.DialogActivity;
import zhaoliang.com.hmandroid.activity.day03.junit.JunitActivity;
import zhaoliang.com.hmandroid.activity.day03.listview.ListViewActivity;
import zhaoliang.com.hmandroid.activity.day03.sqlite.SqliteActivity;
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
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, JunitActivity.class);
                break;
            case 1:
                intent = new Intent(this, SqliteActivity.class);
                break;
            case 2:
                intent = new Intent(this, ListViewActivity.class);
                break;
            case 3:
                intent = new Intent(this, DialogActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day03);
    }
}
