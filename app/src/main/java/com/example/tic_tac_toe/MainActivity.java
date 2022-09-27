package com.example.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private final List<int[]> combinationsList = new ArrayList();
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;
    private ImageView image9;
    private LinearLayout player1layout;
    private TextView player1name;
    private LinearLayout player2layout;
    private TextView player2name;
    private int playerTurn = 1;
    private int totalSelectBoxes = 1;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.player1name = findViewById(R.id.txt_player1name);
        this.player2name = findViewById(R.id.txt_player2name);
        this.player1layout = findViewById(R.id.layout_player1);
        this.player2layout = findViewById(R.id.layout_player2);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        combinationsList.add(new int[]{0, 1, 2});
        combinationsList.add(new int[]{3, 4, 5});
        combinationsList.add(new int[]{6, 7, 8});
        this.combinationsList.add(new int[]{0, 3, 6});
        this.combinationsList.add(new int[]{1, 4, 7});
        this.combinationsList.add(new int[]{2, 5, 8});
        this.combinationsList.add(new int[]{0, 4, 8});
        this.combinationsList.add(new int[]{2, 4, 6});

        String getPlayer1name = getIntent().getStringExtra("player1");
        String getPlayer2name = getIntent().getStringExtra("player2");

        this.player1name.setText(getPlayer1name);
        this.player2name.setText(getPlayer2name);

        this.image1.setOnClickListener(view -> {
            if (isBoxSelectable(0)) {
                MainActivity.this.performAction((ImageView) view, 0);
            }
        });
        this.image2.setOnClickListener(view -> {
            if (MainActivity.this.isBoxSelectable(1)) {
                MainActivity.this.performAction((ImageView) view, 1);
            }
        });
        this.image3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.this.isBoxSelectable(2)) {
                    MainActivity.this.performAction((ImageView) view, 2);
                }
            }
        });
        this.image4.setOnClickListener(view -> {
            if (MainActivity.this.isBoxSelectable(3)) {
                MainActivity.this.performAction((ImageView) view, 3);
            }
        });
        this.image5.setOnClickListener(view -> {
            if (MainActivity.this.isBoxSelectable(4)) {
                MainActivity.this.performAction((ImageView) view, 4);
            }
        });
        this.image6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.this.isBoxSelectable(5)) {
                    MainActivity.this.performAction((ImageView) view, 5);
                }
            }
        });
        this.image7.setOnClickListener(view -> {
            if (MainActivity.this.isBoxSelectable(6)) {
                MainActivity.this.performAction((ImageView) view, 6);
            }
        });
        this.image8.setOnClickListener(view -> {
            if (MainActivity.this.isBoxSelectable(7)) {
                MainActivity.this.performAction((ImageView) view, 7);
            }
        });
        this.image9.setOnClickListener(view -> {
            if (MainActivity.this.isBoxSelectable(8)) {
                MainActivity.this.performAction((ImageView) view, 8);
            }
        });
    }

    /* access modifiers changed from: private */
    public void performAction(ImageView imageview, int selectedBoxPosition) {
        int[] iArr = this.boxPositions;
        int i = this.playerTurn;
        iArr[selectedBoxPosition] = i;
        if (i == 1) {
            imageview.setImageResource(R.drawable.xx);
            if (checkPlayerWin()) {
                WinDialog winDialog = new WinDialog(this, this.player1name.getText().toString() + " has won the match", this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else if (this.totalSelectBoxes == 9) {
                WinDialog winDialog2 = new WinDialog(this, "It's a Draw!", this);
                winDialog2.setCancelable(false);
                winDialog2.show();
            } else {
                changePlayerTurn(2);
                this.totalSelectBoxes++;
            }
        } else if (i == 2) {
            imageview.setImageResource(R.drawable.oo);
            if (checkPlayerWin()) {
                new WinDialog(this, this.player2name.getText().toString() + " has won the match", this).show();
            } else if (selectedBoxPosition == 9) {
                new WinDialog(this, "It's a Draw!", this).show();
            } else {
                changePlayerTurn(1);
                this.totalSelectBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        this.playerTurn = currentPlayerTurn;
        if (currentPlayerTurn == 1) {
            this.player1layout.setBackgroundResource(R.drawable.round_black_blue_border);
            this.player2layout.setBackgroundResource(R.drawable.round_black_dark_blue);
            return;
        }
        this.player2layout.setBackgroundResource(R.drawable.round_black_blue_border);
        this.player1layout.setBackgroundResource(R.drawable.round_black_dark_blue);
    }

    private boolean checkPlayerWin() {
        boolean response = false;
        for (int i = 0; i < this.combinationsList.size(); i++) {
            int[] combination = this.combinationsList.get(i);
            int[] iArr = this.boxPositions;
            int i2 = iArr[combination[0]];
            int i3 = this.playerTurn;
            if (i2 == i3 && iArr[combination[1]] == i3 && iArr[combination[2]] == i3) {
                response = true;
            }
        }
        return response;
    }

    /* access modifiers changed from: private */
    public boolean isBoxSelectable(int boxPosition) {
        if (this.boxPositions[boxPosition] == 0) {
            return true;
        }
        return false;
    }

    public void restartMatch() {
        this.boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.playerTurn = 1;
        this.player1layout.setBackgroundResource(R.drawable.round_black_blue_border);
        this.player2layout.setBackgroundResource(R.drawable.round_black_dark_blue);
        this.totalSelectBoxes = 1;
        this.image1.setImageResource(R.drawable.transparent_bg);
        this.image2.setImageResource(R.drawable.transparent_bg);
        this.image3.setImageResource(R.drawable.transparent_bg);
        this.image4.setImageResource(R.drawable.transparent_bg);
        this.image5.setImageResource(R.drawable.transparent_bg);
        this.image6.setImageResource(R.drawable.transparent_bg);
        this.image7.setImageResource(R.drawable.transparent_bg);
        this.image8.setImageResource(R.drawable.transparent_bg);
        this.image9.setImageResource(R.drawable.transparent_bg);
    }
}