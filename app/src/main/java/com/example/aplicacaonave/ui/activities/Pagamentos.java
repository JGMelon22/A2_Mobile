package com.example.aplicacaonave.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.aplicacaonave.R;

import domain.Servicos;

public class Pagamentos extends AppCompatActivity {
    private RadioButton radioButtonCartao, radioButtonUrubuDoPix, radioButtonBoleto;
    private CheckBox checkBoxSim;
    private EditText editTextTempoAluguel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setTitle("Pagamento");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamentos);
    }

    public boolean capturaInformacoesPagamento(View view) {

        radioButtonCartao = findViewById(R.id.radioButtonCartao);
        radioButtonUrubuDoPix = findViewById(R.id.radioButtonPix);
        radioButtonBoleto = findViewById(R.id.radioButtonBoleto);

        checkBoxSim = findViewById(R.id.checkBoxIncluirSeguro);

        editTextTempoAluguel = findViewById(R.id.editTextTempoAluguel);

        // Forma de pagamento selecionada (default é cartao)
        String formaPagamento;

        if (radioButtonCartao.isSelected()) {
            formaPagamento = "Cartão";
        } else if (radioButtonUrubuDoPix.isSelected()) {
            formaPagamento = "Pix";
        } else if (radioButtonBoleto.isSelected()) {
            formaPagamento = "Boleto Bancário";
        } else {
            formaPagamento = "Cartão";
        }

        boolean valido = true;

        // Julga se foi informado uma quantidade de dias minimo para aluguel
        if (TextUtils.isEmpty(editTextTempoAluguel.getText()) || Integer.parseInt(editTextTempoAluguel.getText().toString()) == 0) {
            editTextTempoAluguel.setError("Tempo Inválido!");
            valido = false;
            return false;
        }

        boolean incluirSeguro = true;

        if (checkBoxSim.isChecked()) {
            incluirSeguro = true;
        } else {
            incluirSeguro = false;
        }

        // Caso sejam informacoes valida, atribui a variaveis auxiliares
        Integer tempoAluguel = Integer.parseInt(editTextTempoAluguel.getText().toString());

        // Passa os valores para a classe servicos
        Servicos servicos = new Servicos(incluirSeguro, tempoAluguel, formaPagamento);

        // Dictionary para passar valores para activities diferentes
        Intent intent = new Intent(getApplicationContext(), Sumario.class);
        intent.putExtra("ChaveFormaPagamento", servicos.getFormaPagamento());
        intent.putExtra("ChaveIncluirSeguro", servicos.isIncluirSeguro());
        intent.putExtra("ChaveTempoAluguel", servicos.getTempoAluguel());

        return true;
    }

    public void buttonRetornarCatalogoOnCick(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), EscolhaVeiculos.class);
        startActivity(intent);
    }

    public void buttonAvancarRevisarOnClick(View view) {
        capturaInformacoesPagamento(view);
        if (!capturaInformacoesPagamento(view))
            return;

        Intent intent = new Intent(getApplicationContext(), Sumario.class);
        startActivity(intent);
    }
}