package com.example.aplicacaonave.ui.historico;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import service.MockAlugueisService;

public class HistoricoViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public HistoricoViewModel() {
        // Instancia a classe com gerador de numero de alugueis por dia
        MockAlugueisService alugueisService = new MockAlugueisService();
        mText = new MutableLiveData<>();

        mText.setValue("Hoje já impactamos positivamente um total de: " + alugueisService.gerarQuantidadeAlugueisDiarios() + " pessoas com nossa empresa");
    }

    public LiveData<String> getText() {
        return mText;
    }
}