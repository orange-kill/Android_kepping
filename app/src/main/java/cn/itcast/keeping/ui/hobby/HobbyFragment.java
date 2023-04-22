package cn.itcast.keeping.ui.hobby;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cn.itcast.keeping.Entity.Hobby;
import cn.itcast.keeping.R;

public class HobbyFragment extends Fragment {

    private String[] titles = {"读书", "跑步", "口语", "绘画"};
    private String[] signs = {"书中自由黄金屋 书中自有颜如玉", "我运动 我快乐 遇到最好的自己", "Practice makes perfect", "用画笔描述美好的生活"};
    private int[] attends = {1567, 204, 122, 435};//参加人数
    private String[] dynamic = {"20.3", "50k", "10.9k", "356"};//发动态人数
    private int[] people = {954, 123, 64, 64};//养成习惯人数
    private int[] money = {3698, 1567, 943, 943};//奖金池
    private int[] img = {R.drawable.hobby_read, R.drawable.hobby_run, R.drawable.hobby_lag, R.drawable.hobby_draw};

    private int[] img_people = {R.drawable.book,R.drawable.hobby_run, R.drawable.hobby_lag, R.drawable.hobby_draw};
    private String[] near_position = {"1.7km","1.8km","3.2km","3.2km"};
    private String[] near_name = {"邓多多","圆圆","tom","jack"};
    private int[] near_people_count = {219,21,111,24};


    FragmentManager fragmentManager;
    HobbyQuanFragment hobbyQuanFragment;
    HobbyNearFragment nearFragment;

    TextView tv_hobby_quan, tv_hobby_near;
    List<Hobby> hobbies = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getListData();
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hobby, container, false);

        tv_hobby_near = view.findViewById(R.id.tv_hobby_near);
        tv_hobby_quan = view.findViewById(R.id.tv_hobby_quan);

        fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        nearFragment = new HobbyNearFragment().getInstance(hobbies);
        hobbyQuanFragment = new HobbyQuanFragment().getInstance(hobbies);
        fragmentTransaction.replace(R.id.quan_fragment, hobbyQuanFragment);
//        fragmentTransaction.replace(R.id.near_fragment, nearFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        init();
        return view;
    }


    public void init() {
        tv_hobby_near.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.quan_fragment, nearFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        tv_hobby_quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.quan_fragment, hobbyQuanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    public void getListData() {
        for (int i = 0; i < titles.length; i++) {
            Hobby hobby = new Hobby();
            hobby.setName(titles[i]);
            hobby.setImage(img[i]);
            hobby.setSign(signs[i]);
            hobby.setDetail_one(attends[i] + "人参加 ｜ " + dynamic[i] + "条动态");
            hobby.setDetail_two("帮助" + people[i] + "人养成习惯");
            hobby.setImage(img[i]);
            hobby.setMoney(money[i]);

            hobby.setNear_position(near_position[i]);
            hobby.setNear_people_name(near_name[i]);
            hobby.setGetNear_people_img(img_people[i]);
            hobby.setNear_people_count(near_people_count[i]);

            hobbies.add(hobby);
        }
    }
}