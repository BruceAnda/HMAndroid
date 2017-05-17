package zhaoliang.com.hmandroid.activity.day04.getandpost;

import android.os.AsyncTask;
import android.os.Bundle;
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
 *     需求：GET和POST提交数据
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 编写逻辑处理
 * </pre>
 */
public class GETAndPOSTActivity extends BaseBackActivity {

    private EditText mEtCity;
    private TextView mTvResult;
    private String api = "http://api.avatardata.cn/Weather/Query?";
    String params = "key=1eff919c31ce4787ab230f6e26feef10&cityname=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getand_post);

        mEtCity = (EditText) findViewById(R.id.et_city);
        mTvResult = (TextView) findViewById(R.id.tv_result);
    }

    /**
     * 点击GET按钮调用这个方法
     *
     * @param view
     */
    public void get(View view) {
        new GETTask().execute(api + params + mEtCity.getText().toString());
    }

    /**
     * 点击POST按钮调用这个
     *
     * @param view
     */
    public void post(View view) {
        new POSTTask().execute(api, params + mEtCity.getText().toString());
    }

    class GETTask extends AsyncTask<String, Void, String> {

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
            mTvResult.setText("GET:" + s);
        }
    }

    class POSTTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setDoOutput(true);
                connection.getOutputStream().write(params[1].getBytes());
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
            mTvResult.setText("POST:" + s);
        }
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day04_title4);
    }
}
