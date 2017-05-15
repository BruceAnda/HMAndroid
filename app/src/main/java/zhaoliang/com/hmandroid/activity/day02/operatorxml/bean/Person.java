package zhaoliang.com.hmandroid.activity.day02.operatorxml.bean;

/**
 * Created by zhaoliang on 2017/5/15.
 */

public class Person {

    public String name;
    public String sex;
    public String phone;

    public Person() {
    }

    public Person(String name, String sex, String phone) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
