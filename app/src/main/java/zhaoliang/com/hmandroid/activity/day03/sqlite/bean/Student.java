package zhaoliang.com.hmandroid.activity.day03.sqlite.bean;

/**
 * 学生bean
 * Created by zhaoliang on 2017/5/16.
 */

public class Student {

    public Integer _id;
    public String name;
    public String sex;
    public String phone;

    public Student() {
    }

    public Student(String name, String sex, String phone) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    public Student(Integer _id, String name, String sex, String phone) {
        this._id = _id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
