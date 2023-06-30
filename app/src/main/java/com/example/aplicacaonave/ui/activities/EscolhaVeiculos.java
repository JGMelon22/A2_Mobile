package com.example.aplicacaonave.ui.activities;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.aplicacaonave.R;
import com.example.aplicacaonave.ui.historico.CAR_Adapter;

import java.util.ArrayList;

import domain.AdapterCallback;
import domain.Carro;
import domain.CarroBmw;
import domain.CarroFusion;
import domain.CarroGol;
import domain.CarroGolf;
import domain.CarroKa;
import domain.Cliente;
import domain.RecyclerViewClickInterface;
import domain.Servicos;

public class EscolhaVeiculos extends AppCompatActivity implements AdapterCallback {

    private RecyclerView recyclerViewSimples, recyclerViewIntermed, recyclerViewPremium;
    private ArrayList<Carro> carros = new ArrayList<>();
    private ArrayList<Servicos> servicos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Carro> carrosSimples = new ArrayList<>();
    private ArrayList<Carro> carrosIntermed = new ArrayList<>();
    private ArrayList<Carro> carrosPremium = new ArrayList<>();
    private SI_Adapter adapter1, adapter2, adapter3;

    private RecyclerView[] recyclerViews = new RecyclerView[3];
    private int adapterIndex, selectedPosition;
    private int selectedItem1 = RecyclerView.NO_POSITION;
    private int selectedItem2 = RecyclerView.NO_POSITION;
    private int selectedItem3 = RecyclerView.NO_POSITION;

    private SI_Adapter selectedAdapter;

