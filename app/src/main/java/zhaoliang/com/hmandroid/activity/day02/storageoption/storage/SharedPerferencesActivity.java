package zhaoliang.com.hmandroid.activity.day02.storageoption.storage;

import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Map;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day02.storageoption.util.StorageUtil;

/**
 * <pre>
 *     SharedPreferences
 * </pre>
 */
public class SharedPerferencesActivity extends BaseStorageActivity {

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSharedPreferences = getSharedPreferences("account", MODE_APPEND);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Map<String, String> readAccount() {
        return StorageUtil.readAccount(mSharedPreferences);
    }

    @Override
    protected boolean saveAccount(String usernameStr, String passwordStr) {
        return StorageUtil.saveAccount(mSharedPreferences, usernameStr, passwordStr);
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day02_values56);
    }
}
