package com.example.android.miwok;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;
    public CategoryAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext=context;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new NumbersFragment();
                break;
            case 1:
                fragment=new FamilyFragment();
                break;
            case 2:
                fragment=new ColorsFragment();
                break;
            case 3:
                fragment=new PhrasesFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return mContext.getString(R.string.category_numbers);
        }
        else if (position==1){
            return mContext.getString(R.string.category_family);
        }
        else if (position==2){
            return mContext.getString(R.string.category_colors);
        }
        else{
            return mContext.getString(R.string.category_phrases);
        }
    }
}
