package com.example.soti_v1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soti_v1.ExploreFragment.ExploreFragmentOne;
import com.example.soti_v1.ExploreFragment.ExploreFragmentThree;
import com.example.soti_v1.ExploreFragment.ExploreFragmentTwo;
import com.example.soti_v1.ExploreFragment.SectionPagerAdapter;
import com.example.soti_v1.PersonalProfileFragment.PersonalLikedFragment;
import com.example.soti_v1.PersonalProfileFragment.PersonalProfileEditPage;
import com.example.soti_v1.PersonalProfileFragment.PersonalSavedFragment;
import com.example.soti_v1.R;
import com.example.soti_v1.Session.SigninActivity;
import com.parse.ParseUser;

import static com.parse.Parse.getApplicationContext;

public class ProfileFragment extends Fragment implements Toolbar.OnMenuItemClickListener {

    SectionPagerAdapter sectionPagerAdapter;
    private ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        // User login check
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            Intent ıntent = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(ıntent);
            getActivity().finish();

        }


        // Username_Text && FullName_Text && Description_Text
        TextView profilefragment_textview_username = view.findViewById(R.id.profilefragment_textview_username);
        profilefragment_textview_username.setText(ParseUser.getCurrentUser().getUsername());
        TextView profilefragment_textview_fullname = view.findViewById(R.id.profilefragment_textview_fullname);
        profilefragment_textview_fullname.setText(ParseUser.getCurrentUser().getString("fullname"));
        TextView profilefragment_textview_description = view.findViewById(R.id.profilefragment_textview_description);
        profilefragment_textview_description.setText(ParseUser.getCurrentUser().getString("description"));




        // Toolbar_Menu
        Toolbar toolbar = view.findViewById(R.id.profile_toolbar);
        toolbar.inflateMenu(R.menu.profile_settings);
        toolbar.setOnMenuItemClickListener(this);

        // SliderBar
        sectionPagerAdapter = new SectionPagerAdapter(getChildFragmentManager());
        viewPager = view.findViewById(R.id.container_personalprofile);
        setupPager(viewPager);
        TabLayout tabLayout = view.findViewById(R.id.tabs_personalprofile);
        tabLayout.setupWithViewPager(viewPager);


        //Onclick EditProfileButton
        ImageView Button_EditProfile =  view.findViewById(R.id.Button_EditProfile);
        Button_EditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ıntent = new Intent(getApplicationContext(), PersonalProfileEditPage.class);
                startActivity(ıntent);
            }
        });


        //Onclick ViewMsgBox
        ImageView Button_ViewMsgBox =  view.findViewById(R.id.Button_ViewMsgBox);
        Button_ViewMsgBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "View Message Box", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override // ProfileMenuItemClick
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.profile_menu_editprofile:
                // editprofile activity intent
                break;

            case R.id.profile_menu_settings:
                // settings activity intent
                break;

            case R.id.profile_menu_logout:
                ParseUser.logOut();
                Intent ıntent = new Intent(getApplicationContext(), SigninActivity.class);
                startActivity(ıntent);
                getActivity().finish();
                break;

            default:
                break;


        }


        if (item.getItemId() == R.id.profile_menu_settings) {
            Toast.makeText(getApplicationContext(), "Başarılı", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    // SliderBar-Adapter
    private void setupPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new PersonalLikedFragment(), "Liked");
        adapter.addFragment(new PersonalSavedFragment(), "Saved");
        viewPager.setAdapter(adapter);
    }





}






















