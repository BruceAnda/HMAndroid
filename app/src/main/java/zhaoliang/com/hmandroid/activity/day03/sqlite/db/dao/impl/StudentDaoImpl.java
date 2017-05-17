package zhaoliang.com.hmandroid.activity.day03.sqlite.db.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import zhaoliang.com.hmandroid.activity.day03.sqlite.bean.Student;
import zhaoliang.com.hmandroid.activity.day03.sqlite.db.StudentOpenHelper;
import zhaoliang.com.hmandroid.activity.day03.sqlite.db.dao.IStudentDao;

/**
 * Created by zhaoliang on 2017/5/16.
 */

public class StudentDaoImpl implements IStudentDao {

    private Context context;
    private StudentOpenHelper openHelper;
    private SQLiteDatabase db;

    public StudentDaoImpl(Context context) {
        this.context = context;
    }

    @Override
    public void setUp() {
        openHelper = new StudentOpenHelper(context);
        db = openHelper.getWritableDatabase();
    }

    @Override
    public void release() {
        if (db != null && db.isOpen()) {
            db.close();
            db = null;
            openHelper = null;
        }
    }

    @Override
    public void insertSql(Student student) {
        db.execSQL("insert into student(name, sex, phone) values(?, ?, ?)", new String[]{student.name, student.sex, student.phone});
    }

    @Override
    public void insertApi(Student student) {
        ContentValues values = new ContentValues();
        values.put("name", student.name);
        values.put("sex", student.sex);
        values.put("phone", student.phone);
        db.insert("student", null, values);
    }

    @Override
    public void deleteSql(int id) {
        db.execSQL("delete from student where _id = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public void deleteApi(int id) {
        db.delete("student", "_id = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public void updateSql(Student student) {
        db.execSQL("update student set name = ?, sex = ?, phone = ? where _id = ?", new String[]{student.name, student.sex, student.phone, String.valueOf(student._id)});
    }

    @Override
    public void updateApi(Student student) {
        ContentValues values = new ContentValues();
        values.put("name", student.name);
        values.put("sex", student.sex);
        values.put("phone", student.phone);
        db.update("student", values, "_id = ?", new String[]{String.valueOf(student._id)});
    }

    @Override
    public Student selectOneSql(int id) {
        Student student = null;
        Cursor cursor = db.rawQuery("select * from student where _id = ?", new String[]{String.valueOf(id)});
        if (cursor.moveToNext()) {
            student = new Student();
            student._id = cursor.getInt(cursor.getColumnIndex("_id"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.sex = cursor.getString(cursor.getColumnIndex("sex"));
            student.phone = cursor.getString(cursor.getColumnIndex("phone"));
        }
        return student;
    }

    @Override
    public Student selectOneApi(int id) {
        Student student = null;
        Cursor cursor = db.query("student", null, "_id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToNext()) {
            student = new Student();
            student._id = cursor.getInt(cursor.getColumnIndex("_id"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.sex = cursor.getString(cursor.getColumnIndex("sex"));
            student.phone = cursor.getString(cursor.getColumnIndex("phone"));
        }
        return student;
    }

    @Override
    public List<Student> selectAllSql() {
        List<Student> students = new ArrayList<>();
        Student student = null;
        Cursor cursor = db.rawQuery("select * from student", null);
        while (cursor.moveToNext()) {
            student = new Student();
            student._id = cursor.getInt(cursor.getColumnIndex("_id"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.sex = cursor.getString(cursor.getColumnIndex("sex"));
            student.phone = cursor.getString(cursor.getColumnIndex("phone"));
            students.add(student);
        }
        return students;
    }

    @Override
    public List<Student> selectAllApi() {
        List<Student> students = new ArrayList<>();
        Student student = null;
        Cursor cursor = db.query("student", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            student = new Student();
            student._id = cursor.getInt(cursor.getColumnIndex("_id"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.sex = cursor.getString(cursor.getColumnIndex("sex"));
            student.phone = cursor.getString(cursor.getColumnIndex("phone"));
            students.add(student);
        }
        return students;
    }

    @Override
    public List<Student> selectPageSql(int page, int pageSize) {
        List<Student> students = new ArrayList<>();
        Student student = null;
        Cursor cursor = db.rawQuery("select * from student limit ?, ?", new String[]{String.valueOf((page - 1) * pageSize), String.valueOf(pageSize)});
        while (cursor.moveToNext()) {
            student = new Student();
            student._id = cursor.getInt(cursor.getColumnIndex("_id"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.sex = cursor.getString(cursor.getColumnIndex("sex"));
            student.phone = cursor.getString(cursor.getColumnIndex("phone"));
            students.add(student);
        }
        return students;
    }

    @Override
    public List<Student> selectPageApi(int page, int pageSize) {
        List<Student> students = new ArrayList<>();
        Student student = null;
        Cursor cursor = db.query("student", null, null, null, null, null, null, (page - 1) * pageSize + ", " + pageSize);
        while (cursor.moveToNext()) {
            student = new Student();
            student._id = cursor.getInt(cursor.getColumnIndex("_id"));
            student.name = cursor.getString(cursor.getColumnIndex("name"));
            student.sex = cursor.getString(cursor.getColumnIndex("sex"));
            student.phone = cursor.getString(cursor.getColumnIndex("phone"));
            students.add(student);
        }
        return students;
    }

    @Override
    public void transaction(Student a, Student b) {
        try {
            db.beginTransaction();
            updateSql(a);
            updateApi(b);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }
}
