package com.example.constellation.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.constellation.R;
import com.example.constellation.bean.LuckItemBean;

import java.util.List;

public class LuckAnalyslsAdapter extends BaseAdapter {
    private Context context;
    private List<LuckItemBean> mDatas;

    public LuckAnalyslsAdapter(Context context, List<LuckItemBean> datas) {
        this.context = context;
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_luckanalysls_lv,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        LuckItemBean itemBean = mDatas.get(position);
        holder.titleTv.setText(itemBean.getTitle());
        holder.contentTv.setText(itemBean.getContent());
//        改变TiewView背景的颜色
        GradientDrawable drawable = (GradientDrawable) holder.titleTv.getBackground();
        drawable.setColor(itemBean.getColorId());
        return convertView;
    }

    class ViewHolder{
        TextView titleTv,contentTv;
        public ViewHolder(View view){
            titleTv = view.findViewById(R.id.item_luckanalysls_tv_title);
            contentTv = view.findViewById(R.id.item_luckanalysls_tv_content);
        }
    }
}
