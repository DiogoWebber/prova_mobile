package com.example.prova;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ConfiguracoesActivity extends AppCompatActivity {

    private LinearLayout btnConfigRed;
    private LinearLayout btnConfigBlue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracoes);

        btnConfigRed = findViewById(R.id.btnConfigRed);
        btnConfigRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int cor = ((ColorDrawable) btnConfigRed.getBackground()).getColor();
                Intent it = new Intent();
                it.putExtra(Shared.KEY_COR_RESERVA, cor);
                setResult(RESULT_OK, it);
                finish();
            }
        });


        btnConfigBlue = findViewById(R.id.btnConfigBlue);
        btnConfigBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cor = ((ColorDrawable) btnConfigBlue.getBackground()).getColor();
                Intent it = new Intent();
                it.putExtra(Shared.KEY_COR_RESERVA, cor);
                setResult(RESULT_OK, it);
                finish();
            }
        });

    }
}

