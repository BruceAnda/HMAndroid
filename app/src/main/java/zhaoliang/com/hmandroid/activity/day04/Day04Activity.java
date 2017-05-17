package zhaoliang.com.hmandroid.activity.day04;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day04.getandpost.GETAndPOSTActivity;
import zhaoliang.com.hmandroid.activity.day04.htmlviewer.HTMLViewerActivity;
import zhaoliang.com.hmandroid.activity.day04.imageviewer.ImageViewerActivity;
import zhaoliang.com.hmandroid.activity.day04.simplenewsclient.SimpleNewsClientActivity;
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
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, ImageViewerActivity.class);
                break;
            case 1:
                intent = new Intent(this, HTMLViewerActivity.class);
                break;
            case 2:
                intent = new Intent(this, SimpleNewsClientActivity.class);
                break;
            case 3:
                intent = new Intent(this, GETAndPOSTActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day04);
    }
}
