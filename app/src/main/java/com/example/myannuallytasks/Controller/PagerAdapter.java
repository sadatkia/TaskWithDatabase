package com.example.myannuallytasks.Controller;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {


    public PagerAdapter(FragmentManager FM,int NumberOfTabs) {
        super(FM);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
            { TabsFragment tab1 = TabsFragment.newInstance(State.TODO);
                return tab1;}
            case 1:
            {TabsFragment tab2 = TabsFragment.newInstance(State.DOING);

                return tab2;}
            case 2:
            {TabsFragment tab3 = TabsFragment.newInstance(State.DONE);

                return tab3;}
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Parcelable saveState() {
        return super.saveState();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
