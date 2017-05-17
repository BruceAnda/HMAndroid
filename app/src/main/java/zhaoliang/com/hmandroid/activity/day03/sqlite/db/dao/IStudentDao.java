package zhaoliang.com.hmandroid.activity.day03.sqlite.db.dao;

import java.util.List;

import zhaoliang.com.hmandroid.activity.day03.sqlite.bean.Student;

/**
 * Created by zhaoliang on 2017/5/16.
 */

public interface IStudentDao {

    void insertSql(Student student);

    void insertApi(Student student);

    void deleteSql(int id);

    void deleteApi(int id);

    void updateSql(Student student);

    void updateApi(Student student);

    Student selectOneSql(int id);

    Student selectOneApi(int id);

    List<Student> selectAllSql();

    List<Student> selectAllApi();

    List<Student> selectPageSql(int page, int pageSize);

    List<Student> selectPageApi(int page, int pageSize);

    void transaction(Student a, Student b);

    void setUp();

    void release();
}
