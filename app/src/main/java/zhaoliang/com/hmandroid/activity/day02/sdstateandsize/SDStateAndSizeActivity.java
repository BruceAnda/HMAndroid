package zhaoliang.com.hmandroid.activity.day02.sdstateandsize;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.widget.TextView;

import zhaoliang.com.hmandroid.R;
import zhaoliang.com.hmandroid.base.BaseBackActivity;

/**
 * <pre>
 *     需求：读取AndroidSD的状态和大小
 *     思路：
 *          1. 新建一个Activity
 *          2. 编写布局文件
 *          3. 读取SD卡信息显示
 * </pre>
 */
public class SDStateAndSizeActivity extends BaseBackActivity {

    private TextView mTvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdstate_and_size);

        mTvInfo = (TextView) findViewById(R.id.tv_info);

        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2) {
            long blockSizeLong = statFs.getBlockSizeLong();
            long blockCountLong = statFs.getBlockCountLong();
            long availableBlocksLong = statFs.getAvailableBlocksLong();
            mTvInfo.setText(Environment.getExternalStorageState() + "\n" +
                    "区块大小：" + blockSizeLong + "\n" +
                    "总空间：" + Formatter.formatFileSize(this, blockSizeLong * blockCountLong) + "\n" +
                    "可用空间：" + Formatter.formatFileSize(this, blockSizeLong * availableBlocksLong));
        } else {
            int blockSize = statFs.getBlockSize();
            int blockCount = statFs.getBlockCount();
            int availableBlocks = statFs.getAvailableBlocks();
            mTvInfo.setText(Environment.getExternalStorageState() + "\n" +
                    "区块大小：" + blockSize + "\n" +
                    "总空间：" + Formatter.formatFileSize(this, blockSize * blockCount) + "\n" +
                    "可用空间：" + Formatter.formatFileSize(this, blockSize + availableBlocks));
        }
    }

    @Override
    protected String setActionBarTitle() {
        return getString(R.string.day02_title3);
    }
}
