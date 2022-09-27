package com.example.tic_tac_toe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class WinDialog extends Dialog {
    public final MainActivity mainActivity;
    private final String message;

    public WinDialog(Context context, String message2, MainActivity mainActivity2) {
        super(context);
        this.message = message2;
        this.mainActivity = mainActivity2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_layout);
        ((TextView) findViewById(R.id.txt_message)).setText(this.message);
        ((Button) findViewById(R.id.btn_start_again)).setOnClickListener(v -> {
            WinDialog.this.mainActivity.restartMatch();
            WinDialog.this.dismiss();
        });
    }
}