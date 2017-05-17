package zhaoliang.com.hmandroid.day03.sqlite;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import zhaoliang.com.hmandroid.activity.day03.sqlite.bean.Student;
import zhaoliang.com.hmandroid.activity.day03.sqlite.db.dao.IStudentDao;
import zhaoliang.com.hmandroid.activity.day03.sqlite.db.dao.impl.StudentDaoImpl;

/**
 * Created by zhaoliang on 2017/5/16.
 */

@RunWith(AndroidJUnit4.class)
public class TestIStudentDao {

    IStudentDao studentDao;

    @Before
    public void setUp() throws Exception {
        studentDao = new StudentDaoImpl(InstrumentationRegistry.getTargetContext());
        studentDao.setUp();
    }

    @After
    public void tearDown() throws Exception {
        studentDao.release();
    }

    @Test
    public void testInsertSql() {
        for (int i = 0; i < 20; i++) {
            studentDao.insertSql(new Student("张三" + i, "男", "15116970788"));
        }
    }

    @Test
    public void testInsertApi() {
        for (int i = 0; i < 20; i++) {
            studentDao.insertApi(new Student("李四" + i, "女", "15116970789"));
        }
    }

    @Test
    public void testDeleteSql() {
        studentDao.deleteSql(1);
    }

    @Test
    public void testDeleteApi() {
        studentDao.deleteApi(2);
    }

    @Test
    public void testUpdateSql() {
        Student student = new Student(3, "张三", "男", "15116970788");
        studentDao.updateSql(student);
    }

    @Test
    public void testUpdateApi() {
        Student student = new Student(4, "张三", "男", "15116970789");
        studentDao.updateApi(student);
    }

    @Test
    public void testSelectOneSql() {
        Student student = studentDao.selectOneSql(3);
        System.out.println(student);
    }

    @Test
    public void testSelectOneApi() {
        Student student = studentDao.selectOneApi(4);
        System.out.println(student);
    }

    @Test
    public void testSelectAllSql() {
        List<Student> students = studentDao.selectAllSql();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectAllApi() {
        List<Student> students = studentDao.selectAllApi();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectPageSql() {
        List<Student> students = studentDao.selectPageSql(2, 3);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectPageApi() {
        List<Student> students = studentDao.selectPageApi(2, 3);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testTransaction() {
        Student student = new Student(5, "张三", "男", "15116970788");
        Student student2 = new Student(6, "张三", "男", "15116970788");
        studentDao.transaction(student, student2);
    }
}
