package zhaoliang.com.hmandroid.activity.day01;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day01.clickevent.ClickEventActivity;
import zhaoliang.com.hmandroid.activity.day01.helloworld.HelloWorldActivity;
import zhaoliang.com.hmandroid.activity.day01.phonedialer.PhoneDialerActivity;
import zhaoliang.com.hmandroid.activity.day01.smssender.SmsSenderActivity;
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
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, HelloWorldActivity.class);
                break;
            case 1:
                intent = new Intent(this, PhoneDialerActivity.class);
                break;
            case 2:
                intent = new Intent(this, SmsSenderActivity.class);
                break;
            case 3:
                intent = new Intent(this, ClickEventActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }
}
