package zhaoliang.com.hmandroid.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 整个应用的Application
 * Created by zhaoliang on 2017/5/9.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
