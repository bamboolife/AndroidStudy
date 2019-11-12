package com.sundy.task;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * activity 默认启动模式为 standar可以不用在 AndroidManifest.xml 设置android:launchMode="standard"
 */
public class StandardActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StandardActivity.this,StandardActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
