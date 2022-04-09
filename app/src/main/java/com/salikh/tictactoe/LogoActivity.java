package com.salikh.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class LogoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        setBars();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoActivity.this, StartActivity.class);
                startActivity(intent);
                Animatoo.animateZoom(LogoActivity.this);
                finish();
            }
        }, 3000);
    }


    private void setBars() {
        getWindow().setStatusBarColor(getResources().getColor(R.color.darck_blue));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.darck_blue));
    }
}