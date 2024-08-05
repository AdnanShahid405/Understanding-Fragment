package com.example.quiz_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnfragA,btnfragb,btnfragc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnfragA= findViewById(R.id.btnfragA);
        btnfragb= findViewById(R.id.btnfragB);
        btnfragc= findViewById(R.id.btnfragC);
        loadfrag(new CFragment(), 0);
        btnfragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadfrag(new AFragment(), 1);
            }
        });
        btnfragb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadfrag(new BFragment(), 1);

            }
        });
        btnfragc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadfrag(new CFragment(), 1);
            }
        });
    }
    public void loadfrag(Fragment fragement, int flag)
    {
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        if(flag==0)
        {ft.add(R.id.container,fragement);}
        else
        {ft.replace(R.id.container,fragement);}
        ft.commit();
    }
}