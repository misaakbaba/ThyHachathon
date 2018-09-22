package com.example.melkor.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SplashActivity extends AppCompatActivity {
    boolean userVerify = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intentLogin = new Intent(SplashActivity.this, LoginActivity.class);
        Intent intentBriefing = new Intent(SplashActivity.this, BriefingActivity.class);
        if(userVerify){
            startActivity(intentBriefing);
        }
        else{
            startActivity(intentLogin);
        }


    }


}
