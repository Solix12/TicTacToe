package com.salikh.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialogBot extends Dialog {

    private final String massage;
    private final BotActivity botActivity;
    private TextView massageTxt;
    private Button resBtn, homeBtn;


    public WinDialogBot(@NonNull Context context, String massage, BotActivity botActivity) {
        super(context);
        this.massage = massage;
        this.botActivity = botActivity;
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
                botActivity.playAgain();
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botActivity.goHome();
            }
        });
    }

    private void loadView() {
        massageTxt = findViewById(R.id.textView2);
        resBtn = findViewById(R.id.resBtn);
        homeBtn = findViewById(R.id.homeBtn);

    }


}
