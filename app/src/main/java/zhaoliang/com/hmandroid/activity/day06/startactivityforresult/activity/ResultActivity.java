package zhaoliang.com.hmandroid.activity.day06.startactivityforresult.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：返回结果
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局
 *          3. 完成逻辑
 * </pre>
 */
public class ResultActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    /**
     * 点击back 按钮调用
     *
     * @param view
     */
    public void back(View view) {
        Intent intent = new Intent();
        intent.putExtra("result", "这里是返回的结果！");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected String setActionBarTitle() {
        return null;
    }
}
