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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumario);

        textViewSummary = findViewById(R.id.textViewSumario);

        // Recupera os Dados das demais activities
        Bundle dados = getIntent().getExtras();
        String nomeCliente = dados.getString("ChaveNomeCliente");
        String nomeCarro = dados.getString("ChaveCarroNome");
        String cpfCnpjCliente = dados.getString("ChaveCpfCnpjCliente");
        String cnhCliente = dados.getString("ChaveCnhCliente");
        String formaPagamento = dados.getString("ChaveFormaPagamento");
        Float precoSeguro = dados.getFloat("ChaveCarroSeguro");
        Float precoCarroDiario = dados.getFloat("ChaveCarroPreco");
        Integer quantidadeDiasAlugados = dados.getInt("ChaveTempoAluguel");
        boolean incluirSeguro = dados.getBoolean("ChaveIncluirSeguro");
        // intent.putExtra("ChaveIncluirSeguro", servicos.isIncluirSeguro());

        // Preco final
        // boolean incluirSeguro, Integer tempoAluguelCarro, Float precoAluguelCarro, Float precoSeguroCarro
        Float precoFinalVeiculo = Servicos.precoAluguel(incluirSeguro, quantidadeDiasAlugados, precoCarroDiario, precoSeguro);

        String sb = "### Resumo das Operações ### " +
                "\tNome Condutor: " + nomeCliente +
                "\n\tCPF/CNPJ Condutor: " + (cpfCnpjCliente.length() == 11 ? FormataValoresService.formataCpf(cpfCnpjCliente) : FormataValoresService.formataCnpj(cpfCnpjCliente)) +  // TODO - Critica se tiver 14 dígitos, formata como cnpj
                "\n\tCNH Condutor: " + cnhCliente +
                "\n\tNome Veículo: " + nomeCarro +
                "\n\tQuantidade Dias Alugados: " + quantidadeDiasAlugados +
                "\n\tForma Pagamento: " + formaPagamento +
                "\n\tPreço Veículo: " + FormataValoresService.formataPreco(precoCarroDiario) +
                "\n\tPreço Seguro Veículo: " + FormataValoresService.formataPreco(precoSeguro) +
                "\n\n\tPreço Final do Serviço: " + FormataValoresService.formataPreco(precoFinalVeiculo);

        textViewSummary.setText(sb);
    }

    public void buttonEncerrarOnClick(View view) {
        finishAffinity(); // Encerra o programa
    }
}