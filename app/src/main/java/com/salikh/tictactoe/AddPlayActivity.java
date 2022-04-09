package com.salikh.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import io.github.muddz.styleabletoast.StyleableToast;

public class AddPlayActivity extends AppCompatActivity {


    private EditText name;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_play);

        setBars();
        loadView();
        setToIntent();

    }

    private void setToIntent() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getPlayerOneName = name.getText().toString();
                if (getPlayerOneName.isEmpty()) {
                    StyleableToast.makeText(AddPlayActivity.this, "Write name", R.style.salihkToast).show();
                } else {
                    Intent intent = new Intent(AddPlayActivity.this, BotActivity.class);
                    intent.putExtra("playerOne", getPlayerOneName);
                    startActivity(intent);
                    Animatoo.animateZoom(AddPlayActivity.this);
                    finish();
                }
            }
        });

    }

    private void loadView() {
        name = findViewById(R.id.playerOne);
        start = findViewById(R.id.start_btn);
    }

    private void setBars() {
        getWindow().setStatusBarColor(getResources().getColor(R.color.darck_blue));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.darck_blue));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AddPlayActivity.this, StartActivity.class);
        startActivity(intent);
        Animatoo.animateZoom(AddPlayActivity.this);
    }
}