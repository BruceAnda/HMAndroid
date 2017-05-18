package zhaoliang.com.hmandroid.activity.day05.download;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day05.download.downloader.DownloaderActivity;
import zhaoliang.com.hmandroid.activity.day05.download.mutiplethreaddownload.MutipleThreadDownloadActivity;
import zhaoliang.com.hmandroid.activity.day05.download.opendownloader.OpenDownloaderActivity;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：下载文件
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 编写逻辑
 * </pre>
 */
public class DownloadActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
    }

    /**
     * 按钮点击调用这个方法
     *
     * @param view
     */
    public void click(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_download:
                intent = new Intent(this, MutipleThreadDownloadActivity.class);
                break;
            case R.id.btn_download2:
                intent = new Intent(this, DownloaderActivity.class);
                break;
            case R.id.btn_download3:
                intent = new Intent(this, OpenDownloaderActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day05_title2);
    }
}
