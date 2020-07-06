package com.example.constellation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.constellation.R;
import com.example.constellation.activity.StarAnalyslsActivity;
import com.example.constellation.bean.StarAnalyslsBean;

import java.util.List;

public class AnalyslsBaseAdapter extends BaseAdapter {
    private Context context;
    private List<StarAnalyslsBean> mDatas;

    public AnalyslsBaseAdapter(Context context, List<StarAnalyslsBean> datas) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_star_analysls,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        StarAnalyslsBean bean = mDatas.get(position);
        holder.titleTv.setText(bean.getTitle());
        holder.contentTv.setText(bean.getContent());
        holder.contentTv.setBackgroundResource(bean.getColor());
        return convertView;
    }

    class ViewHolder{
        TextView titleTv,contentTv;
        public ViewHolder(View view){
            titleTv = view.findViewById(R.id.item_star_tv_title);
            contentTv = view.findViewById(R.id.item_star_tv_content);
        }
    }

}
