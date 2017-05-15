package zhaoliang.com.hmandroid.activity.day02.storageoption.storage;

import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.util.Map;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day02.storageoption.util.StorageUtil;

/**
 * <pre>
 *     外部存储
 * </pre>
 */
public class ExternalStorageActivity extends BaseStorageActivity {

    private String mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPath = Environment.getExternalStorageDirectory() + File.separator + "account.txt";
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Map<String, String> readAccount() {
        return StorageUtil.readAccount(mPath);
    }

    @Override
    protected boolean saveAccount(String usernameStr, String passwordStr) {
        return StorageUtil.saveAccount(mPath, usernameStr, passwordStr);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day02_values55);
    }
}
