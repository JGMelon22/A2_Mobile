package com.example.aplicacaonave.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import service.TextosAdicionaisService;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SlideshowViewModel() {

        // Instancia a classe com stringbuilder contendo o texto da missão
        TextosAdicionaisService nossaMissao = new TextosAdicionaisService();
        mText = new MutableLiveData<>();
        mText.setValue(nossaMissao.montaTextoNossaMissao().toString());
    }

    public LiveData<String> getText() {
        return mText;
    }
}