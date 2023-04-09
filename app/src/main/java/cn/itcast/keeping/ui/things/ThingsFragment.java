package cn.itcast.keeping.ui.things;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import cn.itcast.keeping.R;
import cn.itcast.keeping.databinding.FragmentThingsBinding;
import cn.itcast.keeping.ui.home.HomeFragment;

public class ThingsFragment extends Fragment {
    private FragmentThingsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ThingsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(ThingsViewModel.class);



        binding = FragmentThingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textThings;//在fragment_things.xml中的ID
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        add = root.findViewById(R.id.add);
        homeFragment = new HomeFragment();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main, homeFragment);
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


    private Button add;
    private HomeFragment homeFragment;
}
