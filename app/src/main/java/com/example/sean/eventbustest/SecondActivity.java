package com.example.sean.eventbustest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    private Button bt_message;
    private TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bt_message = (Button) findViewById(R.id.bt_message);
        tv_message = (TextView) findViewById(R.id.tv_message);

        tv_message.setText("SecondActivity");
        bt_message.setText("发送事件");

        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("你好啊二哈"));  //发送事件，发送的事件是一个字符串,也可以是一个对象，取决于你的实体类
                finish();  //销毁activity
            }
        });
    }
}
