package zhaoliang.com.hmandroid.activity.day04.imageviewer.smartimageview;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day04.imageviewer.smartimageview.com.loopj.android.image.SmartImageView;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：网络图片查看器
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 编写逻辑
 * </pre>
 */
public class SmartImageViewActivity extends BaseBackActivity {

    private EditText mEtImageUrl;
    private SmartImageView mSmartImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_image_view);

        mEtImageUrl = (EditText) findViewById(R.id.et_image_url);
        mSmartImageView = (SmartImageView) findViewById(R.id.iv_image);
    }

    /**
     * 点击查看按钮调用这个方法
     *
     * @param view
     */
    public void show(View view) {
        mSmartImageView.setImageUrl(mEtImageUrl.getText().toString());
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day04_values2);
    }
}
