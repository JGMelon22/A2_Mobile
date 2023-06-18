package com.example.aplicacaonave.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.aplicacaonave.R;

public class Pagamentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setTitle("Pagamento");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamentos);
    }

    public void buttonRetornarCatalogoOnCick(View view) {
        finish();
    }

    public void buttonAvancarRevisarOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Sumario.class);
        startActivity(intent);
    }
}