package zhaoliang.com.hmandroid.activity.day03.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库打开帮助器类
 * Created by zhaoliang on 2017/5/16.
 */

public class StudentOpenHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "student.db";
    private static final int DB_VERSION = 1;

    public StudentOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(_id Integer primary key autoincrement, name varchar(20), sex varchar(20), phone varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
