package com.example.aplicacaonave.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aplicacaonave.R;

public class EscolhaVeiculos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setTitle("Catálogo");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_veiculos);
    }

    public void buttonVoltarCadastroOnClick(View view) {
        finish();
    }

    public void buttonAvancarPagamentoOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Pagamentos.class);
        startActivity(intent);
    }
}