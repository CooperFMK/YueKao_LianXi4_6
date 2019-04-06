package com.fmk.lenovo.yuekao_lianxi4_6.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @Auther: 付明锟
 * @Date: 2019/4/6 14:13:21
 * @Description:
 */
public class FragAdpter extends FragmentPagerAdapter {

    public ArrayList<Fragment> data;

    public FragAdpter(FragmentManager fm, ArrayList<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int i) {
        return data.get(i);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
