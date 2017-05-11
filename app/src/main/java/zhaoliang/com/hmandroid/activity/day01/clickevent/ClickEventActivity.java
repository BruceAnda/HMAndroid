package zhaoliang.com.hmandroid.activity.day01.clickevent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：Android中点击事件的写法
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 实现逻辑
 * </pre>
 */
public class ClickEventActivity extends BaseBackActivity implements View.OnClickListener {

    private Button mBtnClick2, mBtnClick3, mBtnClick4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_event);

        mBtnClick2 = (Button) findViewById(R.id.btn_click2);
        mBtnClick3 = (Button) findViewById(R.id.btn_click3);
        mBtnClick4 = (Button) findViewById(R.id.btn_click4);

        mBtnClick2.setOnClickListener(this);

        mBtnClick3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClickEventActivity.this, getString(R.string.day01_values8), Toast.LENGTH_SHORT).show();
            }
        });
        mBtnClick4.setOnClickListener(new MyClickListener());
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day01_title4);
    }

    public void click(View view) {
        Toast.makeText(this, getString(R.string.day01_values6), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, getString(R.string.day01_values7), Toast.LENGTH_SHORT).show();
    }

    class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(ClickEventActivity.this, getString(R.string.day01_values9), Toast.LENGTH_SHORT).show();
        }
    }
}
