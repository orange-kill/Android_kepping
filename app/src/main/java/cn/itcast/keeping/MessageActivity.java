package cn.itcast.keeping;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.itcast.keeping.ui.self.SelfFragment;

public class MessageActivity extends Activity {
    private ImageView btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        init();
    }
    @SuppressLint("WrongViewCast")
    private void init(){
        btn_return = findViewById(R.id.iv1_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass( MessageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}