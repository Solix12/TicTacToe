package com.salikh.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {

    private final String massage;
    private final GameActivity gameActivity;
    private TextView massageTxt;
    private Button resBtn, homeBtn;


    public WinDialog(@NonNull Context context, String massage, GameActivity gameActivity) {
        super(context);
        this.massage = massage;
        this.gameActivity = gameActivity;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.win_dialog);

        loadView();
        setListeners();
        setDataToView();
    }

    private void setDataToView() {
        massageTxt.setText(massage);
    }

    private void setListeners() {
        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameActivity.restartMatch();
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameActivity.goHome();
            }
        });
    }

    private void loadView() {
        massageTxt = findViewById(R.id.textView2);
        resBtn = findViewById(R.id.resBtn);
        homeBtn = findViewById(R.id.homeBtn);

    }


}
