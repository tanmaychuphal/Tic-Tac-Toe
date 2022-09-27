package com.example.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SplashScreenActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Objects.requireNonNull(getSupportActionBar()).hide();

//        getWindow().setFlags(512, 512);

        new Thread() {
            public void run() {
                Intent intent;
                try {
                    sleep(1200);
                    intent = new Intent(SplashScreenActivity.this, Addplayer.class);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    intent = new Intent(SplashScreenActivity.this, Addplayer.class);
                }
//                catch (Throwable th) {
//                    SplashScreenActivity.this.startActivity(new Intent(SplashScreenActivity.this,
//                            Addplayer.class));
//                    throw th;
//                }
//                SplashScreenActivity.this.startActivity(intent);
                startActivity(intent);
            }
        }.start();
    }
}
