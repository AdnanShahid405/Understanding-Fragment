package com.example.quiz_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent int1 = new Intent(Splash.this, MainActivity.class);
            startActivity(int1);
            finish();
        }
    },5000);
    }

}