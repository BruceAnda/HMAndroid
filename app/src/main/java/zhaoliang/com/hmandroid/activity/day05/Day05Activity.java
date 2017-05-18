package zhaoliang.com.hmandroid.activity.day05;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day05.download.DownloadActivity;
import zhaoliang.com.hmandroid.activity.day05.httpclientandasynchttpclient.HttpClientAndAsyncHttpClientActivity;
import zhaoliang.com.hmandroid.base.BaseBackListActivity;

/**
 * 网络编程下
 * Created by zhaoliang on 2017/5/10.
 */

public class Day05Activity extends BaseBackListActivity {

    @Override
    protected String[] getListData() {
        return getResources().getStringArray(R.array.Day05);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, HttpClientAndAsyncHttpClientActivity.class);
                break;
            case 1:
                intent = new Intent(this, DownloadActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day05);
    }
}
