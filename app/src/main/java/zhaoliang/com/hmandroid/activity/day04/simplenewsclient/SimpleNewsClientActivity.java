package zhaoliang.com.hmandroid.activity.day04.simplenewsclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day04.simplenewsclient.bean.NewsBean;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：简易新闻客户端
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 编写逻辑
 * </pre>
 */
public class SimpleNewsClientActivity extends BaseBackActivity {

    private String api = "https://newsapi.org/v1/articles?source=abc-news-au&sortBy=top&apiKey=5fd88c80e2aa4919b54b74e1c9a2f42e";
    private ListView mNewsList;
    private List<NewsBean.ArticlesBean> articlesBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_news_client);

        mNewsList = (ListView) findViewById(R.id.news_list);
        new DownloadTask().execute(api);
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
            NewsBean newsBean = JSON.parseObject(s, NewsBean.class);
            articlesBeanList = newsBean.getArticles();
            mNewsList.setAdapter(new NewsAdapter());
        }
    }

    class NewsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return articlesBeanList == null ? 0 : articlesBeanList.size();
        }

        @Override
        public NewsBean.ArticlesBean getItem(int position) {
            return articlesBeanList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(SimpleNewsClientActivity.this).inflate(R.layout.simple_news_item, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            NewsBean.ArticlesBean item = getItem(position);
            viewHolder.newsImage.setImageURI(item.getUrlToImage());
            viewHolder.newsTitle.setText(item.getTitle());
            viewHolder.newsDisciption.setText(item.getDescription());
            viewHolder.newsPublishedAt.setText(item.getPublishedAt());
            return convertView;
        }

        class ViewHolder {
            SimpleDraweeView newsImage;
            TextView newsTitle;
            TextView newsDisciption;
            TextView newsPublishedAt;

            public ViewHolder(View item) {
                newsImage = (SimpleDraweeView) item.findViewById(R.id.news_image);
                newsTitle = (TextView) item.findViewById(R.id.news_title);
                newsDisciption = (TextView) item.findViewById(R.id.news_description);
                newsPublishedAt = (TextView) item.findViewById(R.id.news_published_at);
            }
        }
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day04_title3);
    }
}
