package com.zlove.upgrade.rx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.zlove.upgrade.R;
import com.zlove.upgrade.rx.method.SubscribeMethod;

/**
 * Created by ZLOVE on 17/9/23.
 */

public abstract class BaseRxActivity extends AppCompatActivity {

    protected TextView tvContent;
    protected SubscribeMethod method;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        tvContent = (TextView) findViewById(R.id.content);
        initMethod();

        findViewById(R.id.subscribe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subscribe();
            }
        });

    }

    protected abstract void initMethod();
    protected abstract void subscribe();

    @Override
    protected void onStop() {
        super.onStop();
        if (method != null) {
            method.unsubscribe();
        }
    }
}
