package zhaoliang.com.hmandroid.activity.day03.sqlite;

import android.os.Bundle;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：使用Sqlite数据库
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 使用Junit测试Sqlite数据库的使用
 * </pre>
 */
public class SqliteActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day03_title2);
    }
}
