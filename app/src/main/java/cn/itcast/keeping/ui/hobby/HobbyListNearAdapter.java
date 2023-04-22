package cn.itcast.keeping.ui.hobby;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.itcast.keeping.Entity.Hobby;
import cn.itcast.keeping.R;

public class HobbyListNearAdapter extends BaseAdapter {


    private Context context;
    private List<Hobby> hobbyList;

    public HobbyListNearAdapter(Context context, List<Hobby> hobbyList) {
        this.context = context;
        this.hobbyList = hobbyList;
    }

    @Override
    public int getCount() {
        return hobbyList.size();
    }

    @Override
    public Object getItem(int i) {
        return hobbyList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
            view = View.inflate(context, R.layout.litem_hobby_near_list,null);
            holder = new ViewHolder();
            holder.ig_hobby = view.findViewById(R.id.ig_hobby);
            holder.tv_title = view.findViewById(R.id.tv_hobby_title);
            holder.tv_hobby_sign = view.findViewById(R.id.tv_hobby_sign);
            holder.near_people_name = view.findViewById(R.id.near_people_name);
            holder.ig_near_people_img = view.findViewById(R.id.hobby_near_people);
            holder.near_position = view.findViewById(R.id.near_position);
            holder.near_detail_one = view.findViewById(R.id.tv_hobby_details_one);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
            Glide.with(context).clear(holder.ig_hobby);
            Glide.with(context).clear(holder.ig_near_people_img);
        }

        Hobby hobby = hobbyList.get(i);
        holder.tv_title.setText(hobby.getName());
        holder.tv_hobby_sign.setText(hobby.getSign());
        holder.near_people_name.setText(hobby.getNear_people_name());
        holder.near_position.setText(hobby.getNear_position());
        holder.near_detail_one.setText("2km内有"+hobby.getNear_people_count()+"人参加");
//        holder.ig_hobby.setBackgroundResource(hobby.getImage());
        Glide.with(context).load(hobby.getImage()).into(holder.ig_hobby);
//        holder.ig_near_people_img.setBackgroundResource(hobby.getGetNear_people_img());
        Glide.with(context).load(hobby.getGetNear_people_img()).into(holder.ig_near_people_img);
        return view;
    }

    class ViewHolder{
        private ImageView ig_hobby,ig_near_people_img;
        private TextView tv_title,tv_hobby_sign,near_people_name,near_position,near_detail_one;

        public ViewHolder() {
        }
    }
}
