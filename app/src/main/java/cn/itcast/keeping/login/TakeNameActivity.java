package cn.itcast.keeping.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import cn.itcast.keeping.R;

public class TakeNameActivity extends AppCompatActivity {
    private Button confirm;
    private EditText userName;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_name);
        userName = findViewById(R.id.userName);
        confirm = findViewById(R.id.confirm);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        String number = intent.getStringExtra("phoneNumber");
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getText().toString();
                System.out.println("输入的名称为:"+name);
                if (name.equals(" ") || name.length()>20){
                    Toast.makeText(TakeNameActivity.this,"用户名不能为空，长度不超过20个字符",Toast.LENGTH_SHORT);
                }else{
                    Intent intent = new Intent();
                    intent.putExtra("phoneNumber",number);
                    intent.putExtra("uerName",name);
                    intent.setClass(TakeNameActivity.this,ChoseSexActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}