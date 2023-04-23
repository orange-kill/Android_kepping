package cn.itcast.keeping.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import cn.itcast.keeping.MainActivity;
import cn.itcast.keeping.R;

public class ChoseSexActivity extends AppCompatActivity {
    private ImageView back;
    private ImageView male;
    private ImageView female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_sex);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        String number = intent.getStringExtra("phoneNumber");
        String name = intent.getStringExtra("userName");

        male = findViewById(R.id.male);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("sex","male");
                intent.setClass(ChoseSexActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        female = findViewById(R.id.female);
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("sex","female");
                intent.putExtra("phoneNumber",number);
                intent.putExtra("uerName",name);
                intent.setClass(ChoseSexActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}