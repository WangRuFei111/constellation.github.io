package com.example.constellation.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import com.example.constellation.R;
import com.example.constellation.bean.ParnterAnalyslsBean;
import com.example.constellation.utils.AssetsUtils;
import com.example.constellation.utils.LoadDataAsyncTask;
import com.example.constellation.utils.URLContent;
import com.google.gson.Gson;

import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ParnterAnalyslsActivity extends AppCompatActivity implements LoadDataAsyncTask.OnGetNetDataListener, View.OnClickListener {

    TextView manTv,womanTv,pdTv,vsTv,pfTv,bzTv,jxTv,zyTv,titleTv;
    CircleImageView manIv,womanIv;
    ImageView backIv;
    private String man_name;
    private String man_logoname;
    private String woman_name;
    private String woman_logoname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parnter_analysls);
        initView();
//        接收上一个页面传递的数值
        getLastData();
//        获取网络路径地址
        String parnterURL = URLContent.getParnterURL(man_name, woman_name);
//        加载网络数据
//        1.创造自定义的异步任务的对象
        LoadDataAsyncTask task = new LoadDataAsyncTask(this, this, true);
//        2.执行异步任务
        task.execute(parnterURL);
    }
    @Override
    public void onSuccess(String json) {
//        解析数据
        if (!TextUtils.isEmpty(json)) {
            ParnterAnalyslsBean analysisBean = new Gson().fromJson(json, ParnterAnalyslsBean.class);
            ParnterAnalyslsBean.ResultBean resultBean = analysisBean.getResult();

            pfTv.setText("配对评分: "+resultBean.getZhishu()+"  "+resultBean.getJieguo());
            bzTv.setText("星座比重: "+resultBean.getBizhong());
            jxTv.setText("解析:\n\n"+resultBean.getLianai());
            zyTv.setText("注意事项:\n\n"+resultBean.getZhuyi());
        }
    }
    private void getLastData() {
        Intent intent = getIntent();
        man_name = intent.getStringExtra("man_name");
        man_logoname = intent.getStringExtra("man_logoname");
        woman_name = intent.getStringExtra("woman_name");
        woman_logoname = intent.getStringExtra("woman_logoname");
//        设置能够显示的控件的信息
        Map<String, Bitmap> contentlogoImgMap =
                AssetsUtils.getContentLogoImgMap();
        Bitmap manBitmap = contentlogoImgMap.get(man_logoname);
        manIv.setImageBitmap(manBitmap);
        Bitmap womanBitmap = contentlogoImgMap.get(woman_logoname);
        womanIv.setImageBitmap(womanBitmap);

        manTv.setText(man_name);
        womanTv.setText(woman_name);
        pdTv.setText("星座配对-"+man_name+"和"+woman_name+"配对");
        vsTv.setText(man_name+" vs "+woman_name);
    }

    private void initView() {
        manIv = findViewById(R.id.parnteranalysls_iv_man);
        womanIv = findViewById(R.id.parnteranalysls_iv_woman);
        backIv = findViewById(R.id.title_iv_back);
        manTv = findViewById(R.id.parnteranalysls_tv_man);
        womanTv = findViewById(R.id.parnteranalysls_tv_woman);
        pdTv = findViewById(R.id.parnteranalysls_tv_pd);
        vsTv = findViewById(R.id.parnteranalysls_tv_vs);
        pfTv = findViewById(R.id.parnteranalysls_tv_pf);
        bzTv = findViewById(R.id.parnteranalysls_tv_bz);
        jxTv= findViewById(R.id.parnteranalysls_tv_jx);
        zyTv = findViewById(R.id.parnteranalysls_tv_zy);
        titleTv = findViewById(R.id.title_tv);
        backIv.setOnClickListener(this);
        titleTv.setText("配对详情");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_iv_back:
                finish();
                break;
        }
    }
}
