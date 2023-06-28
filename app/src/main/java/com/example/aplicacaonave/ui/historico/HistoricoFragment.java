package com.example.aplicacaonave.ui.historico;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aplicacaonave.databinding.FragmentHistoricoBinding;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import domain.Carro;
import domain.CarroBmw;
import domain.CarroGol;
import domain.CarroGolf;


public class HistoricoFragment extends Fragment {

    private RecyclerView recyclerView;
    private CAR_Adapter adapter;
    private ArrayList<Carro> carros = new ArrayList<>();
    private FragmentHistoricoBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //HistoricoViewModel historicoViewModel =
          //      new ViewModelProvider(this).get(HistoricoViewModel.class);

        binding = FragmentHistoricoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textHistorico;

        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        carros.add(new CarroGolf());
        carros.add(new CarroGol());
        carros.add(new CarroBmw());

        adapter = new CAR_Adapter(this.getContext(), carros); // Replace 'CAR_Adapter' with your own adapter class
        recyclerView.setAdapter(adapter);

        //historicoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}