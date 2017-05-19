package zhaoliang.com.hmandroid.activity.day06.startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day06.startactivityforresult.activity.ResultActivity;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：StartActivityForResult
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 完成逻辑
 * </pre>
 */
public class StartActivityForResultActivity extends BaseBackActivity {

    private int REQUESTCODE = 1000;
    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result);

        mTvResult = (TextView) findViewById(R.id.tv_result);
    }

    public void start(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivityForResult(intent, REQUESTCODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            mTvResult.setText(data.getStringExtra("result"));
        }
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day06_title6);
    }
}
