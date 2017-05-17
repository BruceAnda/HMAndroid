package zhaoliang.com.hmandroid.activity.day03.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：Dialog的使用
 *     思路：
 *          1. 创建一个Activity
 *          2. 编写布局文件
 *          3. 实现逻辑
 * </pre>
 */
public class DialogActivity extends BaseBackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    /**
     * 点击Dialog按钮的时候调用这个方法
     *
     * @param view
     */
    public void dialog(View view) {
        switch (view.getId()) {
            case R.id.btn_dialog:
                new AlertDialog.Builder(this).setTitle("提示！").setMessage("欲练此功，必先自宫！").setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "若不自宫，定不成功！", Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "祝早日练成神功！", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.btn_single_dialog:
                final String[] items = {"男", "女", "保密"};
                new AlertDialog.Builder(this).setTitle("选择性别！").setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(DialogActivity.this, "你的性别是：" + items[which], Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.btn_mutiple_dialog:
                final String[] items1 = {"苹果", "香蕉", "葡萄", "桔子"};
                final boolean[] checkedItems = {false, false, false, false};
                new AlertDialog.Builder(this).setTitle("选择你喜欢的水果！").setMultiChoiceItems(items1, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < items1.length; i++) {
                            if (checkedItems[i]) {
                                sb.append(items1[i] + ",");
                            }
                        }
                        Toast.makeText(DialogActivity.this, "你喜欢的水果有：" + sb.substring(0, sb.lastIndexOf(",")), Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
        }
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day03_title4);
    }
}
