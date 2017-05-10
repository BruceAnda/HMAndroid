package zhaoliang.com.hmandroid.base;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import zhaoliang.com.hmandroid.R;

/**
 * 基础列表Activity
 */
public abstract class BaseBackListActivity extends BaseBackActivity implements AdapterView.OnItemClickListener {

    // 声明widget
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_list);

        mListView = (ListView) findViewById(R.id.base_list);
        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.base_list_item, R.id.tv_content, getListData()));
        mListView.setOnItemClickListener(this);
    }

    /**
     * 获取数据集
     *
     * @return
     */
    protected abstract String[] getListData();
}
