package com.example.aplicacaonave.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.aplicacaonave.R;

import domain.Carro;
import domain.CarroBmw;
import domain.CarroFusion;
import domain.CarroGol;
import domain.CarroGolf;
import domain.CarroKa;
import domain.Cliente;

public class EscolhaVeiculos extends AppCompatActivity {


    private RadioButton radioButtonGol, radioButtonKa, radioButtonGolf, radioButtonBmw, radioButtonFusion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setTitle("Catálogo");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha_veiculos);
    }

    public void buttonVoltarCadastroOnClick(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), CadastroCliente.class);
        startActivity(intent);
    }

    public void capturaInformacoesCarro(View view) {

        // Radio Buttons para o Veiculo
        radioButtonGol = findViewById(R.id.radioButtonGol);
        radioButtonKa = findViewById(R.id.radioButtonKa);
        radioButtonGolf = findViewById(R.id.radioButtonGolf);
        radioButtonFusion = findViewById(R.id.radioButtonFusion);
        radioButtonBmw = findViewById(R.id.radioButtonBmw);

        Carro carro;

        if (radioButtonGol.isChecked()) {
            carro = new CarroGol();
        } else if (radioButtonKa.isChecked()) {
            carro = new CarroKa();
        } else if (radioButtonGolf.isChecked()) {
            carro = new CarroGolf();
        } else if (radioButtonFusion.isChecked()) {
            carro = new CarroFusion();
        } else if (radioButtonBmw.isChecked()) {
            carro = new CarroBmw();
        } else {
            carro = new CarroGol();
            return;
        }

        // Recupera dados da tela de cadastro
        Bundle dados = getIntent().getExtras();
        String nomeCliente = dados.getString("ChaveNomeCliente");
        String cnhCliente = dados.getString("ChaveCnhCliente");
        String cpfCnpjCliente = dados.getString("ChaveCpfCnpjCliente");

        Intent intent = new Intent(getApplicationContext(), Pagamentos.class);
        intent.putExtra("ChaveCarroCor", carro.getCorCarro());
        intent.putExtra("ChaveCarroMarca", carro.getMarcaCarro());
        intent.putExtra("ChaveCarroNome", carro.getNomeCarro());
        intent.putExtra("ChaveCarroPreco", carro.getPrecoAluguel());
        intent.putExtra("ChaveCarroSeguro", carro.getPrecoSeguro());
        intent.putExtra("ChaveCarroPassageiros", carro.getQuantidadePassageiros());

        // Dados tela cadastro cliente
        intent.putExtra("ChaveNomeCliente", nomeCliente);
        intent.putExtra("ChaveCnhCliente", cnhCliente);
        intent.putExtra("ChaveCpfCnpjCliente", cpfCnpjCliente);
        startActivity(intent);
    }

    public void buttonAvancarPagamentoOnClick(View view) {
        capturaInformacoesCarro(view);
    }
}