package com.example.soti_v1.Session;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;
import com.example.soti_v1.MainActivity;
import com.example.soti_v1.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    EditText username, email, password, fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            Intent ıntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(ıntent);
            finish();
        }

        username = findViewById(R.id.signupactivity_edittext_username);
        email = findViewById(R.id.signupactivity_edittext_email);
        password = findViewById(R.id.signupactivity_edittext_password);
        fullname =  findViewById(R.id.signupactivity_edittext_fullname);

    }

    //REGİSTER
    public void SignUpButton(View view) {

        String UsernameText = username.getText().toString();
        String EmailText = email.getText().toString();
        String PasswordText = password.getText().toString();
        String FullnameText =  fullname.getText().toString();
        String Description = "";

        if (UsernameText.trim().equals("") || EmailText.trim().equals("") || PasswordText.trim().equals("") || FullnameText.trim().equals("") ) {

            TSnackbar snackbar2 = TSnackbar.make(findViewById(android.R.id.content), "Please fill in this form.", TSnackbar.LENGTH_INDEFINITE);
            snackbar2.setActionTextColor(Color.WHITE);
            View snackbarView = snackbar2.getView();
            TextView textView = snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
            textView.setTextColor(Color.YELLOW);
            textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
            snackbar2.show();


        } else {

            ParseUser user = new ParseUser();
            user.setEmail(EmailText);
            user.setUsername(UsernameText);
            user.setPassword(PasswordText);
            user.put("fullname",FullnameText);
            user.put("description",Description);

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
                        finish();
                    }
                }
            });


        }
    }

    public void SigninActivity(View view) {
        Intent ıntent = new Intent(getApplicationContext(), SigninActivity.class);
        startActivity(ıntent);
        finish();
    }
}
