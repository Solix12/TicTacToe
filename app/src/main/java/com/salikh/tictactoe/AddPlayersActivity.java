package com.salikh.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import io.github.muddz.styleabletoast.StyleableToast;

public class AddPlayersActivity extends AppCompatActivity {

    private EditText playerOne;
    private EditText playerTwo;
    private Button startBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        loadViews();
        setListeners();
        setBars();
    }

    private void loadViews() {
        playerOne = findViewById(R.id.playerOne);
        playerTwo = findViewById(R.id.playerTwo);
        startBtn = findViewById(R.id.start_btn);
    }

    private void setListeners() {
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String getPlayerOneName = playerOne.getText().toString();
                String getPlayerTwoName = playerTwo.getText().toString();

                if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {
                    StyleableToast.makeText(AddPlayersActivity.this, "Write name", R.style.salihkToast).show();
                } else {
                    Intent intent = new Intent(AddPlayersActivity.this, GameActivity.class);
                    intent.putExtra("playerOne", getPlayerOneName);
                    intent.putExtra("playerTwo", getPlayerTwoName);
                    startActivity(intent);
                    Animatoo.animateZoom(AddPlayersActivity.this);
                    finish();
                }
            }
        });
    }

    private void setBars() {
        getWindow().setStatusBarColor(getResources().getColor(R.color.darck_blue));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.darck_blue));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AddPlayersActivity.this, StartActivity.class);
        startActivity(intent);
        Animatoo.animateZoom(AddPlayersActivity.this);
    }
}