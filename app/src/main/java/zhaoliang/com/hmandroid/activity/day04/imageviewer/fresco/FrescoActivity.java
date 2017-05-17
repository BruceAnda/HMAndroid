package zhaoliang.com.hmandroid.activity.day04.imageviewer.fresco;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.facebook.drawee.view.SimpleDraweeView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：使用Fresco查看网络图片
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 编写逻辑
 * </pre>
 */
public class FrescoActivity extends BaseBackActivity {

    private EditText mEtImageUrl;
    private SimpleDraweeView mSimpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);

        mEtImageUrl = (EditText) findViewById(R.id.et_image_url);
        mSimpleDraweeView = (SimpleDraweeView) findViewById(R.id.iv_image);
    }

    /**
     * 点击查看按钮调用这个方法
     *
     * @param view
     */
    public void show(View view) {
        mSimpleDraweeView.setImageURI(mEtImageUrl.getText().toString());
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day04_values5);
    }
}
