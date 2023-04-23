package cn.itcast.keeping.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.itcast.keeping.R;

public class VerificationActivity extends AppCompatActivity {
    private EditText num_in1_et, num_in2_et, num_in3_et, num_in4_et;
    private Button confirm;
    private TextView text;
    private TextView countdown;
    private CountDownTimer timer;
    private ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        num_in1_et = findViewById(R.id.num_in1_et);
        num_in2_et = findViewById(R.id.num_in2_et);
        num_in3_et = findViewById(R.id.num_in3_et);
        num_in4_et = findViewById(R.id.num_in4_et);

        confirm = findViewById(R.id.confirm);
        text = findViewById(R.id.text);
        countdown = findViewById(R.id.number);

        Intent intent = getIntent();
        String number = intent.getStringExtra("phoneNumber");

        interview();

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interview();
            }
        });
        //addTextChangedListener设置监听文本变化，有输入跳转到下一个输入框
        num_in1_et.addTextChangedListener(new TextChangeLister(num_in1_et,num_in2_et));

        //setOnKeyListener设置监听键盘删除操作，删除完之后跳转到上一个输入框
        num_in2_et.setOnKeyListener(new MyOnKeyListenr(num_in1_et, num_in2_et));

        num_in2_et.addTextChangedListener(new TextChangeLister(num_in2_et,num_in3_et));

        num_in3_et.setOnKeyListener(new MyOnKeyListenr(num_in2_et, num_in3_et));
        num_in3_et.addTextChangedListener(new TextChangeLister(num_in3_et,num_in4_et));

        num_in4_et.setOnKeyListener(new MyOnKeyListenr(num_in3_et, num_in4_et));

       confirm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String code = num_in1_et.getText().toString()+num_in2_et.getText().toString()
                       +num_in3_et.getText().toString()+num_in4_et.getText().toString();
               System.out.println(code);
               if (code.equals("1234")){
                   Intent intent = new Intent();
                   intent.putExtra("phoneNumber",number);
                   intent.setClass(VerificationActivity.this,TakeNameActivity.class);
                   startActivity(intent);

               }else{
                   Toast.makeText(VerificationActivity.this,"验证码错误",Toast.LENGTH_SHORT);
               }
           }
       });

       back = findViewById(R.id.back);
       back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               finish();
           }
       });
    }

    private void interview(){
        //（总时间，间隔）
        timer = new CountDownTimer(60000,1000){
            @Override
            public void onTick(long l) {
                text.setClickable(false);
                text.setEnabled(false);
                text.setText("重新获取");
                text.setTextColor(Color.parseColor("#FF000000"));
                countdown.setText(l/1000+" s");

            }

            @Override
            public void onFinish() {
                text.setClickable(true);
                text.setEnabled(true);
                text.setText("获取验证码");
                text.setTextColor(Color.parseColor("#7468be"));
                countdown.setText(" ");
                cancel();
            }
        }.start();
    }
}
//自定义文本变化监听类
class TextChangeLister implements TextWatcher {
    private EditText thisEt,newxtEt;
    public TextChangeLister(EditText thisEt,EditText newxtEt){
        this.thisEt=thisEt;
        this.newxtEt=newxtEt;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //text 输入框中改变后的字符串信息
        //start 输入框中改变后的字符串的起始位置
        //before 输入框中改变前的字符串的位置 默认为0
        //count 输入框中改变后的一共输入字符串的数量
        if(before==0&&count==1){
            thisEt.clearFocus();
            newxtEt.requestFocus();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

//自定义键盘监听
class MyOnKeyListenr implements View.OnKeyListener {
    private EditText upDt, thisDt;

    public MyOnKeyListenr(@Nullable EditText upDt, @Nullable EditText thisDt) {
        this.upDt = upDt;
        this.thisDt = thisDt;
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        Log.i("键盘监控", "view:" + view + "   i:" + i + "   keyEvent:" + keyEvent.toString());
        if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_DEL) {  //如果上一个输入框不为空
            if (upDt != null && thisDt.getText().toString().isEmpty()) {
                thisDt.clearFocus();
                upDt.requestFocus();
            }
            return false;
        }
        return false;
    }
}

