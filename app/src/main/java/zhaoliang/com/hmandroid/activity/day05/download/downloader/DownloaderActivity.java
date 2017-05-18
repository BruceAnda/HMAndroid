package zhaoliang.com.hmandroid.activity.day05.download.downloader;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：使用Android提供的下载器下载文件
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 完成下载
 * </pre>
 */
public class DownloaderActivity extends BaseBackActivity {

    private DownloadManager mDownloadManager;
    private EditText mEtDownloadUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloader);

        mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        mEtDownloadUrl = (EditText) findViewById(R.id.et_downloadurl);
    }

    /**
     * 点击下载按钮的时候调用
     *
     * @param view
     */
    public void download(View view) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(mEtDownloadUrl.getText().toString()));

        mDownloadManager.enqueue(request);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day05_values4);
    }
}
