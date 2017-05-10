package zhaoliang.com.hmandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

/**
 * Created by zhaoliang on 2017/5/10.
 */

public abstract class BaseBackActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(setActionBarTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected abstract String setActionBarTitle();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
