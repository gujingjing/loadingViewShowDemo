package huanxin.gjj.loadingandretrymanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import huanxin.gjj.loadingandretrymanager.loading.LoadingAndRetryManager;
import huanxin.gjj.loadingandretrymanager.loading.OnLoadingAndRetryListener;

/**
 * https://github.com/hongyangAndroid/LoadingAndRetryManager
 */
public class MainActivity extends AppCompatActivity {

    LoadingAndRetryManager mLoadingAndRetryManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //为任何View添加，只需要将第一个参数改成对应的View即可。
        TextView textView= (TextView) findViewById(R.id.tv);
        mLoadingAndRetryManager = LoadingAndRetryManager.generate(textView, new OnLoadingAndRetryListener() {
            @Override
            public void setRetryEvent(View retryView) {//设置retory点击事件
                View view = retryView.findViewById(R.id.id_btn_retry);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mLoadingAndRetryManager.showLoading();
                        new android.os.Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mLoadingAndRetryManager.showRetry();
                            }
                        },3000);
                    }
                });
            }
        });
//        mLoadingAndRetryManager.showContent();
//        mLoadingAndRetryManager.showRetry();
        mLoadingAndRetryManager.showLoading();
//        mLoadingAndRetryManager.showEmpty();
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mLoadingAndRetryManager.showRetry();
            }
        },3000);
    }
}
