package com.example.soti_v1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.soti_v1.ExploreFragment.ExploreFragmentOne;
import com.example.soti_v1.ExploreFragment.ExploreFragmentThree;
import com.example.soti_v1.ExploreFragment.ExploreFragmentTwo;

public class ExploreActivity extends AppCompatActivity {
    SectionPagerAdapter sectionPagerAdapter;
    private ViewPager viewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_explore);
        sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.container);
        setupPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



    }

    private void setupPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ExploreFragmentOne(),"ONE");
        adapter.addFragment(new ExploreFragmentTwo(),"TWO");
        adapter.addFragment(new ExploreFragmentThree(),"THREE");
        viewPager.setAdapter(adapter);
    }




}
















