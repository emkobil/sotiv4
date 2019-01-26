package com.example.soti_v1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.soti_v1.Fragment.BasketFragment;
import com.example.soti_v1.Fragment.ExploreFragment;
import com.example.soti_v1.Fragment.HomeFragment;
import com.example.soti_v1.Fragment.NotificationFragment;
import com.example.soti_v1.Fragment.ProfileFragment;
import com.example.soti_v1.Session.SigninActivity;
import com.parse.ParseUser;

import static com.parse.Parse.getApplicationContext;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            Intent ıntent = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(ıntent);
            finish();
        }

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }


    public void GoExplore(View view){
        Intent ıntent = new Intent(getApplicationContext(),ExploreActivity.class);
        startActivity(ıntent);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;

                case R.id.nav_explore:
                    selectedFragment = new ExploreFragment();
                    break;

                case R.id.nav_basket:
                    selectedFragment = new BasketFragment();
                    break;

                case R.id.nav_notifications:
                    selectedFragment = new NotificationFragment();
                    break;

                case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;


            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };
}
