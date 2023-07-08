package com.example.aplicacaonave.ui.activities;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    private RecyclerView recyclerViewSimples, recyclerViewIntermed, recyclerViewPremium; //
    private final ArrayList<Carro> carrosSimples = new ArrayList<>();
    private final ArrayList<Carro> carrosIntermed = new ArrayList<>();
    private final ArrayList<Carro> carrosPremium = new ArrayList<>();
    private SI_Adapter adapter1, adapter2, adapter3;
    private final RecyclerView[] recyclerViews = new RecyclerView[3]; //
    private int adapterIndex;
    private int selectedPosition = -1;
    private final int selectedItem1 = RecyclerView.NO_POSITION;
    private final int selectedItem2 = RecyclerView.NO_POSITION;
    private final int selectedItem3 = RecyclerView.NO_POSITION;

    private SI_Adapter selectedAdapter;

    private boolean darkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Catálogo");
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_escolha_veiculos);
        setContentView(R.layout.activity_escolha_veiculos_new);

        darkMode = (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES;

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

        if (selectedAdapter != null) {
            selectedPosition = selectedAdapter.getSelectedItemPosition();
            if (selectedPosition != RecyclerView.NO_POSITION) {
                capturaInformacoesCarro(view);
            }
            else {
                Toast.makeText(getApplicationContext(), "Selecione um carro para continuar.", Toast.LENGTH_SHORT).show();
            }
        } else { Toast.makeText(getApplicationContext(), "Selecione um carro para continuar.", Toast.LENGTH_SHORT).show(); }

    }

    @Override
    public void onItemClick(int position, int index) {
        selectedPosition = position;
        adapterIndex = index;
        SI_Adapter oldAdapter = selectedAdapter;

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

        } else { selectedAdapter = oldAdapter; Toast.makeText(getApplicationContext(), "Carro indisponível", Toast.LENGTH_SHORT).show(); }

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem darkModeItem = menu.findItem(R.id.action_darkmode);
        darkModeItem.setChecked(darkMode);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_darkmode) {
            darkMode = !darkMode;
            item.setChecked(darkMode);

            if(item.isChecked()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }

            return true;
        } else if (itemId == R.id.action_settings) {
            Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}