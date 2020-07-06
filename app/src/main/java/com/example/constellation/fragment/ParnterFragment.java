package com.example.constellation.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.constellation.R;
import com.example.constellation.activity.ParnterAnalyslsActivity;
import com.example.constellation.bean.StarBean;
import com.example.constellation.utils.AssetsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParnterFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ImageView manIv,womanIv;
    private Spinner manSp,womanSp;
    private Button prizeBtn,analyslsBtn;
    private List<StarBean.StarinfoBean> infoList;
    private List<String>nameList;   //存放星座名称的集合
    private Map<String, Bitmap> logoImgMap;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.fragment_parnter,null);
        initView(view);
//        获取Activity传递得数据
        Bundle bundle = getArguments();
        StarBean starBean = (StarBean) bundle.getSerializable("info");
        infoList = starBean.getStarinfo();
        nameList = new ArrayList<>();
//        获取适配器所需要的数据源
        for (int i = 0; i < infoList.size(); i++) {
            String name = infoList.get(i).getName();
            nameList.add(name);
        }
//        创建适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.item_parnter_sp,
                R.id.item_parnter_tv, nameList);
        manSp.setAdapter(adapter);
        womanSp.setAdapter(adapter);

//        获取第一个图片资源显示在ImageView上
        String logoname = infoList.get(0).getLogoname();
        logoImgMap = AssetsUtils.getContentLogoImgMap();
        Bitmap bitmap = logoImgMap.get(logoname);
        manIv.setImageBitmap(bitmap);
        womanIv.setImageBitmap(bitmap);

        return view;
    }

    /* 初始化绑定控件 */
    private void initView(View view) {
        manIv = view.findViewById(R.id.parnterfrag_iv_man);
        womanIv = view.findViewById(R.id.parnterfrag_iv_woman);
        manSp = view.findViewById(R.id.parnterfrag_sp_man);
        womanSp = view.findViewById(R.id.parnterfrag_sp_woman);
        prizeBtn = view.findViewById(R.id.parnterfrag_btn_prize);
        analyslsBtn = view.findViewById(R.id.parnterfrag_btn_analysls);
//        设置按钮得监听器
        prizeBtn.setOnClickListener(this);
        analyslsBtn.setOnClickListener(this);
        manSp.setOnItemSelectedListener(this);
        womanSp.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.parnterfrag_btn_prize:
                break;
            case R.id.parnterfrag_btn_analysls:
//                获取spinner选中的位置
                int manSelPos = manSp.getSelectedItemPosition();
                int womanSelPos = womanSp.getSelectedItemPosition();
//                跳转传值到星座配对详情界面
                Intent intent = new Intent(getContext(), ParnterAnalyslsActivity.class);
                intent.putExtra("man_name",infoList.get(manSelPos).getName());
                intent.putExtra("man_logoname",infoList.get(manSelPos).getLogoname());
                intent.putExtra("woman_name",infoList.get(womanSelPos).getName());
                intent.putExtra("woman_logoname",infoList.get(womanSelPos).getLogoname());
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.parnterfrag_sp_man:
                String logoname = infoList.get(position).getLogoname();
                Bitmap bitmap = logoImgMap.get(logoname);
                manIv.setImageBitmap(bitmap);
                break;
            case R.id.parnterfrag_sp_woman:
                logoname = infoList.get(position).getLogoname();
                bitmap = logoImgMap.get(logoname);
                womanIv.setImageBitmap(bitmap);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
