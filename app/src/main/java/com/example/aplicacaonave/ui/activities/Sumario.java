package com.example.aplicacaonave.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.aplicacaonave.R;

public class Sumario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumario);
    }

    public void buttonEncerrarOnClick(View view) {
        finishAffinity(); // Encerra o programa
    }
}