package huanxin.gjj.loadingandretrymanager;

import android.app.Application;

import huanxin.gjj.loadingandretrymanager.loading.LoadingAndRetryManager;

/**
 * 作者：gjj on 2016/1/14 17:12
 * 邮箱：Gujj512@163.com
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLoadingAndRetry();
    }
    private void initLoadingAndRetry() {
        LoadingAndRetryManager.BASE_RETRY_LAYOUT_ID = R.layout.act_base_retry;
        LoadingAndRetryManager.BASE_LOADING_LAYOUT_ID = R.layout.act_base_loading;
        LoadingAndRetryManager.BASE_EMPTY_LAYOUT_ID = R.layout.act_base_empty;
    }
}
