package com.example.aplicacaonave.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import service.TextosAdicionais;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SlideshowViewModel() {

        // Instancia a classe com stringbuilder contendo o texto da missão
        TextosAdicionais nossaMissao = new TextosAdicionais();
        mText = new MutableLiveData<>();
        mText.setValue(nossaMissao.montaTextoNossaMissao().toString());
    }

    public LiveData<String> getText() {
        return mText;
    }
}