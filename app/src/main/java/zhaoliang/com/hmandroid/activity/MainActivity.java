package zhaoliang.com.hmandroid.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day01.Day01Activity;
import zhaoliang.com.hmandroid.activity.day02.Day02Activity;
import zhaoliang.com.hmandroid.activity.day03.Day03Activity;
import zhaoliang.com.hmandroid.activity.day04.Day04Activity;
import zhaoliang.com.hmandroid.activity.day05.Day05Activity;
import zhaoliang.com.hmandroid.activity.day06.Day06Activity;
import zhaoliang.com.hmandroid.activity.day07.Day07Activity;
import zhaoliang.com.hmandroid.activity.day08.Day08Activity;
import zhaoliang.com.hmandroid.activity.day09.Day09Activity;
import zhaoliang.com.hmandroid.activity.day10.Day10Activity;
import zhaoliang.com.hmandroid.activity.day11.Day11Activity;
import zhaoliang.com.hmandroid.activity.day12.Day12Activity;
import zhaoliang.com.hmandroid.base.BaseListActivity;

/**
 * 程序的主界面
 */
public class MainActivity extends BaseListActivity {

    private static final int MY_PERMISSIONS_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE) ||
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS) ||
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE,
                                Manifest.permission.SEND_SMS,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_CODE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    protected String[] getListData() {
        return getResources().getStringArray(R.array.Main);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, Day01Activity.class);
                break;
            case 1:
                intent = new Intent(this, Day02Activity.class);
                break;
            case 2:
                intent = new Intent(this, Day03Activity.class);
                break;
            case 3:
                intent = new Intent(this, Day04Activity.class);
                break;
            case 4:
                intent = new Intent(this, Day05Activity.class);
                break;
            case 5:
                intent = new Intent(this, Day06Activity.class);
                break;
            case 6:
                intent = new Intent(this, Day07Activity.class);
                break;
            case 7:
                intent = new Intent(this, Day08Activity.class);
                break;
            case 8:
                intent = new Intent(this, Day09Activity.class);
                break;
            case 9:
                intent = new Intent(this, Day10Activity.class);
                break;
            case 10:
                intent = new Intent(this, Day11Activity.class);
                break;
            case 11:
                intent = new Intent(this, Day12Activity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }
}
