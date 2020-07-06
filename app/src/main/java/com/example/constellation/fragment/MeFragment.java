package com.example.constellation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.constellation.R;
import com.example.constellation.adapter.LuckBaseAdapter;
import com.example.constellation.bean.StarBean;
import com.example.constellation.utils.AssetsUtils;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MeFragment extends Fragment implements View.OnClickListener {
    private CircleImageView iconIv;
    private TextView nameTv;
    private Map<String, Bitmap> imgMap;
    private List<StarBean.StarinfoBean> mDatas;
    private SharedPreferences star_pred;
//    保存选择星座的位置
    private int selectPos = 0;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        获取Activity传递的数据
        Bundle bundle = getArguments();
        StarBean infoBean = (StarBean) bundle.getSerializable("info");
        mDatas = infoBean.getStarinfo();
        star_pred = getContext().getSharedPreferences("star_pref", Context.MODE_PRIVATE);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.fragment_me,null);
        iconIv = view.findViewById(R.id.mefrag_iv);
        nameTv = view.findViewById(R.id.mefrag_tv_name);
//        进行初始化数据
        imgMap = AssetsUtils.getContentLogoImgMap();
        iconIv.setOnClickListener(this);
//        读取共享参数保存的星座名称和logo名称
        String name = star_pred.getString("name", "白羊座");
        String logoname = star_pred.getString("logoname", "baiyang");
        Bitmap bitmap = imgMap.get(logoname);
        iconIv.setImageBitmap(bitmap);
        nameTv.setText(name);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mefrag_iv:
                showDialog();
                break;
        }
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.me_dialog,null);
        dialog.setContentView(dialogView);
        dialog.setTitle("请选择您的星座：");
        GridView dialogGv = dialogView.findViewById(R.id.mefrag_dialog_gv);
//        设置适配器
        LuckBaseAdapter adapter = new LuckBaseAdapter(getContext(),mDatas);
        dialogGv.setAdapter(adapter);
//        设置能否被取消
        dialog.setCancelable(true);
//        设置点击弹出框的外部，可以取消弹出框
        dialog.setCanceledOnTouchOutside(true);

//        设置gridview每一项的点击事件
        dialogGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StarBean.StarinfoBean bean = mDatas.get(position);
                String name = bean.getName();
                String logoname = bean.getLogoname();
                nameTv.setText(name);
                Bitmap bitmap = imgMap.get(logoname);
                iconIv.setImageBitmap(bitmap);
                selectPos = position;   //保存选择的位置
                dialog.cancel();
            }
        });
        dialog.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        StarBean.StarinfoBean bean = mDatas.get(selectPos);
        String name = bean.getName();
        String logoname = bean.getLogoname();
        SharedPreferences.Editor editor = star_pred.edit();     // 获取向共享参数中写入数据的对象
        editor.putString("name",name);
        editor.putString("logoname",logoname);
        editor.commit();
    }
}
