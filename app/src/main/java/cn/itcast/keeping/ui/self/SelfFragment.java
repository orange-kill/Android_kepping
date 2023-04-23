package cn.itcast.keeping.ui.self;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import cn.itcast.keeping.MessageActivity;
import cn.itcast.keeping.R;
import cn.itcast.keeping.ReplayActivity;
import cn.itcast.keeping.databinding.FragmentSelfBinding;

public class SelfFragment extends Fragment {
    private FragmentSelfBinding binding;
    private ImageView btn_message,btn_replay;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        SelfViewModel notificationsViewModel =
//                new ViewModelProvider(this).get(SelfViewModel.class);
//
//
//
//        binding = FragmentSelfBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
////        final TextView textView = binding.tvSelf;//在fragment_s
////        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;

        View v = inflater.inflate(R.layout.fragment_self,container,false);
        btn_message = v.findViewById(R.id.iv_message);
        btn_replay = v.findViewById(R.id.iv_replay);
        btn_message.setOnClickListener(view -> {
            Intent i = new Intent();
            i.setClass(getActivity(), MessageActivity.class);
            startActivity(i);
        });
        btn_replay.setOnClickListener(view ->{
            Intent intent = new Intent();
            intent.setClass(getActivity(), ReplayActivity.class);
            startActivity(intent);
        });
        return v;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
