package com.example.sean.eventbustest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private TextView tv_message;
    private Button bt_message;
    private Button bt_subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_message = (TextView) findViewById(R.id.tv_message);
        bt_message = (Button) findViewById(R.id.bt_message);
        bt_subscription = (Button) findViewById(R.id.bt_subscription);

        tv_message.setText("MainActivity");
        bt_subscription.setText("注册事件");
        bt_message.setText("跳转到SecondActivity");

        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        bt_subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注册事件
                EventBus.getDefault().register(MainActivity.this);  //注册事件
            }
        });
    }


    /*
    * 自定义方法来处理事件，线程模式设置为MAIN，事件的
    * 处理会在UI线程，用TextView来展示收到的事件信息
    * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent) {
        tv_message.setText(messageEvent.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销注册事件
        EventBus.getDefault().unregister(this);
    }
}
