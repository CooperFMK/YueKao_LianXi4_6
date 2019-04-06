package com.fmk.lenovo.yuekao_lianxi4_6.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.fmk.lenovo.yuekao_lianxi4_6.R;
import com.fmk.lenovo.yuekao_lianxi4_6.adapter.FragAdpter;
import com.fmk.lenovo.yuekao_lianxi4_6.fragment.Frag2;
import com.fmk.lenovo.yuekao_lianxi4_6.mvp.v.Frag1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        radioGroup = findViewById(R.id.radioGroup);
        weixin();
    }

    private void weixin() {
        ArrayList<Fragment> data = new ArrayList<>();
        data.add(new Frag1());
        data.add(new Frag2());
        //适配器
        FragAdpter fragAdpter = new FragAdpter(getSupportFragmentManager(),data);
        pager.setAdapter(fragAdpter);

        radioGroup.check(radioGroup.getChildAt(0).getId());
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                radioGroup.check(radioGroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton1:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.radioButton2:
                        pager.setCurrentItem(1);
                        break;
                }
            }
        });
    }
}
