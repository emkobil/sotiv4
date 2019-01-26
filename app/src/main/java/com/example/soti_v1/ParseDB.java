package com.example.soti_v1;

import android.app.Application;

import com.parse.Parse;

public class ParseDB extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("z9enKuO6Aepyy73XH2k1JeigjC06DEszGEZXecmj")
                .clientKey("aFdL5yVoG8bbftm8PE5LBKP6wpYtWRyvtL9Y2LLx")
                .server("https://parseapi.back4app.com/")
                .build()
        );
        Parse.setLogLevel(Parse.LOG_LEVEL_VERBOSE);
    }
}
