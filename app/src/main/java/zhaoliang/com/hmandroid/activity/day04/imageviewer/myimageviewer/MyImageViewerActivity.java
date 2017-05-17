package zhaoliang.com.hmandroid.activity.day04.imageviewer.myimageviewer;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：带缓存的图片查看器
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 编写图片查看逻辑
 * </pre>
 */
public class MyImageViewerActivity extends BaseBackActivity {

    private EditText mEtImageUrl;
    private ImageView mIvImage;
    private File mFile;
    private String mPath;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mIvImage.setImageBitmap(BitmapFactory.decodeFile(mPath));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_image_viewer);

        mPath = getCacheDir() + File.separator + "temp.jpg";

        mEtImageUrl = (EditText) findViewById(R.id.et_image_url);
        mIvImage = (ImageView) findViewById(R.id.iv_image);
    }

    /**
     * 点击查看按钮调用这个方法
     *
     * @param view
     */
    public void show(View view) {
        mFile = new File(mPath);
        if (mFile.exists()) {
            System.out.println("读取本地！");
            mHandler.sendEmptyMessage(0);
        } else {
            System.out.println("网络下载！");
            new DownloadTask().execute(mEtImageUrl.getText().toString());
        }
    }

    class DownloadTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            HttpURLConnection connection = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                if (connection.getResponseCode() == 200) {
                    InputStream inputStream = connection.getInputStream();
                    FileOutputStream outputStream = new FileOutputStream(mPath);
                    int len = 0;
                    byte[] b = new byte[1024];
                    while ((len = inputStream.read(b)) != -1) {
                        outputStream.write(b, 0, len);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mHandler.sendEmptyMessage(0);
        }
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day04_values1);
    }
}
