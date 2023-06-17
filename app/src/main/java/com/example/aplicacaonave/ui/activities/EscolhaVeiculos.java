package com.example.aplicacaonave.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aplicacaonave.R;

public class EscolhaVeiculos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setTitle("Catálogo");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_veiculos);
    }
}