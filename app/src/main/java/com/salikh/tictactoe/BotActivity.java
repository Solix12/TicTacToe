package com.salikh.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class BotActivity extends AppCompatActivity {

    boolean isGameActive = true;
    int playerTurn = 1;
    WinDialogBot winDialogBot;

    int playCounter = 0;
    int currentPlayer = 0;

    LinearLayout one, two;

    int[] gamePositions = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    int[][] winningPatterns = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private TextView name;
    private LottieAnimationView winLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);
        loadView();
        serName();
        setBars();


    }

    private void setBars() {
        getWindow().setStatusBarColor(getResources().getColor(R.color.darck_blue));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.darck_blue));
    }

    private void serName() {
        name.setText(getIntent().getStringExtra("playerOne"));
    }


    private void loadView() {
        one = findViewById(R.id.playerOneLayout);
        two = findViewById(R.id.playerTwoLayout);
        name = findViewById(R.id.playerOneName);

    }

    public void playerTurn(View view) {
        playerTurn = 2;
        changePlayerTurn(playerTurn);

        ImageView currentTapped = (ImageView) view;

        int tapped = Integer.parseInt(currentTapped.getTag().toString());

        if (isGameActive && gamePositions[tapped] == -1 && currentPlayer == 0) {
            gamePositions[tapped] = currentPlayer;

            currentTapped.setImageResource(R.drawable.x);

            checkForWinner();
        }
    }

    public void botTurn() {
        playerTurn = 1;
        new CountDownTimer(1000, 1000) {
            public void onFinish() {
                changePlayerTurn(playerTurn);
                int tapped = 0;
                boolean found = false;

                while (!found) {
                    int random = (int) Math.floor(Math.random() * 9);

                    if (gamePositions[random] == -1) {
                        tapped = random;
                        found = true;
                    }
                }

                int id = getResources().getIdentifier("image" + (tapped + 1), "id", getPackageName());

                ImageView currentTapped = findViewById(id);

                gamePositions[tapped] = currentPlayer;

                currentTapped.setImageResource(R.drawable.o);

                checkForWinner();
            }

            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }

    public void checkForWinner() {

        for (int[] i : winningPatterns) {
            if ((gamePositions[i[0]] == gamePositions[i[1]] && gamePositions[i[1]] == gamePositions[i[2]]) && gamePositions[i[0]] != -1) {


                isGameActive = false;

                if (gamePositions[i[0]] == 0) {

                    winDialogBot = new WinDialogBot(BotActivity.this, "Winner is " + name.getText().toString(), BotActivity.this);
                    winDialogBot.setCancelable(false);
                    winDialogBot.show();

                } else {
                    winDialogBot = new WinDialogBot(BotActivity.this, "You lost", BotActivity.this);
                    winDialogBot.setCancelable(false);
                    winDialogBot.show();
                }

            }
        }

        if (isGameActive) {
            if (++playCounter == 9) {
                winDialogBot = new WinDialogBot(BotActivity.this, "Draw", BotActivity.this);
                winDialogBot.setCancelable(false);
                winDialogBot.show();

            } else {
                if (currentPlayer == 0) {
                    currentPlayer = 1;


                    botTurn();
                } else {
                    currentPlayer = 0;

                }
            }
        }
    }

    public void playAgain() {
        RelativeLayout relativeLayout = findViewById(R.id.group);

        isGameActive = true;
        currentPlayer = 0;
        playCounter = 0;

        for (int i = 0; i < gamePositions.length; i++) {
            gamePositions[i] = -1;
        }

        for (int i = 0; i < relativeLayout.getChildCount(); i++) {
            ((ImageView) relativeLayout.getChildAt(i)).setImageResource(0);
        }
        playerTurn = 1;
        changePlayerTurn(playerTurn);
        winDialogBot.cancel();
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        playerTurn = currentPlayerTurn;

        if (playerTurn == 1) {
            one.setBackgroundResource(R.drawable.round_back_blue_border);
            two.setBackgroundResource(R.drawable.round_back_blue);
        } else {
            two.setBackgroundResource(R.drawable.round_back_blue_border);
            one.setBackgroundResource(R.drawable.round_back_blue);
        }
    }

    public void goHome() {
        Intent intent = new Intent(BotActivity.this, StartActivity.class);
        startActivity(intent);
        Animatoo.animateZoom(BotActivity.this);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(BotActivity.this, StartActivity.class);
        startActivity(intent);
        Animatoo.animateZoom(BotActivity.this);
    }
}
