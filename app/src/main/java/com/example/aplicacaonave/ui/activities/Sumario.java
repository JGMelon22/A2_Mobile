package com.example.aplicacaonave.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicacaonave.R;

import domain.Servicos;
import service.FormataValoresService;

public class Sumario extends AppCompatActivity {

    private TextView textViewSummary;
    String nomeCliente;
    String nomeCarro;
    String cpfCnpjCliente;
    String cnhCliente;
    String formaPagamento;
    Float precoSeguro;
    Float precoCarroDiario;
    Integer quantidadeDiasAlugados;
    boolean incluirSeguro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumario);

        textViewSummary = findViewById(R.id.textViewSumario);

        // Recupera os Dados das demais activities

        Bundle dados = getIntent().getExtras();
        nomeCliente = dados.getString("ChaveNomeCliente");
        nomeCarro = dados.getString("ChaveCarroNome");
        cpfCnpjCliente = dados.getString("ChaveCpfCnpjCliente");
        cnhCliente = dados.getString("ChaveCnhCliente");
        formaPagamento = dados.getString("ChaveFormaPagamento");
        precoSeguro = dados.getFloat("ChaveCarroSeguro");
        precoCarroDiario = dados.getFloat("ChaveCarroPreco");
        quantidadeDiasAlugados = dados.getInt("ChaveTempoAluguel");
        incluirSeguro = dados.getBoolean("ChaveIncluirSeguro");



        // Preco final
        Float precoFinalVeiculo = Servicos.precoAluguel(quantidadeDiasAlugados, precoCarroDiario, precoSeguro, incluirSeguro);

        String sb = "### Resumo das Operações ### " +
                "\tNome Condutor: " + nomeCliente +
                "\n\t" + criticaCpfCnpj(cpfCnpjCliente) +
                "\n\tCNH Condutor: " + cnhCliente +
                "\n\tNome Veículo: " + nomeCarro +
                "\n\tQuantidade Dias Alugados: " + quantidadeDiasAlugados +
                "\n\tForma Pagamento: " + formaPagamento +
                "\n\tPreço Veículo: " + FormataValoresService.formataPreco(precoCarroDiario) +
                ""                    + criticaSeguro(precoSeguro, incluirSeguro) +
                "\n\n\tPreço Final do Serviço: " + FormataValoresService.formataPreco(precoFinalVeiculo);

        textViewSummary.setText(sb);
    }

    public void buttonEncerrarOnClick(View view) {
        finishAffinity(); // Encerra o programa
    }

    public String criticaCpfCnpj(String s){
        if(s.length() == 11) {
            return "CPF Condutor: " + FormataValoresService.formataCpf(s);
        }
        return "CNPJ Condutor: " + FormataValoresService.formataCnpj(s);

    }
    public String criticaSeguro(Float s, boolean b){
        if(b) return "\n\tPreço Seguro Veículo: " + FormataValoresService.formataPreco(s);
        return "";
    }

}