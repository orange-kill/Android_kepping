package cn.itcast.keeping.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

import cn.itcast.keeping.Entity.Hobby;
import cn.itcast.keeping.R;
import cn.itcast.keeping.ui.hobby.HobbyFragment;

public class HobbyQuanActivity extends Activity {

    private ImageView ig_return;
    private Button btn_enter_quan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby_detail);
        init();
    }

    public void init() {

        //获取传过来的数据
        Bundle bundle = getIntent().getExtras();
        Hobby hobby = (Hobby) bundle.getSerializable("hobby");
        Log.i("接收到的fragment传过来的数据", String.valueOf(Objects.isNull(hobby)));

        ig_return = findViewById(R.id.ig_icon_return_one);
        btn_enter_quan = findViewById(R.id.btn_enter_quan);


        ig_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });


        btn_enter_quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HobbyQuanActivity.this, EnterHobbyActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("hobby",hobby);
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });
    }
}
