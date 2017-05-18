package zhaoliang.com.hmandroid.activity.day05.httpclientandasynchttpclient.httpclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.util.EntityUtils;
import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：HttpClient的使用
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 编写逻辑
 * </pre>
 */
public class HttpClientActivity extends BaseBackActivity {

    private EditText mEtCity;
    private TextView mTvResult;
    private String api = "http://api.avatardata.cn/Weather/Query";
    String params = "key=1eff919c31ce4787ab230f6e26feef10&cityname=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client);

        mEtCity = (EditText) findViewById(R.id.et_city);
        mTvResult = (TextView) findViewById(R.id.tv_result);
    }

    /**
     * 点击get按钮调用这个方法
     *
     * @param view
     */
    public void get(View view) {
        new GETTask().execute(api + "?" + params + mEtCity.getText().toString());
    }

    /**
     * 点击post按钮调用这个方法
     *
     * @param view
     */
    public void post(View view) {
        new POSTTask().execute(api, mEtCity.getText().toString());
    }

    class GETTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet get = new HttpGet(params[0]);
            try {
                HttpResponse response = httpClient.execute(get);
                if (response.getStatusLine().getStatusCode() == 200) {
                    return EntityUtils.toString(response.getEntity());
                }
            } catch (IOException e) {
                e.printStackTrace();
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
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(params[0]);
            ArrayList<NameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair("key", "1eff919c31ce4787ab230f6e26feef10"));
            parameters.add(new BasicNameValuePair("cityname", params[1]));
            try {
                post.setEntity(new UrlEncodedFormEntity(parameters));
                HttpResponse response = client.execute(post);
                if (response.getStatusLine().getStatusCode() == 200) {
                    return EntityUtils.toString(response.getEntity());
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
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
        return getString(R.string.day05_values1);
    }
}
