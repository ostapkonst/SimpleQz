package com.android.smplqz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class TextPagerAdapter extends FragmentStatePagerAdapter {

    private List<Question> data;

    public TextPagerAdapter(FragmentManager fm, List<Question> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = new ItemFragment();

        Bundle args = new Bundle();
        args.putString(ItemFragment.ARG_TEXT, data.get(i).getText());
        args.putInt(ItemFragment.ARG_POSITION, i + 1);
        args.putInt(ItemFragment.ARG_COUNT, getCount());
        args.putStringArray(ItemFragment.ARG_PSB_ANS, data.get(i).getPsbAns());
        args.putInt(ItemFragment.ARG_ANS, data.get(i).getAns());

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Item " + (position + 1);
    }
}