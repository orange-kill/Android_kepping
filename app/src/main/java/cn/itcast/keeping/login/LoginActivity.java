package cn.itcast.keeping.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.itcast.keeping.R;

public class LoginActivity extends AppCompatActivity {
    private TextView phone;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone = findViewById(R.id.phoneNumber);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String number = phone.getText().toString();
                    if (number.length()<1){
                        Toast.makeText(LoginActivity.this, "必须输入电话号码", Toast.LENGTH_SHORT).show();
                    }else{
                        if(number.charAt(0)=='1' && isNumeric(number) && number.length()==11){
                            //是合法的电话号码，进行页面跳转
                            Intent intent = new Intent();
                            intent.putExtra("phoneNumber",number);
                            //前一个是目前页面，后面一个是要跳转的下一个页面
                            intent.setClass(LoginActivity.this,VerificationActivity.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(LoginActivity.this, "请输入正确的电话号码", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        });


    }

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}