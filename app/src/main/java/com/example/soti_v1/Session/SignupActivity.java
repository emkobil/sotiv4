package com.example.soti_v1.Session;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidadvance.topsnackbar.TSnackbar;
import com.example.soti_v1.FeedActivity;
import com.example.soti_v1.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    EditText username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            Intent ıntent = new Intent(getApplicationContext(), FeedActivity.class);
            startActivity(ıntent);
            finish();
        }

        username = findViewById(R.id.signupactivity_edittext_username);
        email = findViewById(R.id.signupactivity_edittext_email);
        password = findViewById(R.id.signupactivity_edittext_password);

    }

    //REGİSTER
    public void SignUpButton(View view) {

        String UsernameText = username.getText().toString();
        String EmailText = email.getText().toString();
        String PasswordText = password.getText().toString();

        ParseUser user = new ParseUser();
        user.setEmail(EmailText);
        user.setUsername(UsernameText);
        user.setPassword(PasswordText);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    TSnackbar snackbar2 = TSnackbar.make(findViewById(android.R.id.content), e.getLocalizedMessage(), TSnackbar.LENGTH_INDEFINITE);
                    snackbar2.setActionTextColor(Color.WHITE);
                    View snackbarView = snackbar2.getView();
                    TextView textView = snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                    snackbar2.show();
                } else {
                    Intent ıntent = new Intent(getApplicationContext(), SigninActivity.class);
                    startActivity(ıntent);
                }
            }
        });


    }

    public void SigninActivity(View view) {
        Intent ıntent = new Intent(getApplicationContext(), SigninActivity.class);
        startActivity(ıntent);
    }
}
