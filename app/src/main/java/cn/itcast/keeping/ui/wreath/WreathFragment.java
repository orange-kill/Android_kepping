package cn.itcast.keeping.ui.wreath;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import java.util.zip.Inflater;

import cn.itcast.keeping.R;
import cn.itcast.keeping.databinding.FragmentHomeBinding;
import cn.itcast.keeping.databinding.FragmentWreathBinding;
import cn.itcast.keeping.ui.home.HomeViewModel;

public class WreathFragment extends Fragment implements View.OnClickListener {

    private FragmentWreathBinding binding;
    private ImageView btn_f1,btn_f2,btn_f3,btn_f4,btn_f5,btn_f6,btn_pick;
    private TextView text1,text2,text3,text4,text5,text6;
    private int count_flower = 0;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentWreathBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textWreath;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
        View v = inflater.inflate(R.layout.fragment_wreath,container,false);
        btn_f1 = v.findViewById(R.id.iv_f1);
        btn_f2 = v.findViewById(R.id.iv_f2);
        btn_f3 = v.findViewById(R.id.iv_f3);
        btn_f4 = v.findViewById(R.id.iv_f4);
        btn_f5 = v.findViewById(R.id.iv_f5);
        btn_pick= v.findViewById(R.id.iv_pick);
        btn_f1.setOnClickListener(this);
        btn_f2.setOnClickListener(this);
        btn_f3.setOnClickListener(this);
        btn_f4.setOnClickListener(this);
        btn_f5.setOnClickListener(this);
        btn_pick.setOnClickListener(this);
        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_f1:
                info(btn_f1);
                break;
            case R.id.iv_f2:
                info(btn_f2);
                break;
            case R.id.iv_f3:
                info(btn_f3);
                break;
            case R.id.iv_f4:
                info(btn_f4);
                break;
            case R.id.iv_f5:
                info(btn_f5);
                break;
            case R.id.iv_pick:
            {
                info(btn_f1);
                info(btn_f2);
                info(btn_f3);
                info(btn_f4);
                info(btn_f5);
            }
                break;
        }
    }

    private void info(ImageView btn) {
        count_flower++;
        btn.setVisibility(View.INVISIBLE);
    }
}
