package zhaoliang.com.hmandroid.day03.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import zhaoliang.com.hmandroid.activity.day03.sqlite.db.StudentOpenHelper;

/**
 * Created by zhaoliang on 2017/5/16.
 */

@RunWith(AndroidJUnit4.class)
public class TestStudentOpenHelper {

    @Test
    public void testStudentOpenHelper() {
        SQLiteOpenHelper sqLiteOpenHelper = new StudentOpenHelper(InstrumentationRegistry.getTargetContext());
        SQLiteDatabase writableDatabase = sqLiteOpenHelper.getWritableDatabase();
    }
}
