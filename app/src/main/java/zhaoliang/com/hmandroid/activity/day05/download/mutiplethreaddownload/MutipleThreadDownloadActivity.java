package zhaoliang.com.hmandroid.activity.day05.download.mutiplethreaddownload;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：多线程下载
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局
 *          3. 完成逻辑
 * </pre>
 */
public class MutipleThreadDownloadActivity extends BaseBackActivity {

    private EditText mEtDownloadUrl;
    private ProgressBar mPbProgress;
    private int currentProgress;
    private TextView mTvProgress;
    private int mThreadCount = 3;
    private String mDownloadUrl;
    private String mFilePath;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mTvProgress.setText((long) mPbProgress.getProgress() * 100 / mPbProgress.getMax() + "%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutiple_thread_download);

        mFilePath = Environment.getExternalStorageDirectory() + File.separator + "QQ.apk";

        mEtDownloadUrl = (EditText) findViewById(R.id.et_downloadurl);
        mPbProgress = (ProgressBar) findViewById(R.id.pb_progress);
        mTvProgress = (TextView) findViewById(R.id.tv_progress);

    }

    /**
     * 点击下载按钮调用这个方法
     *
     * @param view
     */
    public void download(View view) {
        mDownloadUrl = mEtDownloadUrl.getText().toString();
        new DonwloadTask().execute(mDownloadUrl);
    }

    class DonwloadTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            // 1. 确定每个线程的下载大小
            HttpURLConnection connection = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                if (connection.getResponseCode() == 200) {
                    // 总长度
                    final int contentLength = connection.getContentLength();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mPbProgress.setMax(contentLength);
                        }
                    });
                    RandomAccessFile temp = new RandomAccessFile(mFilePath, "rwd");
                    temp.setLength(contentLength);
                    temp.close();
                    int size = contentLength / mThreadCount;
                    int startIndex;
                    int endIndex;
                    System.out.println("contentLength:" + contentLength);
                    System.out.println("size:" + size);
                    for (int i = 0; i < mThreadCount; i++) {
                        startIndex = i * size;
                        endIndex = (i + 1) * size;
                        if (i == mThreadCount - 1) {
                            endIndex = contentLength;
                        }
                        //System.out.println("线程：" + i + "下载区间是：" + startIndex + "---" + endIndex);
                        new DownloadThread(i, startIndex, endIndex).start();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    class DownloadThread extends Thread {

        private int threadId;
        private int startIndex;
        private int endIndex;

        public DownloadThread(int threadId, int startIndex, int endIndex) {
            this.threadId = threadId;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            System.out.println("线程：" + threadId + "下载区间是：" + startIndex + "---" + endIndex);
        }

        @Override
        public void run() {
            HttpURLConnection connection = null;
            try {
                URL url = new URL(mDownloadUrl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(5000);
                connection.setConnectTimeout(5000);
                connection.setRequestProperty("Range", "bytes=" + startIndex + "-" + endIndex);
                if (connection.getResponseCode() == 206) {
                    // 写入文件
                    RandomAccessFile randomAccessFile = new RandomAccessFile(mFilePath, "rwd");
                    randomAccessFile.seek(startIndex);
                    InputStream inputStream = connection.getInputStream();
                    int len = 0;
                    byte[] b = new byte[1024];
                    int total = 0;
                    while ((len = inputStream.read(b)) != -1) {
                        randomAccessFile.write(b, 0, len);

                        total += len;
                        System.out.println("线程：" + threadId + "下载了：" + total);

                        currentProgress += len;
                        mPbProgress.setProgress(currentProgress);

                        mHandler.sendEmptyMessage(1);

                    }
                    System.out.println("线程：" + threadId + "下载完毕！");
                    randomAccessFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day05_values3);
    }
}