    private RadioButton radioButtonGol, radioButtonKa, radioButtonGolf, radioButtonBmw, radioButtonFusion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setTitle("Catálogo");
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_escolha_veiculos);
        setContentView(R.layout.activity_escolha_veiculos_new);

        //Simples

        recyclerViewSimples = findViewById(R.id.recyclerViewSimples);
        recyclerViewSimples.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewSimples.setHasFixedSize(true);

        carrosSimples.add(new CarroGol());
        carrosSimples.add(new CarroKa());
        carrosSimples.add(new Carro("Doblo", "Fiat", "Cinza", 7, 0, 0, false, R.drawable.doblo));

        //Intermediario

        recyclerViewIntermed = findViewById(R.id.recyclerViewIntermed);
        recyclerViewIntermed.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewIntermed.setHasFixedSize(true);

        carrosIntermed.add(new CarroGolf());
        carrosIntermed.add(new CarroFusion());
        carrosIntermed.add(new Carro("Corolla", "Toyota", "Branco", 4, 0, 0, false, R.drawable.corolla));

        //Premium

        recyclerViewPremium = findViewById(R.id.recyclerViewPremium);
        recyclerViewPremium.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewPremium.setHasFixedSize(true);

        carrosPremium.add(new CarroBmw());
        carrosPremium.add(new Carro("Aventador", "Lamborghini", "Azul", 4, 0, 0, false, R.drawable.lamborguini));
        carrosPremium.add(new Carro("Cayenne", "Porsche", "Branco", 4, 0, 0, false, R.drawable.porsche));


        //RecyclerViews e Adapters

        adapter1 = new SI_Adapter(this, carrosSimples, this, 0);
        recyclerViewSimples.setAdapter(adapter1);

        adapter2 = new SI_Adapter(this, carrosIntermed, this, 1);
        recyclerViewIntermed.setAdapter(adapter2);

        adapter3 = new SI_Adapter(this, carrosPremium, this, 2);
        recyclerViewPremium.setAdapter(adapter3);


        // Set the initial selected item positions for each adapter
        adapter1.setSelectedItem(selectedItem1);
        adapter2.setSelectedItem(selectedItem2);
        adapter3.setSelectedItem(selectedItem3);

        recyclerViews[0] = recyclerViewSimples;
        recyclerViews[1] = recyclerViewIntermed;
        recyclerViews[2] = recyclerViewPremium;
        adapterIndex = 0;


    }

    public void buttonVoltarCadastroOnClick(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), CadastroCliente.class);
        startActivity(intent);
    }

    public void capturaInformacoesCarro(View view) {

        Carro carro = null;

        selectedPosition = selectedAdapter.getSelectedItemPosition();

        if (selectedAdapter == adapter1) {
            switch (selectedPosition) {
                //Simples
                case 0:
                    carro = new CarroGol();
                    break;
                case 1:
                    carro = new CarroKa();
                    break;
            }

        } else if (selectedAdapter == adapter2) {
            //Intermediarios
            switch (selectedPosition) {
                case 0:
                    carro = new CarroGolf();
                    break;
                case 1:
                    carro = new CarroFusion();
                    break;

            }
        } else if (selectedAdapter == adapter3) {
            //Premium
            if (selectedPosition == 0) {
                carro = new CarroBmw();
            } else {
                carro = new CarroGol();
            }

        }  else {

        }

        //adapter null?


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

        finish();
        startActivity(intent);
    }

    public void buttonAvancarPagamentoOnClick(View view) {
        capturaInformacoesCarro(view);
    }

    @Override
    public void onItemClick(int position, int index) {
        selectedPosition = position;
        adapterIndex = index;

        // Acha o adapter certo atravez do Index

        switch (adapterIndex) {
            case 0:
                selectedAdapter = adapter1;
                break;
            case 1:
                selectedAdapter = adapter2;
                break;
            case 2:
                selectedAdapter = adapter3;
                break;
            default:
                return;
        }

        // Checa se o carro está disponível
        if (selectedAdapter.isItemAvailable(position)) {
            // Setta posicao no adapter que irá dar toggle
            selectedAdapter.setSelectedItemPosition(position);

            // Remove a selecao dos outros radioBt
            if (selectedAdapter != adapter1) {
                adapter1.setSelectedItemPosition(RecyclerView.NO_POSITION);
            }
            if (selectedAdapter != adapter2) {
                adapter2.setSelectedItemPosition(RecyclerView.NO_POSITION);
            }
            if (selectedAdapter != adapter3) {
                adapter3.setSelectedItemPosition(RecyclerView.NO_POSITION);
            }

        } else { Toast.makeText(getApplicationContext(), "Carro indisponível", Toast.LENGTH_SHORT).show(); }
//        selectedPosition = position;
//        adapterIndex = index;
//
//        if (adapter1.getIsIndisponivel()) return;
//
//        switch (adapterIndex) {
//            case 0:
//                selectedAdapter = adapter1;
//                adapter1.setSelectedItemPosition(position);
//                adapter2.setSelectedItemPosition(RecyclerView.NO_POSITION);
//                adapter3.setSelectedItemPosition(RecyclerView.NO_POSITION);
//                break;
//            case 1:
//                selectedAdapter = adapter2;
//                adapter1.setSelectedItemPosition(RecyclerView.NO_POSITION);
//                adapter2.setSelectedItemPosition(position);
//                adapter3.setSelectedItemPosition(RecyclerView.NO_POSITION);
//                break;
//            case 2:
//                selectedAdapter = adapter3;
//                adapter1.setSelectedItemPosition(RecyclerView.NO_POSITION);
//                adapter2.setSelectedItemPosition(RecyclerView.NO_POSITION);
//                adapter3.setSelectedItemPosition(position);
//                break;
//        }
    }


    @Override
    public void onItemSelected(int adapterPosition) {
        // Handle item selection in the UI for the corresponding adapter position
        // For example:
        if (adapterPosition == 0) {
            // Item at position 0 is selected in the adapter
        } else if (adapterPosition == 1) {
            // Item at position 1 is selected in the adapter
        }
    }

    @Override
    public void onItemDeselected(int adapterPosition) {
        // Handle item deselection in the UI for the corresponding adapter position
        // For example:
        if (adapterPosition == 0) {
            // Item at position 0 is deselected in the adapter
        } else if (adapterPosition == 1) {
            // Item at position 1 is deselected in the adapter
        }
    }
}