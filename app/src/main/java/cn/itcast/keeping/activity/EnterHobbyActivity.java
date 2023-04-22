package cn.itcast.keeping.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import cn.itcast.keeping.Entity.Hobby;
import cn.itcast.keeping.MainActivity;
import cn.itcast.keeping.R;
import cn.itcast.keeping.ui.hobby.HobbyFragment;

public class EnterHobbyActivity extends FragmentActivity {


    private Button btn_enter_thing;
    private ImageView ig_return_detail;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_quan);
        init();
    }


    public void init() {
        btn_enter_thing = findViewById(R.id.btn_enter_things);
        ig_return_detail = findViewById(R.id.ig_icon_return_two);

        Hobby hobby = (Hobby) getIntent().getExtras().getSerializable("hobby");


        ig_return_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btn_enter_thing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EnterHobbyActivity.this, MainActivity.class);
                intent.putExtra("hobby", hobby);
                startActivity(intent);

                // 获取FragmentManager
                FragmentManager fragmentManager = getSupportFragmentManager();

// 开始FragmentTransaction事务
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

// 创建并添加目标Fragment
                HobbyFragment myFragment = new HobbyFragment();
                fragmentTransaction.add(R.id.fragment_hobby, myFragment);

// 设置选中导航栏的某个选项卡
                BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
                bottomNavigationView.setSelectedItemId(R.id.navigation_things);

// 提交FragmentTransaction事务
                fragmentTransaction.commit();


            }
        });
    }


}
