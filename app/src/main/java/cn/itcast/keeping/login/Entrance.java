package cn.itcast.keeping.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.itcast.keeping.R;

public class Entrance extends AppCompatActivity {
    private ConstraintLayout layout;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

       textView = findViewById(R.id.textView);
       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
               //前一个是目前页面，后面一个是要跳转的下一个页面
               intent.setClass(Entrance.this,LoginActivity.class);
               startActivity(intent);
           }
       });

       imageView = findViewById(R.id.image);
       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent();
               //前一个是目前页面，后面一个是要跳转的下一个页面
               intent.setClass(Entrance.this,LoginActivity.class);
               startActivity(intent);
           }
       });
    }
}