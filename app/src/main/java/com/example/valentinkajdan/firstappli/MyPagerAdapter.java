package com.example.valentinkajdan.firstappli;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by valentinkajdan on 16/03/2017.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public String getPageTitle(int position) {
        return position == 0 ? "Recent news" : position == 1 ? "Titre 2" : "Titre 3";
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        return new FragmentList();
    }
}
