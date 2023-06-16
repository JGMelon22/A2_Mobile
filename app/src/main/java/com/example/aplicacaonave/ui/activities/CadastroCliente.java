package com.example.aplicacaonave.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplicacaonave.R;


public class CadastroCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setTitle("Cadastro Cliente");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

    }

    public void buttonCancelarOnClick(View view) {
        finish();
    }
}