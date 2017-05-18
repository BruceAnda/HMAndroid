package zhaoliang.com.hmandroid.activity.day05.httpclientandasynchttpclient.asnychttpclient;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：AsyncHttpClient的使用
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 完成逻辑
 * </pre>
 */
public class AsyncHttpClientActivity extends BaseBackActivity {

    private EditText mEtCity;
    private TextView mTvResult;
    private String api = "http://api.avatardata.cn/Weather/Query";
    String params = "key=1eff919c31ce4787ab230f6e26feef10&cityname=";
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_http_client);

        mEtCity = (EditText) findViewById(R.id.et_city);
        mTvResult = (TextView) findViewById(R.id.tv_result);
        client = new AsyncHttpClient();
    }

    /**
     * 点击get按钮调用这个方法
     *
     * @param view
     */
    public void get(View view) {
        client.get(api + "?" + params + mEtCity.getText().toString(), new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                mTvResult.setText("GET:" + responseString);
            }
        });
    }

    /**
     * 点击post按钮调用这个方法
     *
     * @param view
     */
    public void post(View view) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("key", "1eff919c31ce4787ab230f6e26feef10");
        requestParams.put("cityname", mEtCity.getText().toString());
        client.post(api, requestParams, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                mTvResult.setText("POST:" + responseString);
            }
        });
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day05_values2);
    }
}
