package com.example.aplicacaonave.ui.historico;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aplicacaonave.databinding.ActivitySumarioBinding;
import com.example.aplicacaonave.databinding.FragmentHistoricoBinding;
import com.example.aplicacaonave.ui.activities.Sumario;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import domain.Carro;
import domain.CarroBmw;
import domain.CarroGol;
import domain.CarroGolf;
import domain.Cliente;
import domain.RecyclerViewClickInterface;
import domain.Servicos;


public class HistoricoFragment extends Fragment implements RecyclerViewClickInterface {

    private RecyclerView recyclerView;
    private CAR_Adapter adapter;
    private FragmentHistoricoBinding binding;
    private ArrayList<Carro> carros = new ArrayList<>();
    private ArrayList<Servicos> servicos = new ArrayList<>();
    private  ArrayList<Cliente> clientes = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHistoricoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Mock data
        clientes.add(new Cliente("João Golfius", "74631305762", "21211740", 'M', "60699172267"));
        clientes.add(new Cliente("Robert Golaço", "09753863799", "21921356", 'M', "00488717305"));
        clientes.add(new Cliente("Orlando Biemidabiu", "28790178742", "22521356", 'M', "83589916330"));
        servicos.add(new Servicos(true, 2, "Pix"));
        servicos.add(new Servicos(true, 4, "Boleto"));
        servicos.add(new Servicos(false, 7, "Pix"));
        carros.add(new CarroGolf());
        carros.add(new CarroGol());
        carros.add(new CarroBmw());

        adapter = new CAR_Adapter(this, this.getContext(), carros);
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(int position) {

//        Intent intent = new Intent(getContext(), ActivitySumarioBinding.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("value", carros);
//        intent.putExtras(bundle);


        // Dictionary para passar valores para activities diferentes
        Intent intent = new Intent(this.getContext(), Sumario.class);
        intent.putExtra("ChaveFormaPagamento", servicos.get(position).getFormaPagamento());
        intent.putExtra("ChaveIncluirSeguro", servicos.get(position).isIncluirSeguro());
        intent.putExtra("ChaveTempoAluguel", servicos.get(position).getTempoAluguel());

        // Dados tela cadastro cliente
        intent.putExtra("ChaveNomeCliente", clientes.get(position).getNomeCompleto());
        intent.putExtra("ChaveCpfCnpjCliente", clientes.get(position).getCpfCnpj());
        intent.putExtra("ChaveCnhCliente", clientes.get(position).getNumeroCnh());
        intent.putExtra("ChaveCarroMarca", carros.get(position).getMarcaCarro());
        intent.putExtra("ChaveCarroNome", carros.get(position).getNomeCarro());
        intent.putExtra("ChaveCarroPreco", carros.get(position).getPrecoAluguel());
        intent.putExtra("ChaveCarroSeguro", carros.get(position).getPrecoSeguro());

        startActivity(intent);
        // get bundle
        //Intent intent = this.getIntent();
        //Bundle bundle = intent.getExtras();
        //
        //List<Thumbnail> thumbs=
        //               (List<Thumbnail>)bundle.getSerializable("value");

    }
}