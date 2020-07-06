package com.example.constellation.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.constellation.R;
import com.example.constellation.adapter.AnalyslsBaseAdapter;
import com.example.constellation.bean.StarAnalyslsBean;
import com.example.constellation.bean.StarBean;
import com.example.constellation.utils.AssetsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class StarAnalyslsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView titleTv;
    private ImageView backIv;
    private CircleImageView iconIv;
    private TextView nameTv,dateTv;
    private ListView analyslsLv;
    private StarBean.StarinfoBean bean;
    private Map<String, Bitmap> contentLogoImgMap;
    private TextView footerTv; // ListView底部布局需要改变的TextView
    private List<StarAnalyslsBean> mDatas;
    private AnalyslsBaseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_analysls);
        Intent intent = getIntent();
//        获取上一个界面传递过来的数据
        bean = (StarBean.StarinfoBean) intent.getSerializableExtra("star");

        initView();
        mDatas = new ArrayList<StarAnalyslsBean>(); // 初始化显示在ListView上的数据源
        mAdapter = new AnalyslsBaseAdapter(this, mDatas);
        analyslsLv.setAdapter(mAdapter);
        addDataToList();
    }

    /* 加载ListView当中的数据源内容 */
    private void addDataToList() {
        StarAnalyslsBean sab1 = new StarAnalyslsBean("性格特点 ：", bean.getTd(), R.color.lightblue);
        StarAnalyslsBean sab2 = new StarAnalyslsBean("掌管宫位 ：", bean.getGw(), R.color.lightpink);
        StarAnalyslsBean sab3 = new StarAnalyslsBean("显阴阳性 ：", bean.getYy(), R.color.lightgreen);
        StarAnalyslsBean sab4 = new StarAnalyslsBean("最大特征 ：", bean.getTz(), R.color.purple);
        StarAnalyslsBean sab5 = new StarAnalyslsBean("主管星球 ：", bean.getZg(), R.color.orange);
        StarAnalyslsBean sab6 = new StarAnalyslsBean("幸运颜色 ：", bean.getYs(), R.color.colorAccent);
        StarAnalyslsBean sab7 = new StarAnalyslsBean("搭配珠宝 ：", bean.getZb(), R.color.colorPrimary);
        StarAnalyslsBean sab8 = new StarAnalyslsBean("幸运号码 ：", bean.getHm(), R.color.grey);
        StarAnalyslsBean sab9 = new StarAnalyslsBean("相配金属 ：", bean.getJs(), R.color.darkblue);
        mDatas.add(sab1);
        mDatas.add(sab2);
        mDatas.add(sab3);
        mDatas.add(sab4);
        mDatas.add(sab5);
        mDatas.add(sab6);
        mDatas.add(sab7);
        mDatas.add(sab8);
        mDatas.add(sab9);
//        数据源发生变化，提示适配器更新
        mAdapter.notifyDataSetChanged();
    }

    /* 初始化控件的操作 */
    private void initView() {
        titleTv = findViewById(R.id.title_tv);
        backIv = findViewById(R.id.title_iv_back);
        iconIv = findViewById(R.id.staranalysls_iv);
        nameTv = findViewById(R.id.staranalysls_tv_name);
        dateTv = findViewById(R.id.staranalysls_tv_date);
        analyslsLv = findViewById(R.id.staranalysls_lv);
//        为ListView添加底部布局
        View footerView = LayoutInflater.from(this).inflate(R.layout.footer_star_analysls, null);
        analyslsLv.addFooterView(footerView);
        footerTv = footerView.findViewById(R.id.footerstar_tv_info);
//         将数据进行显示
        titleTv.setText("星座详情");
        backIv.setOnClickListener(this);
        nameTv.setText(bean.getName());
        dateTv.setText(bean.getDate());
        contentLogoImgMap = AssetsUtils.getContentLogoImgMap();
        Bitmap bitmap = contentLogoImgMap.get(bean.getLogoname());
        iconIv.setImageBitmap(bitmap);
        footerTv.setText(bean.getInfo());
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
