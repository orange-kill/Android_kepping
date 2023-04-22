package cn.itcast.keeping.ui.hobby;

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

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import cn.itcast.keeping.Entity.Hobby;
import cn.itcast.keeping.R;

public class HobbyQuanFragment extends Fragment {

    private ListView lv_list;


    public HobbyQuanFragment getInstance(List<Hobby> list){
        HobbyQuanFragment hobbyQuanFragment = new HobbyQuanFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("quanList", (Serializable) list);
        hobbyQuanFragment.setArguments(bundle);
        Log.i("设置quanList-------", Objects.toString(list));
        return hobbyQuanFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View  view = inflater.inflate(R.layout.list_hobby,container,false);
        lv_list = view.findViewById(R.id.lv_hobby_list);

        if (getArguments()!= null){
            List<Hobby> list = (List<Hobby>) getArguments().getSerializable("quanList");
            Log.i("接受quanList:", String.valueOf(list.size()));
            for (Hobby b:list) {
                Log.i("hobby:", String.valueOf(b));
            }
            HobbyListAdapter adapter = new HobbyListAdapter(getActivity(),list);
            lv_list.setAdapter(adapter);
        }else {
            Log.i("getArguments is", null);
        }
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
