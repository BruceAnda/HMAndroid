package zhaoliang.com.hmandroid.activity.day05.download.opendownloader;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadLargeFileListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.File;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：开源的下载器
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 使用开源项目下载
 * </pre>
 */
public class OpenDownloaderActivity extends BaseBackActivity {

    private EditText mEtDownloadUrl;
    private ProgressBar mPbProgress;
    private TextView mTvProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_downloader);

        mEtDownloadUrl = (EditText) findViewById(R.id.et_downloadurl);
        mPbProgress = (ProgressBar) findViewById(R.id.pb_progress);
        mTvProgress = (TextView) findViewById(R.id.tv_progress);
    }

    /**
     * 点击下载按钮调用
     *
     * @param view
     */
    public void download(View view) {
        FileDownloader.getImpl().create(mEtDownloadUrl.getText().toString()).setPath(Environment.getExternalStorageDirectory() + File.separator + "QQ2.apk").setListener(new FileDownloadLargeFileListener() {
            @Override
            protected void pending(BaseDownloadTask task, long soFarBytes, long totalBytes) {

            }

            @Override
            protected void progress(BaseDownloadTask task, long soFarBytes, long totalBytes) {
                mPbProgress.setMax((int) totalBytes);
                mPbProgress.setProgress((int) soFarBytes);
                mTvProgress.setText(soFarBytes * 100 / totalBytes + "%");
            }

            @Override
            protected void paused(BaseDownloadTask task, long soFarBytes, long totalBytes) {

            }

            @Override
            protected void completed(BaseDownloadTask task) {

            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {

            }

            @Override
            protected void warn(BaseDownloadTask task) {

            }
        }).start();
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day05_values5);
    }
}
