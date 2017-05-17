package zhaoliang.com.hmandroid.activity.day04.imageviewer.picasso;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：使用Picasso查看网络图片
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 使用Picasso显示网络图片
 * </pre>
 */
public class PicassoActivity extends BaseBackActivity {

    private EditText mEtImageUrl;
    private ImageView mIvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        mEtImageUrl = (EditText) findViewById(R.id.et_image_url);
        mIvImage = (ImageView) findViewById(R.id.iv_image);
    }

    /**
     * 点击查看按钮调用这个方法
     *
     * @param view
     */
    public void show(View view) {
        Picasso.with(this).load(mEtImageUrl.getText().toString()).into(mIvImage);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day04_values3);
    }
}
