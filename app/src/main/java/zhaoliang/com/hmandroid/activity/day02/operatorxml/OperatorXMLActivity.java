package zhaoliang.com.hmandroid.activity.day02.operatorxml;

import android.os.Bundle;
import android.os.Environment;
import android.util.Xml;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.activity.day02.operatorxml.bean.Person;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：读写XML
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 实现逻辑
 * </pre>
 */
public class OperatorXMLActivity extends BaseBackActivity {

    List<Person> persons = new ArrayList<>();
    private ListView mList;
    private String mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator_xml);
        mList = (ListView) findViewById(R.id.list);
        mPath = Environment.getExternalStorageDirectory() + File.separator + "persons.xml";
        for (int i = 0; i < 20; i++) {
            persons.add(new Person("张三：" + i, "男", "34892347389"));
        }
    }

    /**
     * 点击Write按钮的时候调用这个方法
     *
     * @param view
     */
    public void write(View view) {
        XmlSerializer xmlSerializer = Xml.newSerializer();
        try {
            xmlSerializer.setOutput(new FileOutputStream(mPath), "utf-8");
            xmlSerializer.startDocument("utf-8", true);

            xmlSerializer.startTag(null, "persons");

            for (Person person : persons) {
                xmlSerializer.startTag(null, "person");

                xmlSerializer.startTag(null, "name");
                xmlSerializer.text(person.name);
                xmlSerializer.endTag(null, "name");

                xmlSerializer.startTag(null, "sex");
                xmlSerializer.text(person.sex);
                xmlSerializer.endTag(null, "sex");

                xmlSerializer.startTag(null, "phone");
                xmlSerializer.text(person.phone);
                xmlSerializer.endTag(null, "phone");

                xmlSerializer.endTag(null, "person");
            }

            xmlSerializer.endTag(null, "persons");

            xmlSerializer.endDocument();
            Toast.makeText(this, "写入成功！", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 点击Read按钮的时候调用这个方法
     *
     * @param view
     */
    public void read(View view) {
        XmlPullParser xmlPullParser = Xml.newPullParser();
        List<Person> personList = null;
        Person person = null;
        try {
            xmlPullParser.setInput(new FileInputStream(mPath), "utf-8");
            int eventType = xmlPullParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name = xmlPullParser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("persons".equals(name))
                            personList = new ArrayList<>();
                        if ("person".equals(name))
                            person = new Person();
                        if ("name".equals(name))
                            person.name = xmlPullParser.nextText();
                        if ("sex".equals(name))
                            person.sex = xmlPullParser.nextText();
                        if ("phone".equals(name))
                            person.phone = xmlPullParser.nextText();
                        break;
                    case XmlPullParser.END_TAG:
                        if ("person".equals(name))
                            personList.add(person);
                        break;
                }
                eventType = xmlPullParser.next();
            }
            mList.setAdapter(new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, personList));
            Toast.makeText(this, "解析成功！", Toast.LENGTH_SHORT).show();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day02_title5);
    }
}
