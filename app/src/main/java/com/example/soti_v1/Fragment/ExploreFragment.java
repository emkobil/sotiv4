package com.example.soti_v1.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soti_v1.ExploreFragment.ExploreFragmentOne;
import com.example.soti_v1.ExploreFragment.ExploreFragmentThree;
import com.example.soti_v1.ExploreFragment.ExploreFragmentTwo;
import com.example.soti_v1.R;
import com.example.soti_v1.ExploreFragment.SectionPagerAdapter;


public class ExploreFragment extends Fragment {

    SectionPagerAdapter sectionPagerAdapter;
    private ViewPager viewPager;


    @Nullable
    @Override // OnCreate
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        sectionPagerAdapter = new SectionPagerAdapter(getChildFragmentManager());
        viewPager = view.findViewById(R.id.container);
        setupPager(viewPager);
        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return view;

    }

    // SliderBar
    private void setupPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new ExploreFragmentOne(), "Discount");
        adapter.addFragment(new ExploreFragmentTwo(), "For you");
        adapter.addFragment(new ExploreFragmentThree(), "Trending");
        viewPager.setAdapter(adapter);
    }


}






















