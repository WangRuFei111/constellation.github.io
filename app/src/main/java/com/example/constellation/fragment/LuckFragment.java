package com.example.constellation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.constellation.R;
import com.example.constellation.activity.LuckAnalyslsActivity;
import com.example.constellation.adapter.LuckBaseAdapter;
import com.example.constellation.bean.StarBean;

import java.util.List;

/**
 * 运势界面
 */
public class LuckFragment extends Fragment {

    private GridView luckGv;
    private List<StarBean.StarinfoBean> mDatas;
    private LuckBaseAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.fragment_luck,null);

        luckGv = view.findViewById(R.id.luckfrag_gv);
//          获取数据源
        Bundle bundle = getArguments();
        StarBean infobean = (StarBean) bundle.getSerializable("info");
        mDatas = infobean.getStarinfo();
//        创建适配器对象
        adapter = new LuckBaseAdapter(getContext(),mDatas);
//        设置适配器
        luckGv.setAdapter(adapter);

//        设置GridView每一项的监听事件
        setListener();
        return view;
    }

    /* 创建监听事件 */
    private void setListener() {
        luckGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StarBean.StarinfoBean bean = mDatas.get(position);
                String name = bean.getName();
                Intent intent = new Intent(getContext(), LuckAnalyslsActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
