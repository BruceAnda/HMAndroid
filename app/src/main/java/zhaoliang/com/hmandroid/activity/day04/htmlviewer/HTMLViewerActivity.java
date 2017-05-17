package zhaoliang.com.hmandroid.activity.day04.htmlviewer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：网页源码查看器
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 编写网页查看逻辑
 * </pre>
 */
public class HTMLViewerActivity extends BaseBackActivity {

    private EditText mEtHtmlUrl;
    private TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmlviewer);

        mEtHtmlUrl = (EditText) findViewById(R.id.et_html_url);
        mTvResult = (TextView) findViewById(R.id.tv_result);
    }

    /**
     * 点击查看按钮调用这个方法
     *
     * @param view
     */
    public void show(View view) {
        new DownloadTask().execute(mEtHtmlUrl.getText().toString());
    }

    class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                if (connection.getResponseCode() == 200) {
                    InputStream inputStream = connection.getInputStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    int len = 0;
                    byte[] b = new byte[1024];
                    while ((len = inputStream.read(b)) != -1) {
                        outputStream.write(b, 0, len);
                    }
                    return new String(outputStream.toByteArray());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (connection != null)
                    connection.disconnect();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            if (!TextUtils.isEmpty(s))
                mTvResult.setText(s);
        }
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day04_title2);
    }
}
