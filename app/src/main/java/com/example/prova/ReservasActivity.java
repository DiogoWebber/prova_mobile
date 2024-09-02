package com.example.prova;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReservasActivity extends AppCompatActivity {

    private Button btnConfiguracoes;

    private LinearLayout mesaUm;
    private Button btnMesaUm;

    private LinearLayout mesaDois;
    private Button btnMesaDois;

    private LinearLayout mesaTres;
    private Button btnMesaTres;

    private LinearLayout mesaQuatro;
    private Button btnMesaQuatro;

    private int corPadrao;
    private int corReservado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ReservasActivity.this);
        corReservado = preferences.getInt(Shared.KEY_COR_RESERVA, getColor(R.color.red));;
        corPadrao = getColor(R.color.green);

        btnConfiguracoes = findViewById(R.id.btnConfiguracoes);
        btnConfiguracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ReservasActivity.this, ConfiguracoesActivity.class);
                startActivityForResult(it, 1);
            }
        });

        // Configuração de mesas
        mesaUm = findViewById(R.id.mesaUm);
        btnMesaUm = findViewById(R.id.btnMesaUm);
        btnMesaUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int corAtual = ((ColorDrawable) mesaUm.getBackground()).getColor();
                if (corAtual == corPadrao) {
                    mesaUm.setBackgroundColor(corReservado);
                } else {
                    mesaUm.setBackgroundColor(corPadrao);
                }

                SharedPreferences.Editor edit = preferences.edit();
                edit.putInt(String.valueOf(mesaUm.getId()), ((ColorDrawable) mesaUm.getBackground()).getColor());
                edit.apply();
            }
        });

        mesaDois = findViewById(R.id.mesaDois);
        btnMesaDois = findViewById(R.id.btnMesaDois);
        btnMesaDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int corAtual = ((ColorDrawable) mesaDois.getBackground()).getColor();
                if (corAtual == corPadrao) {
                    mesaDois.setBackgroundColor(corReservado);
                } else {
                    mesaDois.setBackgroundColor(corPadrao);
                }

                SharedPreferences.Editor edit = preferences.edit();
                edit.putInt(String.valueOf(mesaDois.getId()), ((ColorDrawable) mesaDois.getBackground()).getColor());
                edit.apply();
            }
        });

        mesaTres = findViewById(R.id.mesaTres);
        btnMesaTres = findViewById(R.id.btnMesaTres);
        btnMesaTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int corAtual = ((ColorDrawable) mesaTres.getBackground()).getColor();
                if (corAtual == corPadrao) {
                    mesaTres.setBackgroundColor(corReservado);
                } else {
                    mesaTres.setBackgroundColor(corPadrao);
                }

                SharedPreferences.Editor edit = preferences.edit();
                edit.putInt(String.valueOf(mesaTres.getId()), ((ColorDrawable) mesaTres.getBackground()).getColor());
                edit.apply();
            }
        });

        mesaQuatro = findViewById(R.id.mesaQuatro);
        btnMesaQuatro = findViewById(R.id.btnMesaQuatro);
        btnMesaQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int corAtual = ((ColorDrawable) mesaQuatro.getBackground()).getColor();
                if (corAtual == corPadrao) {
                    mesaQuatro.setBackgroundColor(corReservado);
                } else {
                    mesaQuatro.setBackgroundColor(corPadrao);
                }

                SharedPreferences.Editor edit = preferences.edit();
                edit.putInt(String.valueOf(mesaQuatro.getId()), ((ColorDrawable) mesaQuatro.getBackground()).getColor());
                edit.apply();
            }
        });

        // Inicialização das cores das mesas
        mesaUm.setBackgroundColor(preferences.getInt(String.valueOf(mesaUm.getId()), corPadrao));
        mesaDois.setBackgroundColor(preferences.getInt(String.valueOf(mesaDois.getId()), corPadrao));
        mesaTres.setBackgroundColor(preferences.getInt(String.valueOf(mesaTres.getId()), corPadrao));
        mesaQuatro.setBackgroundColor(preferences.getInt(String.valueOf(mesaQuatro.getId()), corPadrao));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int res = data.getIntExtra(Shared.KEY_COR_RESERVA, corPadrao);

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ReservasActivity.this);
                SharedPreferences.Editor edit = preferences.edit();
                edit.putInt(Shared.KEY_COR_RESERVA, res);
                edit.apply();

                corReservado = res;

                // Atualizar cor das mesas
                int corAtual;
                corAtual = ((ColorDrawable) mesaUm.getBackground()).getColor();
                if (corAtual != corPadrao) {
                    mesaUm.setBackgroundColor(corReservado);
                    edit.putInt(String.valueOf(mesaUm.getId()), corReservado);
                }

                corAtual = ((ColorDrawable) mesaDois.getBackground()).getColor();
                if (corAtual != corPadrao) {
                    mesaDois.setBackgroundColor(corReservado);
                    edit.putInt(String.valueOf(mesaDois.getId()), corReservado);
                }

                corAtual = ((ColorDrawable) mesaTres.getBackground()).getColor();
                if (corAtual != corPadrao) {
                    mesaTres.setBackgroundColor(corReservado);
                    edit.putInt(String.valueOf(mesaTres.getId()), corReservado);
                }

                corAtual = ((ColorDrawable) mesaQuatro.getBackground()).getColor();
                if (corAtual != corPadrao) {
                    mesaQuatro.setBackgroundColor(corReservado);
                    edit.putInt(String.valueOf(mesaQuatro.getId()), corReservado);
                }

                edit.apply();
            }
        }
    }
}
