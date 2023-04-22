package cn.itcast.keeping.ui.hobby;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import cn.itcast.keeping.Entity.Hobby;
import cn.itcast.keeping.R;

public class HobbyNearFragment extends Fragment {

    private ListView lv_list;


    public HobbyNearFragment getInstance(List<Hobby> list){
        HobbyNearFragment hobbyNearFragment = new HobbyNearFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("nearList", (Serializable) list);
        hobbyNearFragment.setArguments(bundle);
        return hobbyNearFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View  view = inflater.inflate(R.layout.list_hobby_near,container,false);
        lv_list = view.findViewById(R.id.lv_hobby_list);
        if (getArguments()!= null){
            List<Hobby> list = (List<Hobby>) getArguments().getSerializable("nearList");
            Log.i("接受nearList:", String.valueOf(list.size()));
            for (Hobby b:list) {
                Log.i("hobby_near:", String.valueOf(b));
            }
            HobbyListNearAdapter adapter = new HobbyListNearAdapter(getActivity(),list);
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

