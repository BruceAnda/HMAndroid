package zhaoliang.com.hmandroid.activity.day03.listview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：使用Android中的ListView显示丰富的列表
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 使用ListView
 * </pre>
 */
public class ListViewActivity extends BaseBackActivity {

    private ListView mArrayAdapterListView, mSimpleAdapterListView, mCustomAdapterListView;
    private int[] heads = {R.mipmap.head, R.mipmap.head2, R.mipmap.head3};
    private String[] names;
    private ArrayList<Map<String, Object>> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        names = getResources().getStringArray(R.array.Names);

        mArrayAdapterListView = (ListView) findViewById(R.id.arrayadapter_list);
        mSimpleAdapterListView = (ListView) findViewById(R.id.simpleadapter_list);
        mCustomAdapterListView = (ListView) findViewById(R.id.customadapter_list);

        mArrayAdapterListView.setAdapter(new ArrayAdapter<String>(this, R.layout.day03_list_item, R.id.day03_tv_name, names));

        data = new ArrayList<>();
        Map<String, Object> data1 = new HashMap<>();
        data1.put("head", R.mipmap.head);
        data1.put("name", names[0]);
        Map<String, Object> data2 = new HashMap<>();
        data2.put("head", R.mipmap.head2);
        data2.put("name", names[1]);
        Map<String, Object> data3 = new HashMap<>();
        data3.put("head", R.mipmap.head3);
        data3.put("name", names[2]);
        data.add(data1);
        data.add(data2);
        data.add(data3);

        String[] from = {"head", "name"};
        int[] to = {R.id.day03_iv_head, R.id.day03_tv_name};
        mSimpleAdapterListView.setAdapter(new SimpleAdapter(this, data, R.layout.day03_list_item, from, to));

        mCustomAdapterListView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.length > 0 ? names.length : 0;
        }

        @Override
        public String getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(ListViewActivity.this).inflate(R.layout.day03_list_item, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.head.setImageResource(heads[position]);
            viewHolder.name.setText(getItem(position));
            return convertView;
        }

        class ViewHolder {
            ImageView head;
            TextView name;

            public ViewHolder(View item) {
                head = (ImageView) item.findViewById(R.id.day03_iv_head);
                name = (TextView) item.findViewById(R.id.day03_tv_name);
            }
        }
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day03_title3);
    }
}
