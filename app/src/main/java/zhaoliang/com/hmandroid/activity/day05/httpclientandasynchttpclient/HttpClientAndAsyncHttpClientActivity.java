package zhaoliang.com.hmandroid.activity.day05.httpclientandasynchttpclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day05.httpclientandasynchttpclient.asnychttpclient.AsyncHttpClientActivity;
import zhaoliang.com.hmandroid.activity.day05.httpclientandasynchttpclient.httpclient.HttpClientActivity;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：HttpClient和AsyncHttpClient的使用
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 编写逻辑
 * </pre>
 */
public class HttpClientAndAsyncHttpClientActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client_and_async_http_client);
    }

    /**
     * 按钮点击事件
     *
     * @param view
     */
    public void click(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_httpclient:
                intent = new Intent(this, HttpClientActivity.class);
                break;
            case R.id.btn_asynchttpclient:
                intent = new Intent(this, AsyncHttpClientActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day05_title1);
    }
}
