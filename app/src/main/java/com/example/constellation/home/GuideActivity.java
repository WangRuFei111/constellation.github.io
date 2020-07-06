package com.example.constellation.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.constellation.R;
import com.example.constellation.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    ViewPager guideVp;

    //    存放三张图片的地址
    int resIds[] = {R.mipmap.loading1,R.mipmap.loading2,R.mipmap.loading3};
    List<ImageView>mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        guideVp = findViewById(R.id.guide_vp);
        mDatas = new ArrayList<>();
        initPager();
//        为第三个图片设置监听事件
        setListener();
    }

    private void setListener() {
        int size = mDatas.size();
        ImageView view = mDatas.get(size - 1);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initPager() {
        for (int i = 0; i < resIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(resIds[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(lp);
            mDatas.add(imageView);
        }
        GuideAdapter adapter = new GuideAdapter(mDatas);
//        设置适配器
        guideVp.setAdapter(adapter);
    }
}