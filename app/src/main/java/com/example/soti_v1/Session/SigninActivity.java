package com.example.soti_v1.Session;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidadvance.topsnackbar.TSnackbar;
import com.example.soti_v1.FeedActivity;
import com.example.soti_v1.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class SigninActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            Intent ıntent = new Intent(getApplicationContext(), FeedActivity.class);
            startActivity(ıntent);
            finish();
        }

        username = findViewById(R.id.signinactivity_edittext_username);
        password = findViewById(R.id.signinactivity_edittext_password);


    }

    //LOGİN
    public void SignInButton(View view) {

        String UsernameText = username.getText().toString();
        String PasswordText = password.getText().toString();


        ParseUser.logInInBackground(UsernameText, PasswordText, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    TSnackbar snackbar2 = TSnackbar.make(findViewById(android.R.id.content), e.getLocalizedMessage(), TSnackbar.LENGTH_INDEFINITE);
                    snackbar2.setActionTextColor(Color.WHITE);
                    View snackbarView = snackbar2.getView();
                    TextView textView = snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                    snackbar2.show();

                } else {
                    Intent ıntent = new Intent(getApplicationContext(), FeedActivity.class);
                    startActivity(ıntent);
                    finish();
                }
            }
        });

    }

    public void SignupActivity(View view) {
        Intent ıntent = new Intent(getApplicationContext(), SignupActivity.class);
        startActivity(ıntent);
    }

    public void ForgotPassword(View view) {
        Intent ıntent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
        startActivity(ıntent);
    }


}
