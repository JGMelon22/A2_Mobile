package com.example.aplicacaonave.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplicacaonave.R;
import com.example.aplicacaonave.databinding.ActivityMainBinding;

import domain.Cliente;


public class CadastroCliente extends AppCompatActivity {

    private EditText editTextNomeCliente, editTextCpfCnpj, editTextCnh, editTextTelefone, editTextCep;
    private RadioButton radioButtonMasculino, radioButtonFeminino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Cadastro Cliente");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);
    }

    public boolean capturaInformacoesCliente(View view) {

        boolean valido = true;

        // Edit Texts Fields para informações simples do cliente
        editTextNomeCliente = findViewById(R.id.editTextNome);
        editTextCpfCnpj = findViewById(R.id.editTextCpfCnpj);
        editTextCnh = findViewById(R.id.editTextCnh);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        editTextCep = findViewById(R.id.editTextCep);

        // Radio Buttons para o Sexo
        radioButtonMasculino = findViewById(R.id.radioButtonM);
        radioButtonFeminino = findViewById(R.id.radioButtonF);

        // Julga os campos
        if (TextUtils.isEmpty(editTextNomeCliente.getText())) {
            editTextNomeCliente.setError("Informe o seu nome completo para prosseguir!");
            valido = false;
            return false;
        }

        if (TextUtils.isEmpty(editTextCpfCnpj.getText()) || ((editTextCpfCnpj.getText().length() != 11) && (editTextCpfCnpj.getText().length() != 14))) {
            editTextCpfCnpj.setError("Informe um CPF ou CNPJ válido para prosseguir!");
            valido = false;
            return false;
        }

        if (TextUtils.isEmpty(editTextCnh.getText()) || editTextCnh.getText().length() != 11) {
            editTextCnh.setError("Informe uma CNH válida para prosseguir!");
            valido = false;
            return false;
        }
        if (TextUtils.isEmpty(editTextTelefone.getText()) || editTextTelefone.getText().length() != 13) {
            editTextTelefone.setError("Informe um telefone/celular para prosseguir!");
            valido = false;
            return false;
        }
        if (TextUtils.isEmpty(editTextCep.getText()) || editTextCep.getText().length() != 8) {
            editTextCep.setError("Informe seu CEP completo para prosseguir!"); // 21211740
            valido = false;
            return false;
        }

        Character sexoClienteSelecionado;

        if (radioButtonFeminino.isChecked()) {
            sexoClienteSelecionado = 'F';
        } else if (radioButtonMasculino.isChecked()) {
            sexoClienteSelecionado = 'M';
        } else
            sexoClienteSelecionado = 'X'; // Sexo não informado


        // Caso sejam informacoes valida, atribui a variaveis auxiliares
        String nomeCliente = editTextNomeCliente.getText().toString();
        String cpfCnpjCliente = editTextCpfCnpj.getText().toString();
        String cepCliente = editTextCep.getText().toString();
        String cnhCliente = editTextCnh.getText().toString();
        Character sexoCliente = sexoClienteSelecionado;

        // Passa os valores para a classe cliente
        Cliente cliente = new Cliente(nomeCliente, cpfCnpjCliente, cepCliente, sexoCliente, cnhCliente);

        // Dictionary para passar valores para activities diferentes
        Intent intent = new Intent(getApplicationContext(), EscolhaVeiculos.class);
        intent.putExtra("ChaveNomeCliente", cliente.getNomeCompleto());
        intent.putExtra("ChaveCpfCnpjCliente", cliente.getCpfCnpj());
        intent.putExtra("ChaveCepCliente", cliente.getCep());
        intent.putExtra("ChaveSexoCliente", cliente.getSexo());
        intent.putExtra("ChaveCnhCliente", cliente.getNumeroCnh());

        startActivity(intent);

        return true;
    }

    public void buttonCancelarOnClick(View view) {
        finish();
    }

    public void buttonComecarOnClick(View view) {

        capturaInformacoesCliente(view);
        if (!capturaInformacoesCliente(view)) ;
    }
}