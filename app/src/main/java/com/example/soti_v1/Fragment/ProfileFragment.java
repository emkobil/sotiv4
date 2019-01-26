package com.example.soti_v1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.soti_v1.FeedActivity;
import com.example.soti_v1.R;
import com.example.soti_v1.Session.SigninActivity;
import com.parse.ParseUser;

import static com.parse.Parse.getApplicationContext;

public class ProfileFragment extends Fragment {




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);



        Button button = view.findViewById(R.id.fragmentprofile_logoutbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                Intent ıntent = new Intent(getApplicationContext(), SigninActivity.class);
                startActivity(ıntent);
            }
        });
        return view;

    }

}






















