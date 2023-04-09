package cn.itcast.keeping.ui.hobby;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import cn.itcast.keeping.R;
import cn.itcast.keeping.databinding.FragmentHobbyBinding;
import cn.itcast.keeping.ui.details.MessageFragment;
import cn.itcast.keeping.ui.home.HomeViewModel;
import cn.itcast.keeping.ui.things.ThingsFragment;

public class HobbyFragment extends Fragment {

    private FragmentHobbyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHobbyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHobby;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        it_thing = root.findViewById(R.id.it_thing);
        thingsFragment = new ThingsFragment();
        it_thing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main,thingsFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        ScrollView scroll = root.findViewById(R.id.scroll);
        ImageView imageView = root.findViewById(R.id.all_read);
        speak= root.findViewById(R.id.speak);
        read = root.findViewById(R.id.read);
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.speak);
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.read);
            }
        });

        message = root.findViewById(R.id.message);
        messageFragment = new MessageFragment();
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main,messageFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private Button it_thing,speak,read,message;
    private ThingsFragment thingsFragment;
    private MessageFragment messageFragment;

}