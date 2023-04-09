package cn.itcast.keeping.ui.wreath;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cn.itcast.keeping.databinding.FragmentHomeBinding;
import cn.itcast.keeping.databinding.FragmentWreathBinding;
import cn.itcast.keeping.ui.home.HomeViewModel;

public class WreathFragment extends Fragment {

    private FragmentWreathBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentWreathBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textWreath;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
