package cn.itcast.keeping.ui.details;

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
import cn.itcast.keeping.databinding.FragmentSelfBinding;
import cn.itcast.keeping.ui.hobby.HobbyFragment;
import cn.itcast.keeping.ui.self.SelfViewModel;

public class MessageFragment extends Fragment {
    private FragmentSelfBinding binding;
    private Button backTa;
    private HobbyFragment hobbyFragment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SelfViewModel notificationsViewModel =
                new ViewModelProvider(this).get(SelfViewModel.class);



        binding = FragmentSelfBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.tvSelf;//在fragment_s
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);


        backTa = root.findViewById(R.id.backTa);
        hobbyFragment = new HobbyFragment();
        backTa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_activity_main,hobbyFragment);
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
}
