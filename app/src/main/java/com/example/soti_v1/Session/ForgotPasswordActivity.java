package com.example.soti_v1.Session;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;
import com.example.soti_v1.MainActivity;
import com.example.soti_v1.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText MailAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            Intent ıntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(ıntent);
            finish();
        }

        MailAdress = findViewById(R.id.forgotpasswordactivity_edittext_username);
    }

    public void ForgotPasswordSendMail(View view) {

        String SendToAdress = MailAdress.getText().toString();

        ParseUser.requestPasswordResetInBackground(SendToAdress, new RequestPasswordResetCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    TSnackbar snackbar1 = TSnackbar.make(findViewById(android.R.id.content), e.getLocalizedMessage(), TSnackbar.LENGTH_INDEFINITE);
                    snackbar1.setActionTextColor(Color.WHITE);
                    View snackbarView = snackbar1.getView();
                    TextView textView =  snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                    snackbar1.show();
                } else {
                   TSnackbar snackbar2 = TSnackbar.make(findViewById(android.R.id.content), "Send mail.", TSnackbar.LENGTH_INDEFINITE);
                    snackbar2.setActionTextColor(Color.WHITE);
                    View snackbarView = snackbar2.getView();
                    TextView textView =  snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                    snackbar2.show();


                }
            }
        });


    }
}
