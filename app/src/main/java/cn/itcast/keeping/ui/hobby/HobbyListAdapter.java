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

public class HobbyListAdapter extends BaseAdapter {

    private Context context;
    private List<Hobby> hobbyList;

    public HobbyListAdapter(Context context, List<Hobby> hobbyList) {
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
//        return null;
        ViewHolder holder = null;
        if (view == null){
            view = View.inflate(context, R.layout.item_hobby_list,null);
            holder = new ViewHolder();
            holder.ig_hobby = view.findViewById(R.id.ig_hobby);
            holder.tv_title = view.findViewById(R.id.tv_hobby_title);
            holder.tv_hobby_sign = view.findViewById(R.id.tv_hobby_sign);
            holder.tv_hobby_details_one = view.findViewById(R.id.tv_hobby_details_one);
            holder.tv_hobby_details_two = view.findViewById(R.id.tv_hobby_details_two);
            holder.tv_hobby_pay_detail = view.findViewById(R.id.tv_hobby_pay_detail);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
            Glide.with(context).clear(holder.ig_hobby);
        }

        Hobby hobby = hobbyList.get(i);
        holder.tv_title.setText(hobby.getName());
        holder.tv_hobby_sign.setText(hobby.getSign());
        holder.tv_hobby_details_one.setText(hobby.getDetail_one());
        holder.tv_hobby_details_two.setText(hobby.getDetail_two());
        holder.tv_hobby_pay_detail.setText(hobby.getMoney()+"");
        Glide.with(context).load(hobby.getImage()).into(holder.ig_hobby);
//        holder.ig_hobby.setBackgroundResource(hobby.getImage());
        return view;
    }

    class ViewHolder{
        private ImageView ig_hobby;
        private TextView tv_title,tv_hobby_sign,tv_hobby_details_one,tv_hobby_details_two,tv_hobby_pay_detail;

        public ViewHolder() {
        }
    }
}
