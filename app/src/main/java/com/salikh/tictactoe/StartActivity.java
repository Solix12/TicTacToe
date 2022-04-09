package com.salikh.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class StartActivity extends AppCompatActivity {

    private Button compBtn, friendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        loadView();
        serListeners();
        setBars();
    }

    private void serListeners() {
        compBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, AddPlayActivity.class);
                startActivity(intent);
                Animatoo.animateZoom(StartActivity.this);
                finish();
            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, AddPlayersActivity.class);
                startActivity(intent);
                Animatoo.animateZoom(StartActivity.this);
                finish();
            }
        });
    }

    private void loadView() {

        compBtn = findViewById(R.id.compBtn);
        friendBtn = findViewById(R.id.friendBtn);

    }

    private void setBars() {
        getWindow().setStatusBarColor(getResources().getColor(R.color.darck_blue));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.darck_blue));
    }
}