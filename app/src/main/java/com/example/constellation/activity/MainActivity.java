package com.example.constellation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.constellation.R;
import com.example.constellation.bean.StarBean;
import com.example.constellation.fragment.LuckFragment;
import com.example.constellation.fragment.MeFragment;
import com.example.constellation.fragment.ParnterFragment;
import com.example.constellation.fragment.StarFragment;
import com.example.constellation.utils.AssetsUtils;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mainRg;
    private Fragment starFrag,parnterFrag,luckFrag,meFrag;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        初始化布局
        initView();


//        加载星座相关数据的方法 /assets/xzcontent/xzcontent.json
        StarBean infoBean = loadDate();
        Bundle bundle = new Bundle();
        bundle.putSerializable("info",infoBean);

//        创建碎片对象
        starFrag = new StarFragment();
        starFrag.setArguments(bundle);
        parnterFrag = new ParnterFragment();
        parnterFrag.setArguments(bundle);
        luckFrag = new LuckFragment();
        luckFrag.setArguments(bundle);
        meFrag = new MeFragment();
        meFrag.setArguments(bundle);
        addFragmentPage();
    }

    /* 读取assets文件夹下的xzcontent.json文件 */
    private StarBean loadDate() {
        String json = AssetsUtils.getJsonFromAssets(this, "xzcontent/xzcontent.json");
        Gson gson = new Gson();
        StarBean infoBean = gson.fromJson(json, StarBean.class);
        AssetsUtils.savaBitmapFormAssets(this,infoBean);
        return  infoBean;
    }

    /**
     * @des 将主页当中的碎片一起加载进入布局，有用的显示，暂时无用的隐藏
     */
    private void addFragmentPage() {
//        1、创建碎片管理者对象
        manager = getSupportFragmentManager();
//        2、创建碎片处理事物的对象
        FragmentTransaction transaction = manager.beginTransaction();
//        3、将四个Fragment同意添加到布局
        transaction.add(R.id.main_layout_center,starFrag);
        transaction.add(R.id.main_layout_center,parnterFrag);
        transaction.add(R.id.main_layout_center,luckFrag);
        transaction.add(R.id.main_layout_center,meFrag);
//        4、只显示一个，隐藏后面的三个
        transaction.hide(parnterFrag);
        transaction.hide(luckFrag);
        transaction.hide(meFrag);
//        5、提交碎片改变后的事物
        transaction.commit();
    }

    private void initView() {
        mainRg = findViewById(R.id.main_rg);
        mainRg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch (checkedId){
            case R.id.main_rb_star:
                transaction.hide(parnterFrag);
                transaction.hide(luckFrag);
                transaction.hide(meFrag);
                transaction.show(starFrag);
                break;
            case R.id.main_rb_parnter:
                transaction.hide(starFrag);
                transaction.hide(luckFrag);
                transaction.hide(meFrag);
                transaction.show(parnterFrag);
                break;
            case R.id.main_rb_luck:
                transaction.hide(parnterFrag);
                transaction.hide(starFrag);
                transaction.hide(meFrag);
                transaction.show(luckFrag);
                break;
            case R.id.main_rb_me:
                transaction.hide(parnterFrag);
                transaction.hide(luckFrag);
                transaction.hide(starFrag);
                transaction.show(meFrag);
                break;

        }
        transaction.commit();
    }
}
