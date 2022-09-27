package com.example.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Addplayer extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplayer);
        final EditText player1 = findViewById(R.id.etxt_player1);
        final EditText player2 = findViewById(R.id.etxt_player2);
        Button strgame=findViewById(R.id.btn_startgame);

        strgame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String getplayer1name = player1.getText().toString();
                String getplayer2name = player2.getText().toString();
                if (getplayer1name.isEmpty() || getplayer2name.isEmpty()) {
                    Toast.makeText(Addplayer.this, "Please enter names!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(Addplayer.this, MainActivity.class);
                i.putExtra("player1", getplayer1name);
                i.putExtra("player2", getplayer2name);
                Addplayer.this.startActivity(i);
            }
        });
    }
}