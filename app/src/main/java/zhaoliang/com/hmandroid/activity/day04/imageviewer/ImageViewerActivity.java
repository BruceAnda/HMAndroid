package zhaoliang.com.hmandroid.activity.day04.imageviewer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day04.imageviewer.fresco.FrescoActivity;
import zhaoliang.com.hmandroid.activity.day04.imageviewer.glide.GlideActivity;
import zhaoliang.com.hmandroid.activity.day04.imageviewer.myimageviewer.MyImageViewerActivity;
import zhaoliang.com.hmandroid.activity.day04.imageviewer.picasso.PicassoActivity;
import zhaoliang.com.hmandroid.activity.day04.imageviewer.smartimageview.SmartImageViewActivity;
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
public class ImageViewerActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
    }

    /**
     * 按钮点击事件
     *
     * @param view
     */
    public void click(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_imageview:
                intent = new Intent(this, MyImageViewerActivity.class);
                break;
            case R.id.btn_imageview2:
                intent = new Intent(this, SmartImageViewActivity.class);
                break;
            case R.id.btn_imageview3:
                intent = new Intent(this, PicassoActivity.class);
                break;
            case R.id.btn_imageview4:
                intent = new Intent(this, GlideActivity.class);
                break;
            case R.id.btn_imageview5:
                intent = new Intent(this, FrescoActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day04_title1);
    }
}
