package zhaoliang.com.hmandroid.activity.day02.commonlayout.layout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：学习FrameLayout的使用
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 编写逻辑处理
 * </pre>
 */
public class FrameLayoutDemoActivity extends BaseBackActivity {

    private int[] ids = {R.id.tv, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7};
    private int[] colorsId = {R.color.color, R.color.color2, R.color.color3, R.color.color4, R.color.color5, R.color.color6, R.color.color7};
    private int[] colors = new int[ids.length];
    private TextView[] textViews = new TextView[ids.length];
    private int currentColor;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            for (int i = 0; i < ids.length; i++) {
                textViews[i].setBackgroundColor(colors[(currentColor + i) % 7]);
            }
            currentColor++;
            sendEmptyMessageDelayed(0, 40);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_demo);

        for (int i = 0; i < ids.length; i++) {
            textViews[i] = (TextView) findViewById(ids[i]);
            colors[i] = getResources().getColor(colorsId[i]);
        }
        mHandler.sendEmptyMessage(0);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day02_values5);
    }
}
