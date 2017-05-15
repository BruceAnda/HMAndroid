package zhaoliang.com.hmandroid.activity.day02.storageoption;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day02.storageoption.storage.ExternalStorageActivity;
import zhaoliang.com.hmandroid.activity.day02.storageoption.storage.InternalStorageActivity;
import zhaoliang.com.hmandroid.activity.day02.storageoption.storage.SharedPerferencesActivity;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：存储选项
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 实现逻辑
 * </pre>
 */
public class StorageOptionActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_option);
    }

    /**
     * 按钮点击滴啊用
     *
     * @param view
     */
    public void click(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_storage:
                intent = new Intent(this, InternalStorageActivity.class);
                break;
            case R.id.btn_storage2:
                intent = new Intent(this, ExternalStorageActivity.class);
                break;
            case R.id.btn_storage3:
                intent = new Intent(this, SharedPerferencesActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day02_title4);
    }
}
